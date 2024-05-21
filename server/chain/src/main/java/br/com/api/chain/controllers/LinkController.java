package br.com.api.chain.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.chain.repositories.LinkRepository;
import br.com.api.chain.entities.Link;

@RestController
public class LinkController {
    public LinkRepository Link;

    public LinkController(LinkRepository Link){
        this.Link = Link;
    }

    @GetMapping("/link")
    public List<Link> getLinks(){
        return Link.findAll();
    }

    @PostMapping("/link")
    public List<Link> createProject(@RequestBody Link newLink) {
        Link.save(newLink);
        return Link.findAll();
    }

    @PutMapping("/link/{id}")
    public List<Link> updateUsuario(@RequestBody Link updateLink, @PathVariable String id) {
        Link.findById(id)
            .map(link -> {
                link.setDescricao(updateLink.getDescricao());
                link.setUrl(updateLink.getUrl());
                return Link.save(link);
            });

        return Link.findAll();
    }

    @DeleteMapping("/link/{id}")
    public List<Link> deleteProject(@PathVariable String id) {
        Link.deleteById(id);
        return Link.findAll();
    }
}