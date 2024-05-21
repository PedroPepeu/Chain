package br.com.api.chain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.api.chain.entities.Project;

public interface ProjectRespository extends JpaReposotory<Project, String> {
    
}
