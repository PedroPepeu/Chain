package br.com.api.chain.entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@Table(name="atividade")
public class Atividade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="nome")
    private String nome;

    @Column(name="concluida")
    private boolean concluida;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "projeto_id")
    @JsonBackReference
    private Projeto projetoId;

    @Column(name="data_inicio")
    private LocalDate dataInicio;

    @Column(name="data_entrega")
    private LocalDate dataEntrega;

    public Atividade(){}

    public Atividade(Integer id, String nome, boolean concluida, Projeto projetoId, LocalDate dataInicio, LocalDate dataEntrega){
        this.id = id;
        this.nome = nome;
        this.concluida = concluida;
        this.projetoId = projetoId;
        this.dataInicio = dataInicio;
        this.dataEntrega = dataEntrega;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public Projeto getProjetoId() {
        return projetoId;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    public void setProjetoId(Projeto projetoId) {
        this.projetoId = projetoId;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    
}