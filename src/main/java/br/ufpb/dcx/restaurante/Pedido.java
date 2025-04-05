package br.ufpb.dcx.restaurante;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nomeCliente;
    private String codPedido;
    private String numMesa;
    private List<ItemPedido> itens;
    private SistemaData dataPedido;
    private String statusPedido;

    //aceito, preparando, entregando, entregue ou cancelado
    //TODO IMPLEMENTAR : FAZER UM ENUM
    public static final String STATUS_ACEITO = "aceito";
    public static final String STATUS_PREPARANDO = "preparando";
    public static final String STATUS_ENTREGANDO = "entregando";
    public static final String STATUS_ENTREGUE = "entregue";
    public static final String STATUS_CANCELADO = "cancelado";

    public Pedido(String nomeCliente, String codPedido, String numMesa, List<ItemPedido> itens, SistemaData dataPedido, String statusPedido) {

        this.nomeCliente = nomeCliente;
        this.codPedido = codPedido;
        this.numMesa = numMesa;
        this.itens = itens;
        this.dataPedido = dataPedido;
        this.statusPedido = statusPedido;
    }

    public List<ItemPedido> getItens() {
        return this.itens;
    }

    public String getNumMesa() {
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
    public String getStatusPedido(){
        return statusPedido;
    }

    public void setDataPedido(SistemaData dataPedido){
        this.dataPedido = dataPedido;
    }

    public void setNumMesa(String numMesa){
        this.numMesa = numMesa;
    }

    public String toString(){
        return "Cliente de nome: "+this.nomeCliente+", com código: "+
                this.codPedido+", da mesa número:"+this.numMesa+", com itens:"+
                this.itens+", na data de:"+this.dataPedido+"STATUS:"+this.statusPedido;
    }
    public void setStatusPedido(String statusPedido){
        this.statusPedido = statusPedido;
    }
    public void setItens(List<ItemPedido> itens){
        this.itens= itens;

    }

    public double calcularTotal() {
        double total = 0;
        for (ItemPedido item : itens) {
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