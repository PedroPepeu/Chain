package br.com.api.chain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    
    private String descricao;
    private String url;

    public Link(String id, String descricao, String url){
        this.id = id;
        this.descricao = descricao;
        this.url = url;
    }

    public void setId(String id){
        this.id = id;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public void setUrl(String url){
        this.url = url;
    }

    public String getId(){
        return id;
    }

    public String getDescricao(){
        return descricao;
    }

    public String getUrl(){
        return url;
    }
}