package br.com.api.chain.entities;

import jakarta.persistence.*;

@Entity
@Table(name="projeto")
public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="nome")
    private String nome;

    @Column(name="administrador_id")
    private Integer administradorId;

    public Projeto(){}

    public Projeto(Integer id, String nome, Integer administradorId){
        this.id = id;
        this.nome = nome;
        this.administradorId = administradorId;
    }

    public Integer getId(){
        return id;
    }

    public String getNome(){
        return nome;
    }

    public Integer getAdministradorId(){
        return administradorId;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setAdministradorId(Integer administradorId){
        this.administradorId = administradorId;
    }
}