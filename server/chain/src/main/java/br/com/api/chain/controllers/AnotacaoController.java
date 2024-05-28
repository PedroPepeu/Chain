package br.com.api.chain.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.chain.entities.Anotacao;
import br.com.api.chain.repositories.AnotacaoRepository;

@RestController
public class AnotacaoController {
    private final AnotacaoRepository anotacaoRepository;

    @Autowired
    public AnotacaoController(AnotacaoRepository anotacaoRepository){
        this.anotacaoRepository = anotacaoRepository;
    }

    @GetMapping("/anotacoes")
    public List<Anotacao> getAnotacoes(){
        return anotacaoRepository.findAll();
    }
}