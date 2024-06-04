package br.com.api.chain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.chain.entities.Link;
import br.com.api.chain.repositories.LinkRepository;
import br.com.api.chain.services.exceptions.ResourceNotFoundException;

@Service
public class LinkService {

    private final LinkRepository linkRepository;

    @Autowired
    public LinkService(LinkRepository linkRepository){
        this.linkRepository = linkRepository;
    }

    public List<Link> getLinks(){
        return this.linkRepository.findAll();
    }

    public Link getLink(Integer id){
        Optional<Link> link = linkRepository.findById(id);
        return link.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Link insertLink(Link link){
        return linkRepository.save(link);
    }

    public void deleteLink(Integer id){
        linkRepository.deleteById(id);
    }

    public Link updateLink(Integer id, Link link){
        Link entity = linkRepository.getReferenceById(id);
        updateData(entity, link);
        return linkRepository.save(entity);
    }

    private void updateData(Link entity, Link link){
        //entity
    }
}
