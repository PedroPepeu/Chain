package br.com.api.chain.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.chain.entities.Atividade;
import br.com.api.chain.entities.EngenheiroDeSoftware;
import br.com.api.chain.services.AtividadeService;

@RestController
@RequestMapping("/activities")
public class AtividadeController {
    
    private final AtividadeService atividadeService;

    @Autowired
    public AtividadeController(AtividadeService atividadeService){
        this.atividadeService = atividadeService;
    }

    @GetMapping("/ALL")
    public List<Atividade> getAtividades(){
        return atividadeService.getAtividades();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Set<EngenheiroDeSoftware>> getMembersOfActivity(@PathVariable Integer id){
        Set<EngenheiroDeSoftware> eng = atividadeService.getMembersOfActivity(id);
        return ResponseEntity.ok().body(eng);
    }
}