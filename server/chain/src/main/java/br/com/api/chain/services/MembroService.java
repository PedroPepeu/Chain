package br.com.api.chain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.chain.entities.Membro;
import br.com.api.chain.entities.Projeto;
import br.com.api.chain.repositories.MembroRepository;
import br.com.api.chain.services.exceptions.ResourceNotFoundException;

@Service
public class MembroService {
    
    private final MembroRepository membroRepository;

    @Autowired
    public MembroService(MembroRepository membroRepository){
        this.membroRepository = membroRepository;
    }

    public List<Membro> getMembros(){
        return membroRepository.findAll();
    }

    public Membro getMembers(Integer id){
        Optional<Membro> mem = membroRepository.findById(id);
        return mem.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Membro insertMembers(Membro mem){
        return membroRepository.save(mem);
    }

    public void deleteMembers(Integer id){
        membroRepository.deleteById(id);
    }

    public Membro updateMembers(Integer id, Membro mem){
        Membro entity = membroRepository.getReferenceById(id);
        updateData(entity, mem);
        return membroRepository.save(entity);
    }

    private void updateData(Membro entity, Membro mem){
        entity.setCargo(mem.getCargo());
    }

}
