package br.com.api.chain.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.api.chain.entities.Atividade;
import br.com.api.chain.entities.Membro;
import br.com.api.chain.entities.Projeto;
import br.com.api.chain.repositories.AtividadeRepository;
import br.com.api.chain.services.AtividadeService;
import br.com.api.chain.services.ProjetoService;

@RestController
@RequestMapping("/projects")
public class ProjetoController {

    private final ProjetoService projetoService;
    private final AtividadeService atividadeService;

    @Autowired
    public ProjetoController(ProjetoService projetoService, AtividadeRepository atividadeRepository){
        this.projetoService = projetoService;
        this.atividadeService = new AtividadeService(atividadeRepository);
    }

    @GetMapping("/ALL")
    public List<Projeto> getProjeto(){
        return projetoService.getProjetos();
    }

    @GetMapping(value = "{id}/members")
    public ResponseEntity<List<Membro>> getMembers(@PathVariable Integer id){
        List<Membro> mem = projetoService.getMembers(id);
        return ResponseEntity.ok().body(mem);
    }

    @PostMapping(value = "/{id}/activity")
    public ResponseEntity<Atividade> insertActivity(@PathVariable Integer id, @RequestBody Atividade ativ){
        ativ = projetoService.insertActivity(id, ativ);
        atividadeService.insertActivity(ativ);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(ativ.getId()).toUri();
        return ResponseEntity.created(uri).body(ativ);
    }

    //@PostMapping(value = "/{id}/links")
}