package br.com.api.chain.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.api.chain.entities.Atividade;
import br.com.api.chain.entities.Link;
import br.com.api.chain.entities.Membro;
import br.com.api.chain.entities.Projeto;
import br.com.api.chain.repositories.AtividadeRepository;
import br.com.api.chain.repositories.LinkRepository;
import br.com.api.chain.services.AtividadeService;
import br.com.api.chain.services.LinkService;
import br.com.api.chain.services.ProjetoService;

@RestController
@RequestMapping("/projects")
public class ProjetoController {

    private final ProjetoService projetoService;
    private final AtividadeService atividadeService;
    private final LinkService linkService;

    @Autowired
    public ProjetoController(ProjetoService projetoService, AtividadeRepository atividadeRepository, LinkRepository linkRepository){
        this.projetoService = projetoService;
        this.atividadeService = new AtividadeService(atividadeRepository);
        this.linkService = new LinkService(linkRepository);
    }

    @GetMapping("/ALL")
    public List<Projeto> getProjeto(){
        return projetoService.getProjetos();
    }

    @GetMapping("/{id}/html")
    public ClassPathResource Profile(){
        return new ClassPathResource("templates/projects.html");
    }

    @GetMapping(value = "/{id}")
    public Projeto getProjectById(@PathVariable Integer id){
        return projetoService.getProject(id);
    }

    @GetMapping(value = "{id}/members")
    public ResponseEntity<List<Membro>> getMembers(@PathVariable Integer id){
        List<Membro> mem = projetoService.getMembers(id);
        return ResponseEntity.ok().body(mem);
    }

    @GetMapping(value = "/{id}/activities")
    public ResponseEntity<List<Atividade>> getActivities(@PathVariable Integer id){
        List<Atividade> ativ = projetoService.getActivities(id);
        return ResponseEntity.ok().body(ativ);
    }

    @GetMapping(value = "/{id}/links")
    public ResponseEntity<List<Link>> getLinks(@PathVariable Integer id){
        List<Link> li = projetoService.getLinks(id);
        return ResponseEntity.ok().body(li);
    }

    @PostMapping(value = "/{id}/activity")
    public ResponseEntity<Atividade> insertActivity(@PathVariable Integer id, @RequestBody Atividade ativ){
        ativ = projetoService.insertActivity(id, ativ);
        ativ = atividadeService.insertActivity(ativ);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(ativ.getId()).toUri();
        return ResponseEntity.created(uri).body(ativ);
    }

    @PostMapping(value = "/{id}/links")
    public ResponseEntity<Link> insertLink(@PathVariable Integer id, @RequestBody Link li){
        li = projetoService.insertLink(id, li);
        li = linkService.insertLink(li);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(li.getId()).toUri();
        return ResponseEntity.created(uri).body(li);
    }

    @PutMapping(value = "/{id}/activity")
    public ResponseEntity<Atividade> updateActivity(@PathVariable Integer id, @RequestBody Atividade ativ){
        //projetoService.updateActivity(id);
        ativ = atividadeService.updateActivity(ativ.getId(), ativ);
        return ResponseEntity.ok().body(ativ);
    }

}