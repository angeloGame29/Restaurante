package br.ufpb.dcx.restaurante;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Produto implements Serializable {
    private String nome;
    private String imagem;
    private double preco;

    public Produto(String nome, String imagem, double preco) {
        this.nome = nome;
        this.imagem = imagem;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public String getImagemPath() {
        return imagem;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return nome + " - R$" + String.format("%.2f", preco);
    }
}