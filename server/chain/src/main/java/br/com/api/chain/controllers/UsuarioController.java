package br.com.api.chain.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.chain.repositories.UsuarioRepository;
import br.com.api.chain.entities.Usuario;

@RestController
public class UsuarioController {
    public UsuarioRepository Usuario;

    public UsuarioController(UsuarioRepository Usuario){
        this.Usuario = Usuario;
    }

    @GetMapping("/usuario")
    public List<Usuario> getUsuario(){
        return Usuario.findAll();
    }
}