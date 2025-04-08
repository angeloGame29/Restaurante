package br.ufpb.dcx.restaurante;

import java.util.List;

public class Cardapio {
    private List<Produto> produtos;

    public Cardapio (List<Produto> produtos){
        this.produtos = produtos;
    }

    public List<Produto> getListProdutos (){
        return this.produtos;
    }

}
