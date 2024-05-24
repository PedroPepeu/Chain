package br.com.api.chain.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Atividade {

    // MODEL ID FIELD
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String idAtividade;

     // MODEL Specific Properties
    private String nome;
    private Date dataInicio;
    private Date dataEntrega;
    private boolean concluida;
    private Usuario membrosAssociados[];

    public Atividade(String nome, Usuario membrosAssociados[]){
        this.nome = nome;
        this.membrosAssociados = membrosAssociados;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public boolean isConcluida() {
        return concluida;
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

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }
}
