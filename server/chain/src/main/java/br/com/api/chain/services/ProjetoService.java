package br.com.api.chain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.chain.entities.Atividade;
import br.com.api.chain.entities.Link;
import br.com.api.chain.entities.Membro;
import br.com.api.chain.entities.Projeto;
import br.com.api.chain.repositories.ProjetoRepository;
import br.com.api.chain.services.exceptions.ResourceNotFoundException;

@Service
public class ProjetoService {
    private final ProjetoRepository projetoRepository;

    @Autowired
    public ProjetoService(ProjetoRepository projetoRepository){
        this.projetoRepository = projetoRepository;
    }

    public List<Projeto> getProjetos(){
        return this.projetoRepository.findAll();
    }

    public Projeto getProject(Integer id){
        Optional<Projeto> proj = projetoRepository.findById(id);
        return proj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Projeto insertProject(Projeto proj){
        return projetoRepository.save(proj);
    }

    public void deleteProject(Integer id){
        projetoRepository.deleteById(id);
    }

    public Projeto updateProject(Integer id, Projeto proj){
        Projeto entity = projetoRepository.getReferenceById(id);
        updateData(entity, proj);
        return projetoRepository.save(entity);
    }

    private void updateData(Projeto entity, Projeto proj){
        entity.setNome(proj.getNome());
    }

    public Atividade insertActivity(Integer id, Atividade ativ){
        Projeto proj = this.getProject(id);
        List<Atividade> atividades = proj.getAtividades();
        atividades.add(ativ);
        return ativ;
    }

    public void insertMember(Membro mem){
        Projeto proj = getProject(mem.getProjetoId().getId());
        proj.getMembros().add(mem);
    }

    public List<Membro> getMembers(Integer id){
        Projeto proj = getProject(id);
        return proj.getMembros();
    }

    public Link insertLink(Integer id, Link li){
        Projeto proj = this.getProject(id);
        List<Link> links = proj.getLinks();
        links.add(li);
        return li;
    }

    public List<Atividade> getActivities(Integer id){
        Projeto proj = getProject(id);
        return proj.getAtividades();
    }

    public List<Link> getLinks(Integer id){
        Projeto proj = getProject(id);
        return proj.getLinks();
    }

    /*public Void updateActivity(Integer idProj){
        if(!verifyIfAdmin(id, idproj)){
            // throw exception
        }
    }*/
}
