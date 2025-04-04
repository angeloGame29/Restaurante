package br.ufpb.dcx.restaurante;

import br.ufpb.dcx.restaurante.classDeException.PedidoExistenteException;
import br.ufpb.dcx.restaurante.classDeException.PedidoInexistenteException;

import java.io.IOException;
import java.util.*;

public class MeuSistemaRestaurante implements SistemaRestaurante {
    private Map<String, Pedido> pedidoMap;

    public MeuSistemaRestaurante(){
        this.pedidoMap = new HashMap<>();
    }

    @Override
    public void cadastrarPedido(String codigo, String nomeCLiente, String numMesa
            , List<ItemPedido> itens, SistemaData dataPedido, String statusPedido) throws PedidoExistenteException {
        if(pedidoMap.containsKey(codigo)){
            throw new PedidoExistenteException("Já existe pedido com esse código: "+ codigo);
        } else {
            Pedido pedido = new Pedido(codigo, nomeCLiente, numMesa, itens, dataPedido, statusPedido);
        }
    }

    @Override
    public boolean existePedidoCodigo(String codigo) {
        return pedidoMap.containsKey(codigo);
    }

    @Override
    public List<Pedido> pesquisarPedidosDoDia(int dia, int mes, int ano) throws PedidoInexistenteException {
        List<Pedido> pedidosDoDia = this.pedidoMap.values().stream()
                .filter(pedido -> Objects.equals(pedido.getDataPedido(),
                new SistemaData(dia, mes, ano))).toList();
        if(pedidosDoDia.isEmpty()){
            throw new PedidoInexistenteException("Não existe pedido nessa data: "+ dia +"/"+ mes+"/"+ ano);
        } else {
            return pedidosDoDia;
        }
    }

    @Override
    public Pedido PesquisaPedidoPorCodigo(String codigo) throws PedidoInexistenteException {
        Optional<Pedido> pedidoPesquisado = this.pedidoMap.values().stream()
                .filter(pedido -> pedidoMap.containsKey(codigo)).findFirst();
        return pedidoPesquisado.orElseThrow(() -> new PedidoInexistenteException
                ("Não existe pedido com o código: "+ codigo));
    }

    @Override
    public void adicionarAoPedido(String codigo, List<ItemPedido> novoItemPedido) throws PedidoInexistenteException {
        if(this.pedidoMap.containsKey(codigo)){
            pedidoMap.get(codigo).getItens().addAll(novoItemPedido);
        } else {
            throw new PedidoInexistenteException("Não existe pedido com o código: "+ codigo);
        }
    }

    @Override
    public void atualizaStatusDoPedido(String codigo, String status) throws PedidoInexistenteException {
        Pedido pedido = pedidoMap.get(codigo);
        if (pedido == null) {
            throw new PedidoInexistenteException("Não existe pedido com o código: " + codigo);
        }
        pedido.setStatusPedido(status);
    }

    @Override
    public void cancelarPedido(String codigo) throws PedidoInexistenteException {
        this.pedidoMap.values().stream().filter(pedido -> pedido.getCodPedido().equals(codigo))
                .findFirst().map(pedido -> this.pedidoMap.remove(codigo))
                .orElseThrow(() -> new PedidoInexistenteException("Não existe pedido com o código: " + codigo));
    }

    @Override
    public double calcularTotalPedido(String codigo) throws PedidoInexistenteException {
        for (Pedido pedido: this.pedidoMap.values()){
            if (this.pedidoMap.containsKey(codigo)){
                return pedido.calcularTotal();
            }
        } throw new PedidoInexistenteException("Não existe pedido com o código: " + codigo);
    }

    @Override
    public void salvarPedido() throws IOException {

    }

    @Override
    public void recuperarPedido() throws IOException {

    }
}