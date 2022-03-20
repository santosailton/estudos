package com.c.retrofit.retrofitjson.model;

public class Previsao {
    private String dia;
    private String tempo;
    private String temMax;
    private String temMin;
    private String indiceUV;

    @Override
    public String toString() {
        return "Previsao{" +
                "dia='" + dia + '\'' +
                ", tempo='" + tempo + '\'' +
                ", temMax='" + temMax + '\'' +
                ", temMin='" + temMin + '\'' +
                ", indiceUV='" + indiceUV + '\'' +
                '}';
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

    public String getTemMax() {
        return temMax;
    }

    public void setTemMax(String temMax) {
        this.temMax = temMax;
    }

    public String getTemMin() {
        return temMin;
    }

    public void setTemMin(String temMin) {
        this.temMin = temMin;
    }

    public String getIndiceUV() {
        return indiceUV;
    }

    public void setIndiceUV(String indiceUV) {
        this.indiceUV = indiceUV;
    }

}
