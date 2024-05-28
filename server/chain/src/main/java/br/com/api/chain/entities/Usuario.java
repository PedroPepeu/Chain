package br.com.api.chain.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "engenheiro_de_software")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(length = 50)
    private String nome;
    @Column(length = 50)
    private String senha;
    @Column(length = 50)
    private String email;

    @ManyToMany
        @JoinTable(
            name = "realiza",
            joinColumns = @JoinColumn(name = "engenheiro_de_software_id"),
            inverseJoinColumns = @JoinColumn(name = "atividade_id")
        )
    private List<Atividade> atividades;

    @OneToMany
    private List<ParticipaProjeto> projetos;

    /*private Calendario calendario;
    private Atividade atividades[];*/

    public Usuario(){}

    public Usuario(String nome, String senha, String email, List<Atividade> atividades, List<ParticipaProjeto> projetos){
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.atividades = atividades;
        this.projetos = projetos;
        //this.calendario = calendario;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setId(int id){
        this.id = id;
    }

    public List<ParticipaProjeto> getProjetos() {
        return projetos;
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(List<Atividade> atividades) {
        this.atividades = atividades;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

    /*public void setCalendario(Calendario calendario){
        this.calendario = calendario;
    }*/

    public String getNome(){
        return nome;
    }

    public String getEmail(){
        return email;
    }

    public int getId(){
        return id;
    }

    /*public Calendario getCalendario(){
        return calendario;
    }*/

    public String getSenha(){
        return senha;
    }

    public void setProjetos(List<ParticipaProjeto> projetos) {
        this.projetos = projetos;
    }
}