package br.com.api.chain.entities;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name="anotacao")
public class Anotacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="texto")
    private String texto;

    @Column(name="data_anotacao")
    private LocalDate dataAnotacao;

    @Column(name="engenheiro_de_software_id")
    private Integer engenheiroId;

    public Anotacao(){}

    public Anotacao(Integer id, String texto, LocalDate dataAnotacao, Integer engenheiroId){
        this.id = id;
        this.texto = texto;
        this.dataAnotacao = dataAnotacao;
        this.engenheiroId = engenheiroId;
    }

    public Integer getId() {
        return id;
    }

    public String getTexto() {
        return texto;
    }

    public LocalDate getDataAnotacao() {
        return dataAnotacao;
    }

    public Integer getEngenheiroId() {
        return engenheiroId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setDataAnotacao(LocalDate dataAnotacao) {
        this.dataAnotacao = dataAnotacao;
    }

    public void setEngenheiroId(Integer engenheiroId) {
        this.engenheiroId = engenheiroId;
    }
}