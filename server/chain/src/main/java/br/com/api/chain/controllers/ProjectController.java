package br.com.api.chain.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import br.com.api.chain.entities.Project;
import br.com.api.chain.repositories.ProjectRespository;

@RestController
public class ProjectController {
    
    public ProjectRespository Project;

    public ProjectController(ProjectRespository project) {
        this.Project = project;
    }

    @GetMapping("/project")
    public List<Project> getProject() {
        return Project.findAll();
    }

    @PostMapping("/project")
    public List<Project> createProject(@RequestBody Project newProject) {
        Project.save(newProject);
        return Project.findAll();
    }

    @PutMapping("/project/{id}")
    public List<Project> updateProject(@RequestBody Project updateProject, @PathVariable String id) {
        Project.findById(id)
            .map(project -> {
                project.setNome(updateProject.getNome());
                project.setAtividades(updateProject.getAtividades());
                project.setAdministrador(updateProject.getAdministrador());
                project.setMembros(updateProject.getMembros());
                project.setLinks(updateProject.getLinks());
                return Project.save(project);
            });

        return Project.findAll();
    }

    @DeleteMapping("/project/{id}")
    public List<Project> deleteProject(@PathVariable String id) {
        Project.deleteById(id);
        return Project.findAll();
    }
}
