package br.com.api.chain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="engenheiro_de_software")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String nome;
    @Column
    private String senha;
    @Column
    private String email;

    //@OneToMany ver mais informações sobre
    //private Anotacao anotacoes;

    /*private Project projetos[];
    private Calendario calendario;
    private Atividade atividades[];*/

    public Usuario(){}

    public Usuario(Integer id, String nome, String senha, String email){
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        //this.projetos = projetos;
        //this.calendario = calendario;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

    /*public void setProjetos(Project projetos[]){
        this.projetos = projetos;
    }

    public void setAtividades(Atividade atividades[]){
        this.atividades = atividades;
    }

    public void setCalendario(Calendario calendario){
        this.calendario = calendario;
    } Ver como fazer depois*/

    public String getNome(){
        return nome;
    }

    public String getEmail(){
        return email;
    }

    public Integer getId(){
        return id;
    }

    /*public Project[] getProjetos(){
        return projetos;
    }

    public Atividade[] getAtividades(){
        return atividades;
    }

    public Calendario getCalendario(){
        return calendario;
    }*/

    public String getSenha(){
        return senha;
    }
}