package br.com.api.chain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.api.chain.entities.Link;

@Repository
public interface LinkRepository extends JpaRepository<Link, Integer>{
}