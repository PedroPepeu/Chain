package br.com.api.chain.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.chain.entities.Atividade;
import br.com.api.chain.repositories.AtividadeRepository;

@RestController
public class AtividadeController {
    
    public AtividadeRepository Atividade;

    public AtividadeController(AtividadeRepository atividade) {
        this.Atividade = atividade;
    }

    @GetMapping("/atividade")
    public List<Atividade> getAtividade(){
        return Atividade.findAll();
    }

    @PostMapping("/atividade")
    public List<Atividade> createAtividade(@RequestBody Atividade newAtividade){
        Atividade.save(newAtividade);
        return Atividade.findAll();
    }

    @PutMapping("/atividade/{id}") // Vou deixar assim por enquanto
    public List<Atividade> updateAtividade(@RequestBody Atividade updateAtividade, @PathVariable String id){
        Atividade.findById(id)
            .map(atividade -> {
                atividade.setNome(updateAtividade.getNome());
                return Atividade.save(atividade);
            });

        return Atividade.findAll();
    }

    @DeleteMapping("/atividade/{id}")
    public List<Atividade> deleteAtividade(@PathVariable String id){
        Atividade.deleteById(id);
        return Atividade.findAll();
    }
}
