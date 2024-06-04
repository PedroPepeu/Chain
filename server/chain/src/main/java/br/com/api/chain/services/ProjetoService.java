package br.com.api.chain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.chain.entities.Projeto;
import br.com.api.chain.repositories.ProjetoRepository;
import br.com.api.chain.services.exceptions.ResourceNotFoundException;

@Service
public class ProjetoService {
    private final ProjetoRepository projetoRepository;

    @Autowired
    public ProjetoService(ProjetoRepository projetoRepository){
        this.projetoRepository = projetoRepository;
    }

    public List<Projeto> getProjetos(){
        return this.projetoRepository.findAll();
    }

    public Projeto getProject(Integer id){
        Optional<Projeto> proj = projetoRepository.findById(id);
        return proj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Projeto insertProject(Projeto proj){
        return projetoRepository.save(proj);
    }

    public void deleteProject(Integer id){
        projetoRepository.deleteById(id);
    }

    public Projeto updateProject(Integer id, Projeto proj){
        Projeto entity = projetoRepository.getReferenceById(id);
        updateData(entity, proj);
        return projetoRepository.save(entity);
    }

    private void updateData(Projeto entity, Projeto proj){
        entity.setNome(proj.getNome());
    }
}
