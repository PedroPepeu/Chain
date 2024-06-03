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

    private final EngenheiroDeSoftwareRepository usuarioRepositorio;

    @Autowired
    public EngenheiroDeSoftwareService(EngenheiroDeSoftwareRepository usuarioRepositorio){
        this.usuarioRepositorio = usuarioRepositorio;
    }

    public List<EngenheiroDeSoftware> getEngenheiros(){
        return this.usuarioRepositorio.findAll();
    }

    public EngenheiroDeSoftware getUserByEmail(String email){
        EngenheiroDeSoftware eng = usuarioRepositorio.findByEmail(email);
        if(eng.getId() == null){
            throw new EmailNotFoundException(email);
        }
        return eng;
    }

    public EngenheiroDeSoftware getUserById(Integer id){
        Optional<EngenheiroDeSoftware> eng = usuarioRepositorio.findById(id);
        return eng.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public EngenheiroDeSoftware login(EngenheiroDeSoftware eng){
        String email = eng.getEmail();
        String senha = eng.getSenha();

        eng = usuarioRepositorio.findByEmail(email);

        if(eng == null){ // A validação não está funcionando aqui
            throw new EmailNotFoundException(email);
        }
        else if(eng.getSenha().equals(senha)){
            // jogar uma exceção
            throw new EmailNotFoundException(email);   
        }
        else{
            return eng;
        }
    }

    public EngenheiroDeSoftware insertUser(EngenheiroDeSoftware eng){
        return usuarioRepositorio.save(eng);
    }

    public void deleteUser(Integer id){
        usuarioRepositorio.deleteById(id);
    }

    public EngenheiroDeSoftware updateUser(Integer id, EngenheiroDeSoftware eng){
        EngenheiroDeSoftware entity = usuarioRepositorio.getReferenceById(id);
        updateData(entity, eng);
        return usuarioRepositorio.save(entity);
    }

    private void updateData(EngenheiroDeSoftware entity, EngenheiroDeSoftware eng){
        entity.setNome(eng.getNome());
        entity.setEmail(eng.getEmail());
        entity.setSenha(eng.getSenha());
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
        // Como salvar isso
        anotacoes.add(anot);
        eng.setAnotacoes(anotacoes);
        return anot;
    }
}
