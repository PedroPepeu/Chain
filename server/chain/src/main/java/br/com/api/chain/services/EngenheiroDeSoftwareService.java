package br.com.api.chain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.chain.repositories.EngenheiroDeSoftwareRepository;

@Service
public class EngenheiroDeSoftwareService {

    private final EngenheiroDeSoftwareRepository usuarioRepositorio;

    @Autowired
    public EngenheiroDeSoftwareService(EngenheiroDeSoftwareRepository usuarioRepositorio){
        this.usuarioRepositorio = usuarioRepositorio;
    }
}
