package br.com.api.chain.entities;

public class Calendario {

    private Atividade atividades[];
    private Anotacao anotacoes[];

    public Calendario(Atividade[] atividades, Anotacao[] anotacoes) {
        this.atividades = atividades;
        this.anotacoes = anotacoes;
    }

    public Atividade[] getAtividades(){
        return atividades;
    }

    public Anotacao[] getAnotacoes(){
        return anotacoes;
    }

    public void setAtividades(Atividade[] atividades){
        this.atividades = atividades;
    }

    public void setAnotacoes(Anotacao[] anotacoes){
        this.anotacoes = anotacoes;
    }
}
