package br.com.api.chain.entities;



import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="anotacao")
public class Anotacao {
    
    // MODEL ID FIELD
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    // MODEL Specific Properties
    @Column
    private String texto;
    @Column(name = "data_anotacao")
    private Date dataAnotacao;
    @Column (name = "engenheiro_de_software_id")
    private Integer engenheiroDeSoftwareId; 
    
    public Anotacao(){}

    public Anotacao(Integer id, String texto, Date date, Integer engenheiroDeSoftwareId) {
        this.id = id;
        this.texto = texto;
        this.dataAnotacao = date;
        this.engenheiroDeSoftwareId = engenheiroDeSoftwareId;
    }

    public Integer getId() {
        return id;
    }

    public Date getDataAnotacao() {
        return dataAnotacao;
    }

    public Integer getEngenheiroDeSoftwareId() {
        return engenheiroDeSoftwareId;
    }

    public String getTexto() {
        return texto;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDataAnotacao(Date dataAnotacao) {
        this.dataAnotacao = dataAnotacao;
    }

    public void setEngenheiroDeSoftwareId(Integer engenheiroDeSoftwareId) {
        this.engenheiroDeSoftwareId = engenheiroDeSoftwareId;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
