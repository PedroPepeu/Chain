package br.com.api.chain.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.chain.entities.Anotacao;
import br.com.api.chain.entities.Atividade;
import br.com.api.chain.entities.Cargo;
import br.com.api.chain.entities.EngenheiroDeSoftware;
import br.com.api.chain.entities.Membro;
import br.com.api.chain.entities.Projeto;
import br.com.api.chain.repositories.EngenheiroDeSoftwareRepository;
import br.com.api.chain.services.exceptions.EmailNotFoundException;
import br.com.api.chain.services.exceptions.ResourceNotFoundException;

@Service
public class EngenheiroDeSoftwareService {

    private final EngenheiroDeSoftwareRepository usuarioRepository;

    @Autowired
    public EngenheiroDeSoftwareService(EngenheiroDeSoftwareRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public List<EngenheiroDeSoftware> getEngenheiros(){
        return this.usuarioRepository.findAll();
    }

    public EngenheiroDeSoftware getUserByEmail(String email){
        EngenheiroDeSoftware eng = usuarioRepository.findByEmail(email);
        if(eng == null){
            throw new EmailNotFoundException(email);
        }
        return eng;
    }

    public EngenheiroDeSoftware getUserById(Integer id){
        Optional<EngenheiroDeSoftware> eng = usuarioRepository.findById(id);
        return eng.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public EngenheiroDeSoftware login(EngenheiroDeSoftware eng){ 
        String email = eng.getEmail(), senha = eng.getSenha();
        eng = this.getUserByEmail(email);
        if(eng.getSenha().equals(senha)){
            return eng;
        }
        else{
            throw new EmailNotFoundException(email);
        }
    }

    public EngenheiroDeSoftware insertUser(EngenheiroDeSoftware eng){
        return usuarioRepository.save(eng);
    }

    public void deleteUser(Integer id){
        usuarioRepository.deleteById(id);
    }

    public EngenheiroDeSoftware updateUser(Integer id, EngenheiroDeSoftware eng){
        EngenheiroDeSoftware entity = getUserById(id);
        if(entity != null)
        {
            updateData(eng, entity);
        }
        return eng;
        /*updateData(entity, eng);
        return usuarioRepository.save(entity);*/
    }

    private void updateData(EngenheiroDeSoftware entity, EngenheiroDeSoftware eng){
        entity.setNome(eng.getNome());
        entity.setSenha(eng.getSenha());
        // Posso colocar email se necessário, mas precisaria colocar uma verificação
        //entity.setAnotacoes(eng.getAnotacoes());
    }

    public Set<Atividade> getUserActivities(Integer id){
        EngenheiroDeSoftware eng = this.getUserById(id);
        return eng.getAtividades();
    }

    public List<Projeto> getUserProjects(Integer id){
        EngenheiroDeSoftware eng = this.getUserById(id);
        return eng.getProjetos();
    }

    public List<Projeto> getUserParticipations(Integer id){
        EngenheiroDeSoftware eng = this.getUserById(id);
        List<Membro> part = eng.getParticipa();
        return getListProjetos(part);
    }

    private List<Projeto> getListProjetos(List<Membro> part){
        List<Projeto> proj = new ArrayList<>();
        for(int i = 0; i < part.size(); i++){
            proj.add(part.get(i).getProjetoId());
        }
        return proj;
    }

    public List<Anotacao> getUserAnotations(Integer id){
        EngenheiroDeSoftware eng = this.getUserById(id);
        return eng.getAnotacoes();
    }

    public Anotacao insertUserAnotation(Integer id, Anotacao anot){
        EngenheiroDeSoftware eng = this.getUserById(id);
        List<Anotacao> anotacoes = eng.getAnotacoes();
        anotacoes.add(anot);
        //eng.setAnotacoes(anotacoes); Funciona mesmo sem, testei só pra ter certeza
        //updateUser(eng.getId(), eng);
        return anot;
    }

    public Projeto insertUserProject(Integer id, Projeto proj){
        EngenheiroDeSoftware eng = this.getUserById(id);
        List<Projeto> projetos = eng.getProjetos();
        projetos.add(proj);
        return proj;
    }

    public Atividade insertUserIntoActivity(Integer id, Projeto proj, Atividade ativ, String otherEmail){
        Integer otherId = this.getUserByEmail(otherEmail).getId();
        List<Membro> membros = proj.getMembros();
        boolean membroDoProjeto = verificarSeMembro(membros, otherId);
        Integer idAdmin = proj.getAdministradorId().getId();

        if(!membroDoProjeto){
            return null;
        }
        else if(id == otherId || id == idAdmin){
            Set<EngenheiroDeSoftware> engenheiros = ativ.getEngenheiros();
            EngenheiroDeSoftware eng = this.getUserById(otherId);
            eng.getAtividades().add(ativ);
            engenheiros.add(eng);
            return ativ;
        }
        else{
            return null;
        }
        //return ativ; // depois tirar 
    }

    private boolean verificarSeMembro(List<Membro> membros, Integer otherId){
        boolean membroDoProjeto = false;
        if(membros != null){
            for(int i = 0; i < membros.size(); i++){
                if(membros.get(i).getEngenheiroId().getId() == otherId){
                    membroDoProjeto = true;
                }
            }
        }
        return membroDoProjeto;
    }

    public Membro insertMember(Integer id, String email, Projeto proj, Cargo cargo){
        Membro mem = new Membro();
        EngenheiroDeSoftware eng = getUserByEmail(email);
        Integer idAdmin = proj.getAdministradorId().getId();
        if(id == idAdmin){
            mem = new Membro(eng.getId(), eng, proj, cargo);
            eng.getParticipa().add(mem);
            return mem;
        }
        else{
            // jogar exception
        }
        return mem; // depois tirar
    }

    public List<Atividade> getUserProjectActivities(Integer id, Projeto proj){ // VER VALIDAÇÕES
        List<Atividade> atividades = proj.getAtividades();
        EngenheiroDeSoftware eng = getUserById(id);
        return searchUserActivities(atividades, eng);
    }

    private List<Atividade> searchUserActivities(List<Atividade> atividades, EngenheiroDeSoftware eng){
        List<Atividade> res = new ArrayList<>();
        Atividade x;
        Set<EngenheiroDeSoftware> s = new HashSet<>();
        for(int i = 0; i < atividades.size(); i++){
            x = atividades.get(i);
            s = x.getEngenheiros();
            if(s.size() > 0 && s.contains(eng)){
                res.add(x);
            }
        }
        return res;
    }

    public void userUpdateProject(Integer id, Projeto proj){
        if(!verifyIfAdmin(id, proj)){
            // throw exception
        }
    }

    public boolean verifyIfAdmin(Integer id, Projeto proj){
        if(id == proj.getAdministradorId().getId()){
            return true;
        }
        return false;
    }
}
