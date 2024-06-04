package br.com.api.chain.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.chain.entities.Anotacao;
import br.com.api.chain.entities.Atividade;
import br.com.api.chain.entities.EngenheiroDeSoftware;
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
        if(eng.getId() == null){
            throw new EmailNotFoundException(email);
        }
        return eng;
    }

    public EngenheiroDeSoftware getUserById(Integer id){
        Optional<EngenheiroDeSoftware> eng = usuarioRepository.findById(id);
        return eng.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public EngenheiroDeSoftware login(EngenheiroDeSoftware eng){ // Ver como fazer o exception funcionar
        String email = eng.getEmail(), senha = eng.getSenha();
        try {
            eng = usuarioRepository.findByEmail(email);
            if(eng.getSenha().equals(senha)){
                return eng;
            }
            else{
                throw new EmailNotFoundException(email);
            }
        } catch (EmailNotFoundException e) {
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
        EngenheiroDeSoftware entity = usuarioRepository.getReferenceById(id);
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
}
