package br.com.api.chain.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table(name="projeto")
public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="nome")
    private String nome;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "administrador_id")
    @JsonBackReference
    private EngenheiroDeSoftware administradorId;

    /*@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "projeto_id")
    @JsonManagedReference
    private List<Link> links;*/

    public Projeto(){}

    public Projeto(Integer id, String nome, EngenheiroDeSoftware administradorId){ // , List<Link> links
        this.id = id;
        this.nome = nome;
        this.administradorId = administradorId;
        //this.links = links;
    }

    public Integer getId(){
        return id;
    }

    /*public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }*/

    public String getNome(){
        return nome;
    }

    public EngenheiroDeSoftware getAdministradorId(){
        return administradorId;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setAdministradorId(EngenheiroDeSoftware administradorId){
        this.administradorId = administradorId;
    }
}