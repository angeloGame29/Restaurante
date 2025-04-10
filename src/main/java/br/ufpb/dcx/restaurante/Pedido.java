package br.ufpb.dcx.restaurante;

import jdk.jshell.Snippet;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nomeCliente;
    private String codPedido;
    private NumMesa numMesa;
    private List<Produto> itens;
    private SistemaData dataPedido;
    private StatusPedido statusPedido;

    public Pedido(String nomeCliente, String codPedido, NumMesa numMesa, List<Produto> itens, SistemaData dataPedido, StatusPedido statusPedido) {

        this.nomeCliente = nomeCliente;
        this.codPedido = codPedido;
        this.numMesa = numMesa;
        this.itens = itens;
        this.dataPedido = dataPedido;
        this.statusPedido = statusPedido;
    }

    public List<Produto> getItens() {
        return this.itens;
    }

    public NumMesa getNumMesa() {
        return numMesa;
    }

    public String getCodPedido() {
        return this.codPedido;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public SistemaData getDataPedido() {
        return dataPedido;
    }

    public StatusPedido getStatusPedido(){
        return statusPedido;
    }

    public void setDataPedido(SistemaData dataPedido){
        this.dataPedido = dataPedido;
    }

    public void setNumMesa(NumMesa numMesa){
        this.numMesa = numMesa;
    }

    public String toString(){
        return "Cliente de nome: "+this.nomeCliente+", com código: "+
                this.codPedido+", da mesa número:"+this.numMesa+", com itens:"+
                this.itens+", na data de:"+this.dataPedido+"STATUS:"+this.statusPedido;
    }

    public void setStatusPedido(StatusPedido statusPedido){
        this.statusPedido = statusPedido;
    }

    public void setItens(List<Produto> itens){
        this.itens= itens;

    }

    public double calcularTotal() {
        double total = 0;
        for (Produto item : itens) {
            total += item.getPreco();
        }
        return total;
    }

    public void cadastrar(Map<String, Pedido> pedidoMap){
        pedidoMap.put(this.getCodPedido(), this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(codPedido, pedido.codPedido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codPedido);
    }

}