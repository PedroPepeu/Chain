package br.com.api.chain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="projeto")
public class Project {
    
    // MODEL ID FIELD
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    // MODEL Specific Properties
    @Column
    private String nome;
    /*private Atividade atividades[];
    private Usuario membros[];
    private Usuario administrador;
    private Link links[];*/
    @Column (name = "administrador_id")
    private Integer administradorId;

    public Project(){}

    // Constructor
    public Project(String nome, Integer administradorId) {
        this.nome = nome;
        /*this.atividades = atividades;
        this.membros = membros;
        this.administrador = administrador;
        this.links = links;*/
        this.administradorId = administradorId;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public Integer getId() {
        return id;
    }

    /*public Atividade[] getAtividades() {
        return atividades;
    }

    public Usuario[] getMembros() {
        return membros;
    }

    public Usuario getAdministrador() {
        return administrador;
    }

    public Link[] getLinks() {
        return links;
    }*/

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /*public void setAtividades(Atividade[] atividades) {
        this.atividades = atividades;
    }

    public void setMembros(Usuario[] membros) {
        this.membros = membros;
    }

    public void setAdministrador(Usuario administrador) {
        this.administrador = administrador;
    }

    public void setLinks(Link[] links) {
        this.links = links;
    }*/

}
