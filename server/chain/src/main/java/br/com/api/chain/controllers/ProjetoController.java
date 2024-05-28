package br.com.api.chain.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.chain.entities.Projeto;
import br.com.api.chain.repositories.ProjetoRepository;

@RestController
public class ProjetoController {
    private final ProjetoRepository projetoRepository;

    @Autowired
    public ProjetoController(ProjetoRepository projetoRepository){
        this.projetoRepository = projetoRepository;
    }

    @GetMapping("/projects")
    public List<Projeto> getProjeto(){
        return projetoRepository.findAll();
    }
}