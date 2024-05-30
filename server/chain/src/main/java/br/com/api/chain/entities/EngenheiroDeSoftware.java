package br.com.api.chain.entities;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="engenheiro_de_software")
public class EngenheiroDeSoftware {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="nome")
    private String nome;

    @Column(name="senha")
    private String senha;

    @Column(name="email")
    private String email;

    @OneToMany(mappedBy = "engenheiroId", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Anotacao> anotacoes;

    @OneToMany(mappedBy = "administradorId", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Projeto> projetos;

    @OneToMany(mappedBy = "engenheiroId", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Membro> participa;

    @ManyToMany(mappedBy = "engenheiros")
    @JsonManagedReference
    Set<Atividade> atividades;

    public EngenheiroDeSoftware(){}

    public EngenheiroDeSoftware(Integer id, String nome, String email, String senha, List<Anotacao> anotacoes, List<Projeto> projetos, Set<Atividade> atividades, List<Membro> participa){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.anotacoes = anotacoes;
        this.projetos = projetos;
        this.atividades = atividades;
        this.participa = participa;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setAnotacoes(List<Anotacao> anotacoes) {
        this.anotacoes = anotacoes;
    }

    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }

    public List<Anotacao> getAnotacoes() {
        return anotacoes;
    }

    public Set<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(Set<Atividade> atividades) {
        this.atividades = atividades;
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public List<Membro> getParticipa() {
        return participa;
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

    public void setParticipa(List<Membro> participa) {
        this.participa = participa;
    }

    public String getNome(){
        return nome;
    }

    public String getEmail(){
        return email;
    }

    public Integer getId(){
        return id;
    }

    public String getSenha(){
        return senha;
    }
}