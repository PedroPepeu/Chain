package br.com.api.chain.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="atividade")
public class Atividade {

    // MODEL ID FIELD
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

     // MODEL Specific Properties
    @Column
    private String nome;
    @Column (name = "data_inicio")
    private Date dataInicio;
    @Column (name = "data_entrega")
    private Date dataEntrega;
    @Column
    private boolean concluida;
    @Column (name = "projeto_id")
    private Integer projetoId;
    //private Usuario membrosAssociados[];

    public Atividade(){}

    public Atividade(Integer id, String nome, Date dataInicio, Date dataEntrega, boolean concluida, Integer projetoId){
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataEntrega = dataEntrega;
        this.concluida = concluida;
        this.projetoId = projetoId;
        //this.membrosAssociados = membrosAssociados;
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

    /*public Usuario[] getMembrosAssociados(){
        return this.getMembrosAssociados();
    }*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setProjetoId(Integer projetoId) {
        this.projetoId = projetoId;
    }

    public Integer getProjetoId() {
        return projetoId;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    /*public void setMembrosAssociados(Usuario membrosAssociados[]){
        this.membrosAssociados = membrosAssociados;
    }*/

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
