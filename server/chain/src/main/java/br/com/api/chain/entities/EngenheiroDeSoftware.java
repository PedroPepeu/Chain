package br.com.api.chain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="engenheiro_de_software")
public class EngenheiroDeSoftware {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="nome")
    private String nome;

    @Column(name="senha")
    private String senha;

    @Column(name="email")
    private String email;

    public EngenheiroDeSoftware(){}

    public EngenheiroDeSoftware(Integer id, String nome, String email, String senha){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

    public String getNome(){
        return nome;
    }

    public String getEmail(){
        return email;
    }

    public Integer getId(){
        return id;
    }

    public String getSenha(){
        return senha;
    }
}