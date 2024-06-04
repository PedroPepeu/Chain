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

    public EngenheiroDeSoftware login(EngenheiroDeSoftware eng){
        String email = eng.getEmail();
        String senha = eng.getSenha();

        eng = usuarioRepository.findByEmail(email);

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
        entity.setEmail(eng.getEmail());
        entity.setSenha(eng.getSenha());
        entity.setAnotacoes(eng.getAnotacoes());
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
        updateUser(eng.getId(), eng);
        return anot;
    }
}
