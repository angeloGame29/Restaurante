package br.ufpb.dcx.restaurante;

import br.ufpb.dcx.restaurante.classDeException.PedidoExistenteException;
import br.ufpb.dcx.restaurante.classDeException.PedidoInexistenteException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MeuSistemaRestaurante implements SistemaRestaurante {
    private List<Pedido> pedidos;
    private final GravadorPedidosRestaurante gravadorPedidos;

    public MeuSistemaRestaurante() {
        this.pedidos = new ArrayList<>();
        this.gravadorPedidos = new GravadorPedidosRestaurante();
    }

    public boolean existePedidoCodigo(String codigo){
        for(Pedido tarefa: this.pedidos){
            if (tarefa.getCodPedido().equals(codigo)){
                return true;
            }
        }
        return false;
    }

    public void cadastrarPedido(String nomeCliente, String codPedido, String numMesa, List<ItemPedido> itens, SistemaData dataPedido, String statusPedido)
            throws PedidoExistenteException{
        if (existePedidoCodigo(codPedido)){
            throw new PedidoExistenteException("Já existe uma tarefa com a descrição "+ codPedido);
        }
        Pedido pedido = new Pedido(nomeCliente,codPedido, numMesa, itens,dataPedido, statusPedido);
        this.pedidos.add(pedido);
    }

    public void cadastrarPedido(Pedido pedido) throws PedidoExistenteException {
        if (this.existePedidoCodigo(pedido.getCodPedido())){
            throw new PedidoExistenteException("Já existe uma tarefa com a descrição "+
                    pedido.getCodPedido());
        }
        this.pedidos.add(pedido);
    }

    public List<Pedido> pesquisarPedidosDoDia(int dia,int mes,int ano) {
        List<Pedido> pedidosDoDia = new ArrayList<>();
        for (Pedido pedido : this.pedidos) {
            if (pedido.getDataPedido().getDia()==dia && pedido.getDataPedido().getMes()==mes
                    && pedido.getDataPedido().getAno()==ano){
                pedidosDoDia.add(pedido);
                return pedidosDoDia;
            }
        }
        return null;

    }

    public Pedido PesquisaPedidoPorCodigo(String codigo) throws PedidoInexistenteException {
        for (Pedido pedido : this.pedidos) {
            if (pedido.getCodPedido().equals(codigo)) {
                return pedido;
            }
        }
        throw new PedidoInexistenteException("Pedido com código " + codigo + " não encontrado.");

    }

    public void adicionarAoPedido(String codPedido, List<ItemPedido> novoItemPedido) throws PedidoInexistenteException {
        for (Pedido pedido : this.pedidos) {
            if (pedido.getCodPedido().equals(codPedido)) {
                pedido.getItens().addAll(novoItemPedido);
            }
        }
        if(!existePedidoCodigo(codPedido)){
            throw new PedidoInexistenteException("Não existe nenhum pedido com esse código!");
        }
    }

    public void atualizaStatusDoPedido(String codigo, String status) throws PedidoInexistenteException {
        for (Pedido p:this.pedidos){
            if(p.getCodPedido().equals(codigo)){
                p.setStatusPedido(status);
            }
        }
    }

    public void cancelarPedido(String codPedido) throws PedidoInexistenteException {
        for (int i = 0; i < this.pedidos.size(); i++){
            Pedido p = this.pedidos.get(i);
            if (p.getCodPedido().equals(codPedido)){
                this.pedidos.remove(p);
                break;
            }
            if (!existePedidoCodigo(codPedido)){
                throw new PedidoInexistenteException("Não existe nenhum pedido com esse código!");
            }
        }
    }

    public double calcularTotalPedido(String nomeCliente, String codPedido) throws PedidoInexistenteException {
        for (Pedido p : pedidos) {
            if (p.getNomeCliente().equalsIgnoreCase(nomeCliente) && p.getCodPedido().equalsIgnoreCase(codPedido)) {
                return p.calcularTotal();
            }
        }
        throw new PedidoInexistenteException("Pedido para o cliente " + nomeCliente + " não encontrado.");
    }

    public void salvarPedido() throws IOException {
        this.gravadorPedidos.gravarPedidos(this.pedidos);
    }

    public void recuperarPedido() throws IOException {
        this.pedidos = this.gravadorPedidos.recuperaPedidos();
    }
}