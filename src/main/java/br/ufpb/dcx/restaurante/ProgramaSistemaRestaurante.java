package br.ufpb.dcx.restaurante;

import br.ufpb.dcx.restaurante.classDeException.PedidoExistenteException;
import br.ufpb.dcx.restaurante.classDeException.PedidoInexistenteException;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProgramaSistemaRestaurante {
//    public static void main(String[] args) throws PedidoInexistenteException {
//        SistemaRestaurante sistema = new MeuSistemaRestaurante();
//        try {
//            sistema.recuperarPedido();
//            JOptionPane.showMessageDialog(null,"Tudo pronto!\nSeus dados foram recuperados sem problemas.");
//        } catch (IOException e) {
//            JOptionPane.showMessageDialog(null,"Interrupção temporária.\nDados não recuperados");
//            e.printStackTrace();
//        }
//
//        boolean continuar = true;
//        while (continuar) {
//            String opcao = JOptionPane.showInputDialog("Escolha uma opção:" +
//                    "\n1 - Cadastrar pedido" +
//                    "\n2 - Calcular total do pedido" +
//                    "\n3 - Adicionar ao pedido" +
//                    "\n4 - Atualizar status do pedido" +
//                    "\n5 - Pesquisar pedidos do dia" +
//                    "\n6 - Pesquisar pedido por código" +
//                    "\n7 - Cancelar pedido" +
//                    "\n8 - Salvar dados" +
//                    "\n9 - Sair"
//            );
//            switch (opcao) {
//                case "1"://Cadastrar pedido
//                    String nomeCLiente = JOptionPane.showInputDialog("Digite o nome do Cliente:");
//                    String codPedido = JOptionPane.showInputDialog("Digite o codigo do Pedido:");
//                    String numMesa = JOptionPane.showInputDialog("Digite o número da Mesa:");
//                    List<ItemPedido> itensDoPedido = new ArrayList<>();
//                    boolean concluir = true;
//                    while (concluir) {
//                        String opcoesDeItens = JOptionPane.showInputDialog("Escolha uma opção:" +
//                                "\n1- Lanches" +
//                                "\n2- Bebidas" +
//                                "\n3- Pronto"
//                        );
//
//                        switch (opcoesDeItens) {
//                            case "1":
//                                String nomeLanche = JOptionPane.showInputDialog("Digite o nome do lanche:");
//                                double precolanche = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do lanche:"));
//                                Lanche lancheNovo = new Lanche(nomeLanche,precolanche);
//                                itensDoPedido.add(lancheNovo);
//                                break;
//                            case "2":
//                                String nomeBebida = JOptionPane.showInputDialog("Digite o nome da Bebida:");
//                                double precoBebida = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor da Bebida:"));
//                                Lanche bebidaNova = new Lanche(nomeBebida,precoBebida);
//                                itensDoPedido.add(bebidaNova);
//                                break;
//                            case "3":
//                                concluir = false;
//                                break;
//                        }
//                    }//fim do while
//                    try {
//                        int dia = Integer.parseInt(JOptionPane.showInputDialog("Digite o dia do pedido:"));
//                        int mes = Integer.parseInt(JOptionPane.showInputDialog("Digite o mês:"));
//                        int ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano:"));
//                        SistemaData data = new SistemaData(dia, mes, ano);
//                        String status = JOptionPane.showInputDialog("Digite o status: [ACEITO, PREPARANDO, ENTREGUE]");
//                        Pedido pedido = new Pedido(nomeCLiente, codPedido, numMesa, itensDoPedido, data, status);
//                        try {
//                            sistema.cadastrarPedido(pedido);
//                            JOptionPane.showMessageDialog(null, "Pedido cadastrado com sucesso!");
//                        } catch (PedidoExistenteException e) {
//                            JOptionPane.showMessageDialog(null, "Pedido não cadastrado.");
//                        }
//                    }catch (NumberFormatException e){
//                        JOptionPane.showMessageDialog(null,"Por favor, ensira um número valido.");
//                    }
//
//                        // SistemaData dataPedido
//                        break;
//                        case "2"://Calcular total do pedido
//                            String nomePedidoT = JOptionPane.showInputDialog("Digite o nome do cliente:");
//                            String codigo = JOptionPane.showInputDialog("Digite o codigo do pedido:");
//                            try {
//                                double total = sistema.calcularTotalPedido(codigo);
//                                JOptionPane.showMessageDialog(null, "Valor do pedido R$: "+ total);
//                            }catch (PedidoInexistenteException e){
//                                JOptionPane.showMessageDialog(null, "Desculpe, pedido inexistente.");
//                            }
//                            break;
//                        case "3"://Adicionar a  pedido
//                            String CodPedidoAAdicionar = JOptionPane.showInputDialog("Qual o código do pedido?");
//                            String nomeItem = JOptionPane.showInputDialog("Qual o item que deseja adicionar ao pedido?");
//                            double valorItem = Double.parseDouble(JOptionPane.showInputDialog("Qual o preço do pedido?"));
//                            Lanche meuNovoLanche = new Lanche(nomeItem,valorItem);
//                            List<ItemPedido> ItemAAdicionarLista= new ArrayList<>();
//                            ItemAAdicionarLista.add(meuNovoLanche);
//                            try {
//                                sistema.adicionarAoPedido(CodPedidoAAdicionar, ItemAAdicionarLista);
//                                JOptionPane.showMessageDialog(null, "O(s) item(s) foi/foram adicionado(s)!");
//                            } catch (PedidoInexistenteException e) {
//                                JOptionPane.showMessageDialog(null, "O pedido informado não existe.");
//                            }
//                            break;
//                        case "4"://Atualizar status do pedido
//                            String CodPedidoMudar = JOptionPane.showInputDialog("Qual o código do pedido?");
//                            String StatusPedidoMudar =JOptionPane.showInputDialog("Qual o novo Status do pedido?\n aceito, preparando, entregando, entregue ou cancelado");
//                            try{
//                                sistema.atualizaStatusDoPedido(CodPedidoMudar,StatusPedidoMudar);
//                                JOptionPane.showMessageDialog(null,"Status atualizado com sucesso!");
//                            } catch (PedidoInexistenteException e){
//                                JOptionPane.showMessageDialog(null,"Pedido Inexistente!");
//                            }
//
//                            break;
//                        case "5"://Pesquisar pedidos no dia
//                            int diaPedido= Integer.parseInt(JOptionPane.showInputDialog("Qual o dia desejado?"));
//                            int mesPedido= Integer.parseInt(JOptionPane.showInputDialog("Qual o mes desejado?"));
//                            int anoPedido= Integer.parseInt(JOptionPane.showInputDialog("Qual o ano desejado?"));
//                            List<Pedido> pedidosDoDia=sistema.pesquisarPedidosDoDia(diaPedido,mesPedido,anoPedido);
//                            for( Pedido p :pedidosDoDia){
//                                JOptionPane.showMessageDialog(null,p.toString());
//                            }
//                            if (sistema.pesquisarPedidosDoDia(diaPedido, mesPedido, anoPedido) == null){
//                                JOptionPane.showMessageDialog(null,"Não existem pedidos neste dia.");
//                            }
//
//                            break;
//                        case "6"://Pesquisar pedido do código
//                            String CodigoPedido = JOptionPane.showInputDialog("Qual o código do pedido? ");
//                            try{
//                                Pedido p =sistema.pesquisaPedidoPorCodigo(CodigoPedido);
//                                JOptionPane.showMessageDialog(null,"Seu pedido é: "+p.toString());
//                            } catch (PedidoInexistenteException e){
//                                JOptionPane.showMessageDialog(null,"Desculpe, pedido Inexistente!");
//                            }
//
//                            break;
//                        case "7"://Cancelar pedido
//                            String CodigoPedidoACancelar = JOptionPane.showInputDialog("Qual o código do pedido que deseja cancelar? ");
//                            try {
//                                sistema.cancelarPedido(CodigoPedidoACancelar);
//                                JOptionPane.showMessageDialog(null, "Pedido Cancelado!");
//                                } catch (PedidoInexistenteException e){
//                                JOptionPane.showMessageDialog(null,e.getMessage());
//                            }
//
//                            break;
//                        case "8"://Salvar dados
//                            try {
//                                sistema.salvarPedido();
//                                JOptionPane.showMessageDialog(null,"Pedidos salvos!");
//                            } catch (IOException e) {
//                                JOptionPane.showMessageDialog(null,"Falha de Sistema!\nOs pedidos não foram salvos");
//                                e.printStackTrace();
//                            }
//                            break;
//                        case "9"://sair
//                            continuar = false;
//                            break;
//
//                    }
//            }//fim do while 1
//        }
    }
