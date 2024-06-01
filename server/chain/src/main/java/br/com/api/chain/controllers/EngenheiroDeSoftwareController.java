package br.com.api.chain.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.chain.entities.EngenheiroDeSoftware;
import br.com.api.chain.repositories.EngenheiroDeSoftwareRepository;

@RestController
public class EngenheiroDeSoftwareController {
    private final EngenheiroDeSoftwareRepository usuarioRepositorio;

    @Autowired
    public EngenheiroDeSoftwareController(EngenheiroDeSoftwareRepository usuarioRepositorio){
        this.usuarioRepositorio = usuarioRepositorio;
    }

    @GetMapping("/users")
    public List<EngenheiroDeSoftware> engenheiroDeSoftwares(){
        return usuarioRepositorio.findAll();
    }

    /*@GetMapping("/users/{id}")
    public*/ 
}