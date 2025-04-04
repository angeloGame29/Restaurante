package br.ufpb.dcx.restaurante;
import br.ufpb.dcx.restaurante.classDeException.PedidoExistenteException;
import br.ufpb.dcx.restaurante.classDeException.PedidoInexistenteException;

import java.io.IOException;
import java.util.List;
public interface SistemaRestaurante {
    /**
     * Cadastra um pedido com seus dados
     * @param nomeCLiente recebe o nome do cliente
     * @param codigo recebe um codigo
     * @param numMesa recebe o num da mesa em que o cliente está
     * @param itens recebe os itens lanche/bebida
     * @param dataPedido recebe o data que foi feito o pedido
     * @param statusPedido recebe o status em que se encontra aquele pedido
     * @throws PedidoExistenteException
     */
    void cadastrarPedido( String codigo, String nomeCLiente, String numMesa,List<ItemPedido> itens, SistemaData dataPedido, String statusPedido)
    throws PedidoExistenteException;

    /**
     * Confere se um pedido existe ou não
     * @param codigo recebe o codigo do pedido para saber se existe ou não
     * @return true para pedido existente e false para pedido não existente
     */
    boolean existePedidoCodigo(String codigo);

    /**
     * Pesquisar todos os pedidos do mes
     * @param mes o dia a qual será pesquisado
     * @param ano indica o ano do mes
     * @return retorna uma lista com todos os pedidos feitos no dia
     */
    List<Pedido> pesquisarPedidosDoDia(int dia, int mes, int ano) throws PedidoInexistenteException;

    /**
     * Pesquisa um pedido em específico
     * @param codigo o codigo de um pedido
     * @return Pedido ele irá retornar os dados do pedido do cliente
     * @throws PedidoInexistenteException
     */
    Pedido PesquisaPedidoPorCodigo(String codigo)
            throws PedidoInexistenteException;

    /**
     * Atualiza os itens pedidos pelo cliente
     * @param codigo o codigo do pedido do cliente que terá os itens atualizados
     * @param novoItemPedido os novos itens que seram atualizados no pedido
     * @throws PedidoInexistenteException
     */
    void adicionarAoPedido(String codigo, List<ItemPedido>novoItemPedido)
            throws PedidoInexistenteException;

    /**
     * Atualiza o status do pedido, se está em aceito, preparando, entregando, entregue ou cancelado
     * @param codigo o codigo do pedido que terá seu status atualizado
     * @param status o novo status do pedido que será atualizado
     * @throws PedidoInexistenteException
     */
    void atualizaStatusDoPedido(String codigo, String status) throws PedidoInexistenteException;

    /**
     * Cancela um pedido com o seu codigo informado.
     * @param codigo o codigo do pedido que será cancelado
     * @throws PedidoInexistenteException
     */
    void cancelarPedido(String codigo)
            throws PedidoInexistenteException;

    /**
     * Calcula o valor total do pedido de um determinado cliente.
     * @param codigo o codigo do cliente cujo o pedido será calculado
     * @return retornar um valor double que é o calculo da soma dos pedidos/itens
     * @throws PedidoInexistenteException
     */
    double calcularTotalPedido(String codigo) throws PedidoInexistenteException;

    void salvarPedido() throws IOException;

    void recuperarPedido() throws IOException;

}