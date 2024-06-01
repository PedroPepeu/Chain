package br.com.api.chain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.chain.repositories.AtividadeRepository;

@Service
public class AtividadeService {
    
    private final AtividadeRepository atividadeRepository;

    @Autowired
    public AtividadeService(AtividadeRepository atividadeRepository){
        this.atividadeRepository = atividadeRepository;
    }
}
