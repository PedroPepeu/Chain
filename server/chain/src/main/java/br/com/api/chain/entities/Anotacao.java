package br.com.api.chain.entities;



import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="anotacao")
public class Anotacao {
    
    // MODEL ID FIELD
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    // MODEL Specific Properties
    @Column(length = 250)
    private String texto;
    @Column(name = "data_anotacao")
    private Date dataAnotacao;

    @JoinColumn(name = "engenheiro_de_software_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Usuario engenheiro;
    
    public Anotacao(){}

    public Anotacao(String texto, Date date, Usuario engenheiro) {
        this.texto = texto;
        this.dataAnotacao = date;
        this.engenheiro = engenheiro;
    }

    public int getId() {
        return id;
    }

    public Date getDataAnotacao() {
        return dataAnotacao;
    }

    public Usuario getEngenheiro() {
        return engenheiro;
    }

    public String getTexto() {
        return texto;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDataAnotacao(Date dataAnotacao) {
        this.dataAnotacao = dataAnotacao;
    }

    public void setEngenheiro(Usuario engenheiro) {
        this.engenheiro = engenheiro;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
