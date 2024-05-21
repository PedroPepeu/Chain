package br.com.api.chain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.api.chain.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String>{

}