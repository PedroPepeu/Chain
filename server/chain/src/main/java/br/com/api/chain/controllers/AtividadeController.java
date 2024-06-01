package br.com.api.chain.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.chain.entities.Atividade;
import br.com.api.chain.repositories.AtividadeRepository;
import br.com.api.chain.services.AtividadeService;

@RestController
@RequestMapping("/activities")
public class AtividadeController {
    
    private final AtividadeService atividadeService;

    @Autowired
    public AtividadeController(AtividadeService atividadeService){
        this.atividadeService = atividadeService;
    }

    /*@GetMapping("/")
    public List<Atividade> getAtividades(){
        return atividadeRepository.findAll();
    }*/
}