package br.com.api.chain.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="projeto")
public class Project {
    
    // MODEL ID FIELD
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // MODEL Specific Properties
    @Column
    private String nome;
    /*private Atividade atividades[];
    private Usuario membros[];
    private Usuario administrador;
    private Link links[];*/
    @Column (name = "administrador_id")
    private Usuario administrador;

    @OneToMany
    private List<ParticipaProjeto> membros;

    public Project(){}

    // Constructor
    public Project(String nome, Usuario administrador, List<ParticipaProjeto> membros) {
        this.nome = nome;
        this.membros = membros;
        /*this.atividades = atividades;
        this.administrador = administrador;
        this.links = links;*/
        this.administrador = administrador;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public Long getId() {
        return id;
    }

    /*public Atividade[] getAtividades() {
        return atividades;
    }

    public Usuario getAdministrador() {
        return administrador;
    }

    public Link[] getLinks() {
        return links;
    }*/

    public List<ParticipaProjeto> getMembros() {
        return membros;
    }

    public Usuario getAdministrador() {
        return administrador;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAdministrador(Usuario administrador) {
        this.administrador = administrador;
    }

    public void setMembros(List<ParticipaProjeto> membros) {
        this.membros = membros;
    }

    /*public void setAtividades(Atividade[] atividades) {
        this.atividades = atividades;
    }

    public void setAdministrador(Usuario administrador) {
        this.administrador = administrador;
    }

    public void setLinks(Link[] links) {
        this.links = links;
    }*/

}
