package br.com.api.chain.services;

import java.util.List;
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

    public List<EngenheiroDeSoftware> getEngenheiros(){
        return this.usuarioRepositorio.findAll();
    }

    public EngenheiroDeSoftware getUserByEmail(String email){
        return usuarioRepositorio.findByEmail(email);
    }

    public EngenheiroDeSoftware getUserById(Integer id){
        Optional<EngenheiroDeSoftware> eng = usuarioRepositorio.findById(id);
        return eng.get();
    }

    public EngenheiroDeSoftware insertUser(EngenheiroDeSoftware eng){
        return usuarioRepositorio.save(eng);
    }

    public void deleteUser(Integer id){
        usuarioRepositorio.deleteById(id);
    }

    public EngenheiroDeSoftware updateUser(Integer id, EngenheiroDeSoftware eng){
        EngenheiroDeSoftware entity = usuarioRepositorio.getReferenceById(id);
        updateData(entity, eng);
        return usuarioRepositorio.save(entity);
    }

    private void updateData(EngenheiroDeSoftware entity, EngenheiroDeSoftware eng){
        entity.setNome(eng.getNome());
        entity.setEmail(eng.getEmail());
        entity.setSenha(eng.getSenha());
    }
}
