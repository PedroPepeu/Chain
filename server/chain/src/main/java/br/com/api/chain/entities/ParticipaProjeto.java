package br.com.api.chain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "participa")
public class ParticipaProjeto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Usuario engenheiro;

    @ManyToOne
    private Project projeto;

    @Column
    private String cargo;

    public ParticipaProjeto(Usuario engenheiro, Project projeto, String cargo) {
        this.engenheiro = engenheiro;
        this.projeto = projeto;
        this.cargo = cargo;
    }

    public Long getId() {
        return id;
    }

    public Usuario getEngenheiro() {
        return engenheiro;
    }

    public Project getProjeto() {
        return projeto;
    }

    public String getCargo() {
        return cargo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEngenheiro(Usuario engenheiro) {
        this.engenheiro = engenheiro;
    }

    public void setProjeto(Project projeto) {
        this.projeto = projeto;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
