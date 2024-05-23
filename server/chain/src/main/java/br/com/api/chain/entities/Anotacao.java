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
    private String id;

    // MODEL Specific Properties
    private String texto;
    private Date date;
    
    public Anotacao(String id, String texto, Date date) {
        this.id = id;
        this.texto = texto;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public String getTexto() {
        return texto;
    }

    public Date getDate() {
        return date;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
