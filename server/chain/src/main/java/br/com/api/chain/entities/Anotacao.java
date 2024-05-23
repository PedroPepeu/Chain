package br.com.api.chain.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Anotacao {
    
    // MODEL ID FIELD
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String idAnotacao;

    // MODEL Specific Properties
    private String texto;
    private Date dataAnotacao;
    
    public Anotacao(String id, String texto, Date date) {
        this.idAnotacao = id;
        this.texto = texto;
        this.dataAnotacao = date;
    }

    public String getId() {
        return idAnotacao;
    }

    public String getTexto() {
        return texto;
    }

    public Date getDate() {
        return dataAnotacao;
    }

    public void setId(String id) {
        this.idAnotacao = id;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setDate(Date date) {
        this.dataAnotacao = date;
    }
}
