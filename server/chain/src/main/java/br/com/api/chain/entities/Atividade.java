package br.com.api.chain.entities;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="atividade")
public class Atividade {

    // MODEL ID FIELD
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

     // MODEL Specific Properties
    @Column(length = 50)
    private String nome;
    @Column (name = "data_inicio")
    private Date dataInicio;
    @Column (name = "data_entrega")
    private Date dataEntrega;
    @Column
    private boolean concluida;

    @JoinColumn(name = "projeto_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Project projeto;

    @ManyToMany(mappedBy = "atividades")
    private List<Usuario> membrosAssociados;

    public Atividade(){}

    public Atividade(String nome, Date dataInicio, Date dataEntrega, boolean concluida, Project projeto, List<Usuario> membrosAssociados){
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataEntrega = dataEntrega;
        this.concluida = concluida;
        this.projeto = projeto;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProjeto(Project projeto) {
        this.projeto = projeto;
    }

    public Project getProjeto() {
        return projeto;
    }

    public List<Usuario> getMembrosAssociados() {
        return membrosAssociados;
    }

    public void setNome(String nome){
        this.nome = nome;
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

    public void setMembrosAssociados(List<Usuario> membrosAssociados) {
        this.membrosAssociados = membrosAssociados;
    }
}
