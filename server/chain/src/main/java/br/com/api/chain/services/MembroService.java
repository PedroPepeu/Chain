package br.com.api.chain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.chain.entities.Membro;
import br.com.api.chain.repositories.MembroRepository;

@Service
public class MembroService {
    
    private final MembroRepository membroRepository;

    @Autowired
    public MembroService(MembroRepository membroRepository){
        this.membroRepository = membroRepository;
    }

    public List<Membro> getMembers(){
        return membroRepository.findAll();
    }
}
