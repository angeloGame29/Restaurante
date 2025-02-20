package br.ufpb.dcx.restaurante;

public class Lanche implements ItemPedido {
    private String nome;
    private double preco;

    public Lanche(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public double getPreco() {
        return this.preco;
    }
    public String toString() {
        return nome + "," + preco;
    }
}
