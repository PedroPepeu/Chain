package br.com.api.chain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String idLink;
    
    private String descricao;
    private String urlLink;

    public Link(String id, String descricao, String url){
        this.idLink = id;
        this.descricao = descricao;
        this.urlLink = url;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public void setUrlLink(String url){
        this.urlLink = url;
    }

    public String getDescricao(){
        return descricao;
    }

    public String getUrlLink(){
        return urlLink;
    }
}