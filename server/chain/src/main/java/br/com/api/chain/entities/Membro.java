package br.com.api.chain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "participa")
public class Membro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "engenheiro_de_software_id")
    private EngenheiroDeSoftware engenheiroId;

    @ManyToOne
    @JoinColumn(name = "projeto_id")
    private Projeto projetoId;

    @Column(name = "cargo")
    private Integer cargo;

    public Membro(){}

    public Membro(Integer id, EngenheiroDeSoftware engenheiroId, Projeto projetoId, Cargo cargo) {
        this.id = id;
        this.engenheiroId = engenheiroId;
        this.projetoId = projetoId;
        this.setCargo(cargo);
    }

    public Integer getId() {
        return id;
    }

    public EngenheiroDeSoftware getEngenheiroId() {
        return engenheiroId;
    }

    public Projeto getProjetoId() {
        return projetoId;
    }

    public Cargo getCargo() {
        return Cargo.valueOf(cargo);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEngenheiroId(EngenheiroDeSoftware engenheiroId) {
        this.engenheiroId = engenheiroId;
    }

    public void setProjetoId(Projeto projetoId) {
        this.projetoId = projetoId;
    }

    public void setCargo(Cargo cargo) {
        if(cargo != null){
            this.cargo = cargo.getCode();
        }
    }
}
