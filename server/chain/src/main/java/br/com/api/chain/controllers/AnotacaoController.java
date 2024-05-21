package br.com.api.chain.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.chain.entities.Anotacao;
import br.com.api.chain.repositories.AnotacaoRepository;

@RestController
public class AnotacaoController {
    
    public AnotacaoRepository Anotacao;

    public AnotacaoController(AnotacaoRepository anotacao) {
        this.Anotacao = anotacao;
    }
    
    @GetMapping("/anotacao")
    public List<Anotacao> getAnotacao(){
        return Anotacao.findAll();
    }

    @PostMapping("/anotacao")
    public List<Anotacao> createAnotacao(@RequestBody Anotacao newAnotacao){
        Anotacao.save(newAnotacao);
        return Anotacao.findAll();
    }

    @PutMapping("/anotacao/{id}")
    public List<Anotacao> updateAnotacao(@RequestBody Anotacao updateAnotacao, @PathVariable String id){
        Anotacao.findById(id)
            .map(anotacao -> {
                anotacao.setDate(updateAnotacao.getDate());
                anotacao.setTexto(updateAnotacao.getTexto());
                return Anotacao.save(anotacao);
            });

        return Anotacao.findAll();
    }

    @DeleteMapping("/anotacao/{id}")
    public List<Anotacao> deleteAnotacao(@PathVariable String id){
        Anotacao.deleteById(id);
        return Anotacao.findAll();
    }

}
