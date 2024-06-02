package br.com.api.chain.entities;

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
@Table(name="link")
public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="descricao")
    private String descricao;

    @Column(name="url_link")
    private String urlLink;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "projeto_id")
    private Projeto projetoId;

    public Link(){}

    public Link(Integer id, String descricao, String urlLink, Projeto projetoId){ 
        this.id = id;
        this.descricao = descricao;
        this.urlLink = urlLink;
        this.projetoId = projetoId;
    }

    public Integer getId(){
        return id;
    }

    public String getDescricao(){
        return descricao;
    }

    public String getUrlLink(){
        return urlLink;
    }

    public Projeto getProjetoId(){
        return projetoId;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public void setUrlLink(String urlLink){
        this.urlLink = urlLink;
    }

    public void setProjetoId(Projeto projetoId){
        this.projetoId = projetoId;
    }
}