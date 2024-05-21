package br.com.api.chain.controllers;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.api.chain.repositories.LinkRepository;
import br.com.api.chain.entities.Link;

@Repository
public class LinkController {
    public LinkRepository Link;

    public LinkController(LinkRepository Link){
        this.Link = Link;
    }

    @GetMapping("/link")
    public List<Link> getLinks(){
        return Link.findAll();
    }
}