package br.com.api.chain.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.chain.entities.EngenheiroDeSoftware;
import br.com.api.chain.repositories.EngenheiroDeSoftwareRepository;

@Service
public class EngenheiroDeSoftwareService {

    private final EngenheiroDeSoftwareRepository usuarioRepositorio;

    @Autowired
    public EngenheiroDeSoftwareService(EngenheiroDeSoftwareRepository usuarioRepositorio){
        this.usuarioRepositorio = usuarioRepositorio;
    }

    public EngenheiroDeSoftware getUserByEmail(String email){
        return usuarioRepositorio.findByEmail(email);
    }

    public EngenheiroDeSoftware getUserById(Integer id){
        Optional<EngenheiroDeSoftware> eng = usuarioRepositorio.findById(id);
        return eng.get();
    }
}
