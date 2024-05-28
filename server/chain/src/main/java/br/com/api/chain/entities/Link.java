package br.com.api.chain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    @Column(name="projeto_id")
    private Integer projetoId;

    public Link(){}

    public Link(Integer id, String descricao, String urlLink, Integer projetoId){
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

    public Integer getProjetoId(){
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

    public void setProjetoId(Integer projetoId){
        this.projetoId = projetoId;
    }
}