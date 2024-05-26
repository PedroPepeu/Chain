package br.com.api.chain.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.chain.repositories.UsuarioRepository;
import br.com.api.chain.entities.Usuario;

@RestController
public class UsuarioController {
    public UsuarioRepository Usuario;

    @Autowired
    public UsuarioController(UsuarioRepository Usuario){
        this.Usuario = Usuario;
    }

    @GetMapping("/usuario")
    public List<Usuario> getUsuario(){
        return Usuario.findAll();
    }

    @PostMapping("/usuario")
    public List<Usuario> createUsuario(@RequestBody Usuario newUsuario) {
        Usuario.save(newUsuario);
        return Usuario.findAll();
    }

    @PutMapping("/usuario/{id}")
    public List<Usuario> updateUsuario(@RequestBody Usuario updateUsuario, @PathVariable String id) {
        Usuario.findById(id)
            .map(usuario -> {
                usuario.setNome(updateUsuario.getNome());
                usuario.setSenha(updateUsuario.getSenha());
                usuario.setEmail(updateUsuario.getEmail());
                usuario.setProjetos(updateUsuario.getProjetos());
                usuario.setAtividades(updateUsuario.getAtividades());
                usuario.setCalendario(updateUsuario.getCalendario());
                return Usuario.save(usuario);
            });

        return Usuario.findAll();
    }

    @DeleteMapping("/usuario/{id}")
    public List<Usuario> deleteUsuario(@PathVariable String id) {
        Usuario.deleteById(id);
        return Usuario.findAll();
    }
}