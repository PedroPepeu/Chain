package br.com.api.chain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.chain.repositories.AnotacaoRepository;

@Service
public class AnotacaoService {
    
    private final AnotacaoRepository anotacaoRepository;

    @Autowired
    public AnotacaoService(AnotacaoRepository anotacaoRepository){
        this.anotacaoRepository = anotacaoRepository;
    }
}
