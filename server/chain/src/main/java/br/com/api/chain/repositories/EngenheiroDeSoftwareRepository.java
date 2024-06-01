package br.com.api.chain.repositories;

import br.com.api.chain.entities.EngenheiroDeSoftware;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EngenheiroDeSoftwareRepository extends JpaRepository<EngenheiroDeSoftware, Integer>{

    EngenheiroDeSoftware findByEmail(String email);

}