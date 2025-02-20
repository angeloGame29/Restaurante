package br.ufpb.dcx.restaurante;

import br.ufpb.dcx.restaurante.classDeException.PedidoExistenteException;
import br.ufpb.dcx.restaurante.classDeException.PedidoInexistenteException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

    public class TestaRestaurante {
        public static void main(String[] args) {
                SistemaRestaurante sistema = new MeuSistemaRestaurante();
                Scanner sc = new Scanner(System.in);

                List<ItemPedido> meusI = new ArrayList<>();
                Lanche burger = new Lanche("burguer ", 5.55);
                Bebida coca = new Bebida("coca", 4.95);
                meusI.add(burger);
                meusI.add(coca);

               // Pedido p1 = new Pedido("joao", "555", "b56", meusI, new SistemaData(11, 02, 2024), "cancelado");
            try {
                sistema.cadastrarPedido("joao", "555", "b56", meusI, new SistemaData(11, 02, 2024), "cancelado");
            } catch (PedidoExistenteException e) {
                throw new RuntimeException(e);
            }

            double valor = 0;
            try {
                valor = sistema.calcularTotalPedido("joao","555");
            } catch (PedidoInexistenteException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Valor total do pedido: R$ " + valor);

            try {
                System.out.println(sistema.PesquisaPedidoPorCodigo("555").toString());
            } catch (PedidoInexistenteException e) {
                throw new RuntimeException(e);
            }

            sc.close();
            }
        }




