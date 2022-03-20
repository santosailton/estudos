package com.c.retrofit.retrofitjson.model;

import java.util.List;

public class Cidade {
    private String cidade;
    private String uf;
    private String atualizacao;
    private List<Previsao> previsao;

    @Override
    public String toString() {
        return "Cidade{" +
                "cidade='" + cidade + '\'' +
                ", uf='" + uf + '\'' +
                ", atualizacao='" + atualizacao + '\'' +
                ", previsao=" + previsao +
                '}';
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getAtualizacao() {
        return atualizacao;
    }

    public void setAtualizacao(String atualizacao) {
        this.atualizacao = atualizacao;
    }

    public List<Previsao> getPrevisao() {
        return previsao;
    }

    public void setPrevisao(List<Previsao> previsao) {
        this.previsao = previsao;
    }
}
