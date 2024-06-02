package br.com.api.chain.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.chain.entities.Anotacao;
import br.com.api.chain.services.AnotacaoService;

@RestController
@RequestMapping("/anotations")
public class AnotacaoController {
    
    private final AnotacaoService anotacaoService;

    @Autowired
    public AnotacaoController(AnotacaoService anotacaoService){
        this.anotacaoService = anotacaoService;
    }

    /*@GetMapping("/")
    public List<Anotacao> getAnotacoes(){
        return anotacaoRepository.findAll();
    }*/
}