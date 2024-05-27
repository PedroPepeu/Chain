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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column
    private String descricao;
    @Column (name = "url_link")
    private String urlLink;

    @JoinColumn(name = "projeto_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Project projeto;

    public Link(){}

    public Link(Integer id, String descricao, String url, Project projeto){
        this.id = id;
        this.descricao = descricao;
        this.urlLink = url;
        this.projeto = projeto;
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

    public void setProjeto(Project projeto) {
        this.projeto = projeto;
    }

    public Project getProjeto() {
        return projeto;
    }

    public String getDescricao(){
        return descricao;
    }

    public String getUrlLink(){
        return urlLink;
    }
}