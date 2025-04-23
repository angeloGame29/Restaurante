package br.ufpb.dcx.restaurante;

import br.ufpb.dcx.restaurante.Exceptions.PedidoExistenteException;
import br.ufpb.dcx.restaurante.Exceptions.PedidoInexistenteException;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProgramaSistemaRestaurante {
    public static void main(String[] args) throws PedidoInexistenteException {
        SistemaRestaurante sistema = new MeuSistemaRestaurante();
        try {
            sistema.recuperarPedido();
            JOptionPane.showMessageDialog(null, "Tudo pronto!\nSeus dados foram recuperados sem problemas.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Interrupção temporária.\nDados não recuperados");
            e.printStackTrace();
        }

        boolean continuar = true;
        while (continuar) {
            String opcao = JOptionPane.showInputDialog("Escolha uma opção:" +
                    "\n1 - Cadastrar pedido" +
                    "\n2 - Calcular total do pedido" +
                    "\n3 - Adicionar ao pedido" +
                    "\n4 - Atualizar status do pedido" +
                    "\n5 - Pesquisar pedidos do dia" +
                    "\n6 - Pesquisar pedido por código" +
                    "\n7 - Cancelar pedido" +
                    "\n8 - Salvar dados" +
                    "\n9 - Sair"
            );
            switch (opcao) {
                case "1":
                    String nomeCLiente = JOptionPane.showInputDialog("Digite o nome do Cliente:");
                    String codPedido = JOptionPane.showInputDialog("Digite o codigo do Pedido:");
                    NumMesa numMesa;
                    String[] mesaAlterar = {"01", "02", "03", "04", "05"};
                    String opcaoMesa = (String) JOptionPane.showInputDialog(null, "Escolha uma mesa: "
                            , "Menu", JOptionPane.QUESTION_MESSAGE, null, mesaAlterar, mesaAlterar[0]);
                    if (opcaoMesa != null) {
                        switch (opcaoMesa) {
                            case "01":
                                numMesa = NumMesa.MESA_01;
                                break;
                            case "02":
                                numMesa = NumMesa.MESA_02;
                                break;
                            case "03":
                                numMesa = NumMesa.MESA_03;
                                break;
                            case "04":
                                numMesa = NumMesa.MESA_04;
                                break;
                            case "05":
                                numMesa = NumMesa.MESA_05;
                                break;
                            default:
                                System.out.println("Opção inválida!");
                                return;
                        }
                        List<Produto> itensDoPedido = new ArrayList<>();
                        boolean concluir = true;
                        while (concluir) {
                            String opcoesDeItens = JOptionPane.showInputDialog("Escolha uma opção:" +
                                    "\n1- Lanches" +
                                    "\n2- Bebidas" +
                                    "\n3- Pronto"
                            );
                        }
                        int dia = Integer.parseInt(JOptionPane.showInputDialog("Digite o dia do pedido:"));
                        int mes = Integer.parseInt(JOptionPane.showInputDialog("Digite o mês:"));
                        int ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano:"));
                        SistemaData data = new SistemaData(dia, mes, ano);
                        StatusPedido status;
                        String[] statusAlterar = {"ACEITO", "PREPARANDO", "ENTREGANDO", "ENTREGUE", "CANCELADO"};
                        String opcaoStatus = (String) JOptionPane.showInputDialog(null, "Escolha um status pro pedido: "
                                , "Menu", JOptionPane.QUESTION_MESSAGE, null, statusAlterar, statusAlterar[0]);
                        if (opcaoStatus != null) {
                            switch (opcaoStatus) {
                                case "ACEITO":
                                    status = StatusPedido.STATUS_ACEITO;
                                    break;
                                case "PREPARANDO":
                                    status = StatusPedido.STATUS_PREPARANDO;
                                    break;
                                case "ENTREGANDO":
                                    status = StatusPedido.STATUS_ENTREGANDO;
                                    break;
                                case "ENTREGUE":
                                    status = StatusPedido.STATUS_ENTREGUE;
                                    break;
                                case "CANCELADO":
                                    status = StatusPedido.STATUS_CANCELADO;
                                    break;
                                default:
                                    System.out.println("Opção inválida!");
                                    return;
                            }
                            Pedido pedido = new Pedido(nomeCLiente, codPedido, numMesa, itensDoPedido, data, status);
                            try {
                                sistema.cadastrarPedido(pedido);
                                JOptionPane.showMessageDialog(null, "Pedido cadastrado com sucesso!");
                            } catch (PedidoExistenteException e) {
                                JOptionPane.showMessageDialog(null, "Pedido não cadastrado.");
                            }

                            break;
                        }
                    }
                case "2":
                    String nomePedidoT = JOptionPane.showInputDialog("Digite o nome do cliente:");
                    String codigo = JOptionPane.showInputDialog("Digite o codigo do pedido:");
                    try {
                        double total = sistema.calcularTotalPedido(codigo);
                        JOptionPane.showMessageDialog(null, "Valor do pedido R$: "+ total);
                    }catch (PedidoInexistenteException e){
                        JOptionPane.showMessageDialog(null, "Desculpe, pedido inexistente.");
                    }
                    break;
                case "3":
                    String CodPedidoAAdicionar = JOptionPane.showInputDialog("Qual o código do pedido?");
                    String nomeItem = JOptionPane.showInputDialog("Qual o item que deseja adicionar ao pedido?");
                    double valorItem = Double.parseDouble(JOptionPane.showInputDialog("Qual o preço do pedido?"));
                    Produto meuNovoLanche = new Produto(nomeItem,"",valorItem);
                    List<Produto> ItemAAdicionarLista= new ArrayList<>();
                    ItemAAdicionarLista.add(meuNovoLanche);
                    try {
                        sistema.adicionarAoPedido(CodPedidoAAdicionar, ItemAAdicionarLista);
                        JOptionPane.showMessageDialog(null, "O(s) item(s) foi/foram adicionado(s)!");
                    } catch (PedidoInexistenteException e) {
                        JOptionPane.showMessageDialog(null, "O pedido informado não existe.");
                    }
                    break;
                case "4":
                    String CodPedidoMudar = JOptionPane.showInputDialog("Qual o código do pedido?");
                    String StatusPedidoMudar =JOptionPane.showInputDialog("Qual o novo Status do pedido?\n aceito, preparando, entregando, entregue ou cancelado");
                    try{
                        sistema.atualizaStatusDoPedido(CodPedidoMudar, StatusPedido.valueOf(StatusPedidoMudar));
                        JOptionPane.showMessageDialog(null,"Status atualizado com sucesso!");
                    } catch (PedidoInexistenteException e){
                        JOptionPane.showMessageDialog(null,"Pedido Inexistente!");
                    }

                    break;
                case "5":
                    int diaPedido= Integer.parseInt(JOptionPane.showInputDialog("Qual o dia desejado?"));
                    int mesPedido= Integer.parseInt(JOptionPane.showInputDialog("Qual o mes desejado?"));
                    int anoPedido= Integer.parseInt(JOptionPane.showInputDialog("Qual o ano desejado?"));
                    List<Pedido> pedidosDoDia=sistema.pesquisarPedidosDoDia(diaPedido,mesPedido,anoPedido);
                    for( Pedido p :pedidosDoDia){
                        JOptionPane.showMessageDialog(null,p.toString());
                    }
                    if (sistema.pesquisarPedidosDoDia(diaPedido, mesPedido, anoPedido) == null){
                        JOptionPane.showMessageDialog(null,"Não existem pedidos neste dia.");
                    }

                    break;
                case "6":
                    String CodigoPedido = JOptionPane.showInputDialog("Qual o código do pedido? ");
                    try{
                        Pedido p =sistema.pesquisaPedidoPorCodigo(CodigoPedido);
                        JOptionPane.showMessageDialog(null,"Seu pedido é: "+p.toString());
                    } catch (PedidoInexistenteException e){
                        JOptionPane.showMessageDialog(null,"Desculpe, pedido Inexistente!");
                    }

                    break;
                case "7":
                    String CodigoPedidoACancelar = JOptionPane.showInputDialog("Qual o código do pedido que deseja cancelar? ");
                    try {
                        sistema.cancelarPedido(CodigoPedidoACancelar);
                        JOptionPane.showMessageDialog(null, "Pedido Cancelado!");
                    } catch (PedidoInexistenteException e){
                        JOptionPane.showMessageDialog(null,e.getMessage());
                    }

                    break;
                case "8":
                    try {
                        sistema.salvarPedido();
                        JOptionPane.showMessageDialog(null,"Pedidos salvos!");
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null,"Falha de Sistema!\nOs pedidos não foram salvos");
                        e.printStackTrace();
                    }
                    break;
                case "9":
                    continuar = false;
                    break;
            }
        }
    }
}