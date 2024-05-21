package br.com.api.chain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Atividade {

    // MODEL ID FIELD
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

     // MODEL Specific Properties
    private String nome;
    private Usuario membrosAssociados[];

    public Atividade(String nome, Usuario membrosAssociados[]){
        this.nome = nome;
        this.membrosAssociados = membrosAssociados;
    }

    public String getNome(){
        return this.nome;
    }

    public Usuario[] getMembrosAssociados(){
        return this.getMembrosAssociados();
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setMembrosAssociados(Usuario membrosAssociados[]){
        this.membrosAssociados = membrosAssociados;
    }
}
