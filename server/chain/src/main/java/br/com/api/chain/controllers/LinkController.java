package br.com.api.chain.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.chain.repositories.LinkRepository;

import br.com.api.chain.entities.Link;

@RestController
public class LinkController {
    private final LinkRepository linkRepository;

    @Autowired
    public LinkController(LinkRepository linkRepository){
        this.linkRepository = linkRepository;
    }

    @GetMapping("/links")
    public List<Link> getLinks(){
        return linkRepository.findAll();
    }
}