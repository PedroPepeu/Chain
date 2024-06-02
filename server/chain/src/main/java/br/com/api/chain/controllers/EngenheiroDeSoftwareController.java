package br.com.api.chain.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.api.chain.entities.EngenheiroDeSoftware;
import br.com.api.chain.services.EngenheiroDeSoftwareService;

@RestController
@RequestMapping("/users")
public class EngenheiroDeSoftwareController {

    private final EngenheiroDeSoftwareService usuarioService;

    @Autowired
    public EngenheiroDeSoftwareController(EngenheiroDeSoftwareService usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping("/ALL") // SÓ PRA TESTES
    public List<EngenheiroDeSoftware> engenheiroDeSoftwares(){
        return this.usuarioService.getEngenheiros();
    }

    @GetMapping("/{email}")
    public ResponseEntity<EngenheiroDeSoftware> getUserByEmail(@PathVariable String email){
        EngenheiroDeSoftware eng = usuarioService.getUserByEmail(email);
        return ResponseEntity.ok().body(eng);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<EngenheiroDeSoftware> getUserById(@PathVariable Integer id){
        EngenheiroDeSoftware eng = usuarioService.getUserById(id);
        return ResponseEntity.ok().body(eng);
    }

    @PostMapping
    public ResponseEntity<EngenheiroDeSoftware> insertUser(@RequestBody EngenheiroDeSoftware eng){
        eng = usuarioService.insertUser(eng);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id/{id}")
                .buildAndExpand(eng.getId()).toUri();
        return ResponseEntity.created(uri).body(eng);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id){
        usuarioService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<EngenheiroDeSoftware> updateUser(@PathVariable Integer id, @RequestBody EngenheiroDeSoftware eng){
        eng = usuarioService.updateUser(id, eng);
        return ResponseEntity.ok().body(eng);
    }
}