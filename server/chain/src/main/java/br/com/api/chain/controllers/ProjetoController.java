package br.com.api.chain.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.chain.entities.Projeto;
import br.com.api.chain.services.ProjetoService;

@RestController
@RequestMapping("/projects")
public class ProjetoController {
    private final ProjetoService projetoService;

    @Autowired
    public ProjetoController(ProjetoService projetoService){
        this.projetoService = projetoService;
    }

    /*@GetMapping("/")
    public List<Projeto> getProjeto(){
        return projetoRepository.findAll();
    }*/
}