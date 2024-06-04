package br.com.api.chain.controllers;

import java.net.URI;
import java.util.List;
import java.util.Set;

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

import br.com.api.chain.entities.Anotacao;
import br.com.api.chain.entities.Atividade;
import br.com.api.chain.entities.EngenheiroDeSoftware;
import br.com.api.chain.entities.Projeto;
import br.com.api.chain.repositories.AnotacaoRepository;
import br.com.api.chain.repositories.ProjetoRepository;
import br.com.api.chain.services.AnotacaoService;
import br.com.api.chain.services.EngenheiroDeSoftwareService;
import br.com.api.chain.services.ProjetoService;

@RestController
@RequestMapping("/users")
public class EngenheiroDeSoftwareController {

    private final EngenheiroDeSoftwareService usuarioService;
    private final AnotacaoService anotacaoService;
    private final ProjetoService projetoService;

    /*@Autowired
    public EngenheiroDeSoftwareController(EngenheiroDeSoftwareService usuarioService){
        this.usuarioService = usuarioService;
    }*/

    @Autowired
    public EngenheiroDeSoftwareController(EngenheiroDeSoftwareService usuarioService, AnotacaoRepository anotacaoRepository, ProjetoRepository projetoRepository){
        this.usuarioService = usuarioService;
        this.anotacaoService = new AnotacaoService(anotacaoRepository);
        this.projetoService = new ProjetoService(projetoRepository); 
    }

    @GetMapping("/ALL") // SÓ PRA TESTES
    public List<EngenheiroDeSoftware> engenheiroDeSoftwares(){
        return this.usuarioService.getEngenheiros();
    }

    /*@GetMapping("/{email}")
    public ResponseEntity<EngenheiroDeSoftware> getUserByEmail(@PathVariable String email){
        EngenheiroDeSoftware eng = usuarioService.getUserByEmail(email);
        return ResponseEntity.ok().body(eng);
    }*/

    // Usuário em geral

    @GetMapping("/{id}")
    public ResponseEntity<EngenheiroDeSoftware> getUserById(@PathVariable Integer id){
        EngenheiroDeSoftware eng = usuarioService.getUserById(id);
        return ResponseEntity.ok().body(eng);
    }

    @GetMapping(value = "/login")
    public ResponseEntity<EngenheiroDeSoftware> login(@RequestBody EngenheiroDeSoftware eng){
        eng = usuarioService.login(eng);
        return ResponseEntity.ok().body(eng);
    }

    @PostMapping
    public ResponseEntity<EngenheiroDeSoftware> insertUser(@RequestBody EngenheiroDeSoftware eng){ // cadastrar
        eng = usuarioService.insertUser(eng);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
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

    // Atividades

    @GetMapping(value = "/{id}/activities")
    public ResponseEntity<Set<Atividade>> getUserActivities(@PathVariable Integer id){
        Set<Atividade> ativ = usuarioService.getUserActivities(id);
        return ResponseEntity.ok().body(ativ);
    }

    // Projetos

    @GetMapping(value = "/{id}/myProjects") // Será que seria melhor retornar os projetos que ele faz parte também ?
    public ResponseEntity<List<Projeto>> getUserProjects(@PathVariable Integer id){
        List<Projeto> proj = usuarioService.getUserProjects(id);
        return ResponseEntity.ok().body(proj);
    }

    @PostMapping(value = "/{id}/myProjects")
    public ResponseEntity<Projeto> insertUserProject(@PathVariable Integer id, @RequestBody Projeto proj){
        proj = usuarioService.insertUserProject(id, proj);
        projetoService.insertProject(proj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(proj.getId()).toUri();
        return ResponseEntity.created(uri).body(proj);
    }

    // Anotações

    @GetMapping(value = "/{id}/anotations")
    public ResponseEntity<List<Anotacao>> getUserAnotations(@PathVariable Integer id){
        List<Anotacao> anot = usuarioService.getUserAnotations(id);
        return ResponseEntity.ok().body(anot);
    }

    @PostMapping(value = "/{id}/anotations")
    public ResponseEntity<Anotacao> insertUserAnotation(@PathVariable Integer id, @RequestBody Anotacao anot){
        anot = usuarioService.insertUserAnotation(id, anot);
        anotacaoService.insertAnotation(anot);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(anot.getId()).toUri();
        return ResponseEntity.created(uri).body(anot);
    }
}