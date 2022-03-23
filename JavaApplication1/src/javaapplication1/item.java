/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

/**
 *
 * @author 11914184
 */
class item {
    String jogos, categoria;
    Double avaliacao;
    public item(String jogos, String categoria, Double avaliacao){
        this.jogos = jogos;
        this.categoria = categoria;
        this.avaliacao = avaliacao;
    }

    public String getJogos() {
        return this.jogos;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public Double getAvaliacao() {
        return this.avaliacao;
    }

    public void setJogos(String jogos) {
        this.jogos = jogos;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setAvaliacao(Double avaliacao) {
        this.avaliacao = avaliacao;
    }
    
    
}
