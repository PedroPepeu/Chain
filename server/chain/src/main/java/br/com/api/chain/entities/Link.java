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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column
    private String descricao;
    @Column (name = "url_link")
    private String urlLink;
    @Column (name = "projeto_id")
    private Integer projetoId;

    public Link(){}

    public Link(Integer id, String descricao, String url, Integer projetoId){
        this.id = id;
        this.descricao = descricao;
        this.urlLink = url;
        this.projetoId = projetoId;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public void setUrlLink(String url){
        this.urlLink = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setProjetoId(Integer projetoId) {
        this.projetoId = projetoId;
    }

    public Integer getProjetoId() {
        return projetoId;
    }

    public String getDescricao(){
        return descricao;
    }

    public String getUrlLink(){
        return urlLink;
    }
}