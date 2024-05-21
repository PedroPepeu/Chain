package br.com.api.chain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.api.chain.entities.Atividade;

public interface AtividadeRepository extends JpaRepository<Atividade, String>{
    
}
