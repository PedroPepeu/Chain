package br.com.api.chain.entities;

import java.util.LinkedList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String nome;
    private String senha;
    private String email;

    private Project projetos[];
    private Calendario calendario;
    private Atividade atividades[];

    public Usuario(String id, String nome, String senha, String email, Project projetos[], Calendario calendario, Atividade atividades[]){
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.projetos = projetos;
        this.calendario = calendario;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setId(String id){
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

    public String getId(){
        return id;
    }

    public String getProjeto(String nome){
        return null;
    }

    public Atividade[] getAtividades(){
        return atividades;
    }

    public String getSenha(){
        return senha;
    }

    public void addProject(String projName){
        
    }

    public void rmvProject(String projId){
        
    }
}