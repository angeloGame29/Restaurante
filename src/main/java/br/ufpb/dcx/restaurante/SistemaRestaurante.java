package br.ufpb.dcx.restaurante;
import br.ufpb.dcx.restaurante.classDeException.PedidoExistenteException;
import br.ufpb.dcx.restaurante.classDeException.PedidoInexistenteException;

import java.io.IOException;
import java.util.List;
public interface SistemaRestaurante {
    /**
     * Confere se um pedido existe ou não
     * @param codigo recebe o codigo do pedido para saber se existe ou não
     * @return true para pedido existente e false para pedido não existente
     */
    public boolean existePedidoCodigo(String codigo);

    /**
     * Cadastra um pedido com seus dados
     * @param nomeCLiente recebe o nome do cliente
     * @param codPedido recebe um codigo
     * @param numMesa recebe o num da mesa em que o cliente está
     * @param itens recebe os itens lanche/bebida
     * @param dataPedido recebe o data que foi feito o pedido
     * @param statusPedido recebe o status em que se encontra aquele pedido
     * @throws PedidoExistenteException
     */
    void cadastrarPedido(String nomeCLiente, String codPedido, String numMesa,List<ItemPedido> itens, SistemaData dataPedido, String statusPedido)
            throws PedidoExistenteException;

    /**
     * cadastra um pedido
     * @param pedido recebe um pedido para ser cadastrado
     * @throws PedidoExistenteException
     */
    void cadastrarPedido(Pedido pedido) throws PedidoExistenteException;

    /**
     * Pesquisar todos os pedidos do dia
     * @param dia o dia a qual será pesquisado
     * @return retorna uma lista com todos os pedidos feitos no dia
     */
    List<Pedido> pesquisarPedidosDoDia(int dia, int mes,int ano);

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
     * @param codPedido o codigo do pedido do cliente que terá os itens atualizados
     * @param novoItemPedido os novos itens que seram atualizados no pedido
     * @throws PedidoInexistenteException
     */
    void adicionarAoPedido(String codPedido, List<ItemPedido>novoItemPedido)
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
     * @param codPedido o codigo do pedido que será cancelado
     * @throws PedidoInexistenteException
     */
    void cancelarPedido(String codPedido)
            throws PedidoInexistenteException;
    //Só retirar o pedido da lista

    /**
     * Calcula o valor total do pedido de um determinado cliente.
     * @param nomeCliente o nome do cliente cujo o pedido será calculado
     * @return retornar um valor double que é o calculo da soma dos pedidos/itens
     * @throws PedidoInexistenteException
     */
    double calcularTotalPedido(String nomeCliente, String codPedido) throws PedidoInexistenteException;

    void salvarPedido() throws IOException;

    void recuperarPedido() throws IOException;

}