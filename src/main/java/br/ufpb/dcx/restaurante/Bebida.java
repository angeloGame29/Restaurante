package br.ufpb.dcx.restaurante;

public class Bebida implements ItemPedido {
    private String nome;
    private double preco;

    public Bebida(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public double getPreco() {
        return this.preco;
    }

    public String toString(){
        return this.nome +","+ this.preco;
    }
}
