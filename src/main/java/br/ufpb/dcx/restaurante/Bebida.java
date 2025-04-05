package br.ufpb.dcx.restaurante;

import java.io.Serializable;
import java.util.Map;

public class Bebida implements ItemPedido, Serializable {
    private static final long serialVersionUID = 1l;

    private String nome;
    private double preco;

    public Bebida(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getPreco() {
        return this.preco;
    }


    public String toString(){
        return this.nome +","+ this.preco;
    }
}
