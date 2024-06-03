package br.com.api.chain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.chain.entities.Anotacao;
import br.com.api.chain.repositories.AnotacaoRepository;
import br.com.api.chain.services.exceptions.ResourceNotFoundException;

@Service
public class AnotacaoService {
    
    private final AnotacaoRepository anotacaoRepository;

    @Autowired
    public AnotacaoService(AnotacaoRepository anotacaoRepository){
        this.anotacaoRepository = anotacaoRepository;
    }

    public List<Anotacao> getAnotacoes(){
        return this.anotacaoRepository.findAll();
    }

    public Anotacao getAnotation(Integer id){
        Optional<Anotacao> anot = anotacaoRepository.findById(id);
        return anot.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Anotacao insertAnotation(Anotacao anot){
        return anotacaoRepository.saveOrUpdate(anot);
    }

    public void deleteAnotation(Integer id){
        anotacaoRepository.deleteById(id);
    }

    public Anotacao updateAnotation(Integer id, Anotacao anot){
        Anotacao entity = anotacaoRepository.getReferenceById(id);
        updateData(entity, anot);
        return anotacaoRepository.save(entity);
    }

    private void updateData(Anotacao entity, Anotacao anot){
        entity.setTexto(anot.getTexto());
        entity.setDataAnotacao(anot.getDataAnotacao());
    }
}
