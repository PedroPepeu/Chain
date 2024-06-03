package br.com.api.chain.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.chain.entities.Membro;
import br.com.api.chain.services.MembroService;

@RestController
@RequestMapping("/members")
public class MembroController {
    
    private final MembroService membroService;

    @Autowired
    public MembroController(MembroService membroService) {
        this.membroService = membroService;
    }

    @GetMapping(value = "/ALL") // TESTES
    public ResponseEntity<List<Membro>> getMembers(){
        return ResponseEntity.ok().body(membroService.getMembers());
    }
}
