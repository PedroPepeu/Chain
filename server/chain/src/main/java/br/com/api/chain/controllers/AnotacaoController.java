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

import br.com.api.chain.entities.Anotacao;
import br.com.api.chain.services.AnotacaoService;

@RestController
@RequestMapping("/anotations")
public class AnotacaoController {
    
    private final AnotacaoService anotacaoService;

    @Autowired
    public AnotacaoController(AnotacaoService anotacaoService){
        this.anotacaoService = anotacaoService;
    }

    @GetMapping("/ALL") // TESTES
    public List<Anotacao> getAnotacoes(){
        return anotacaoService.getAnotacoes();
    }

    /*@GetMapping(value = "/{id}")
    public ResponseEntity<Anotacao> getAnotation(@PathVariable Integer id){
        Anotacao anot = anotacaoService.getAnotation(id);
        return ResponseEntity.ok().body(anot);
    }

    @PostMapping()
    public ResponseEntity<Anotacao> insertAnotation(@RequestBody Anotacao anot){
        anot = anotacaoService.insertAnotation(anot);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(anot.getId()).toUri();
        return ResponseEntity.created(uri).body(anot);
    }*/

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteAnotation(@PathVariable Integer id){
        anotacaoService.deleteAnotation(id);
        return ResponseEntity.noContent().build();
    }

    /*@PutMapping(value = "/{id}")
    public ResponseEntity<Anotacao> updateAnotation(@PathVariable Integer id, @RequestBody Anotacao anot){
        anot = anotacaoService.updateAnotation(id, anot);
        return ResponseEntity.ok().body(anot);
    }*/
}