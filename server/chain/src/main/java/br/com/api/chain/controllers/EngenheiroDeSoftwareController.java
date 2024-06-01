package br.com.api.chain.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.chain.entities.EngenheiroDeSoftware;
import br.com.api.chain.repositories.EngenheiroDeSoftwareRepository;
import br.com.api.chain.services.EngenheiroDeSoftwareService;

@RestController
@RequestMapping("/users")
public class EngenheiroDeSoftwareController {

    private final EngenheiroDeSoftwareService usuarioService;

    @Autowired
    public EngenheiroDeSoftwareController(EngenheiroDeSoftwareService usuarioService){
        this.usuarioService = usuarioService;
    }

    /*@GetMapping("/")
    public List<EngenheiroDeSoftware> engenheiroDeSoftwares(){
        return usuarioRepositorio.findAll();
    }*/
}