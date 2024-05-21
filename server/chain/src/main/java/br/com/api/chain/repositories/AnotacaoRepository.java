package br.com.api.chain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.api.chain.entities.Anotacao;

public interface AnotacaoRepository extends JpaRepository<Anotacao, String>{
    
}
