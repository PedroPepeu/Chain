package br.com.api.chain.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.chain.entities.Atividade;
import br.com.api.chain.entities.EngenheiroDeSoftware;
import br.com.api.chain.repositories.AtividadeRepository;
import br.com.api.chain.services.exceptions.InvalidDateException;
import br.com.api.chain.services.exceptions.ResourceNotFoundException;

@Service
public class AtividadeService {
    
    private final AtividadeRepository atividadeRepository;

    @Autowired
    public AtividadeService(AtividadeRepository atividadeRepository){
        this.atividadeRepository = atividadeRepository;
    }

    public List<Atividade> getAtividades(){
        return this.atividadeRepository.findAll();
    }

    public Atividade getActivity(Integer id){
        Optional<Atividade> ativ = atividadeRepository.findById(id);
        return ativ.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Atividade insertActivity(Atividade ativ){
        this.validacaoDataInicio(ativ.getDataInicio());
        this.validacaoDataEntrega(ativ.getDataInicio(), ativ.getDataEntrega());
        return atividadeRepository.save(ativ);
    }

    public void deleteActivity(Integer id){
        atividadeRepository.deleteById(id);
    }

    public Atividade updateActivity(Integer id, Atividade ativ){
        Atividade entity = atividadeRepository.getReferenceById(id);
        updateData(entity, ativ);
        return atividadeRepository.save(entity);
    }

    private void updateData(Atividade entity, Atividade ativ){
        entity.setDescricao(ativ.getDescricao());
        entity.setConcluida(ativ.isConcluida());
        entity.setDataEntrega(ativ.getDataEntrega());
        entity.setDataInicio(ativ.getDataInicio());
        entity.setNome(ativ.getNome());
    }

    private void validacaoDataInicio(LocalDate dataDeInicio){
        LocalDate agora = LocalDate.now();
        if(dataDeInicio.isBefore(agora)){
            throw new InvalidDateException();
        }
    }

    private void validacaoDataEntrega(LocalDate dataDeInicio, LocalDate dataDeEntrega){
        LocalDate agora = LocalDate.now();
        if(dataDeEntrega.isBefore(agora) || dataDeEntrega.isBefore(dataDeInicio)){
            throw new InvalidDateException();
        }
    }

    public Atividade updateUsers(Atividade ativ){
        return atividadeRepository.save(ativ);
    }

    public Set<EngenheiroDeSoftware> getMembersOfActivity(Integer id){
        Atividade ativ = this.getActivity(id);
        return ativ.getEngenheiros();
    }
}
