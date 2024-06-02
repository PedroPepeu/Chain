package br.com.api.chain.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    private EngenheiroDeSoftware administradorId;

    @JsonIgnore
    @OneToMany(mappedBy = "projetoId", cascade = CascadeType.ALL)
    private List<Link> links;

    @JsonIgnore
    @OneToMany(mappedBy = "projetoId", cascade = CascadeType.ALL)
    private List<Atividade> atividades;

    @JsonIgnore
    @OneToMany(mappedBy = "projetoId", cascade = CascadeType.ALL)
    private List<Membro> membros;

    public Projeto(){}

    public Projeto(Integer id, String nome, EngenheiroDeSoftware administradorId, List<Link> links, List<Atividade> atividades, List<Membro> membros){
        this.id = id;
        this.nome = nome;
        this.administradorId = administradorId;
        this.links = links;
        this.atividades = atividades;
        this.membros = membros;
    }

    public Integer getId(){
        return id;
    }

    public List<Link> getLinks() {
        return links;
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(List<Atividade> atividades) {
        this.atividades = atividades;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public String getNome(){
        return nome;
    }

    public List<Membro> getMembros() {
        return membros;
    }

    public EngenheiroDeSoftware getAdministradorId(){
        return administradorId;
    }

    public void setMembros(List<Membro> membros) {
        this.membros = membros;
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