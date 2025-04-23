package br.ufpb.dcx.restaurante.UI.Controller;

import br.ufpb.dcx.restaurante.Exceptions.PedidoInexistenteException;
import br.ufpb.dcx.restaurante.Pedido;
import br.ufpb.dcx.restaurante.SistemaRestaurante;
import br.ufpb.dcx.restaurante.UI.Panels.MenuSlide;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PesquisarPedidosPorDiaController implements ActionListener {
    private SistemaRestaurante sistema;
    private MenuSlide janela;
    public PesquisarPedidosPorDiaController(SistemaRestaurante sistema, MenuSlide janela){
        this.sistema = sistema;
        this.janela = janela;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        int diaPedido= Integer.parseInt(JOptionPane.showInputDialog("Qual o dia desejado?"));
        int mesPedido= Integer.parseInt(JOptionPane.showInputDialog("Qual o mes desejado?"));
        int anoPedido= Integer.parseInt(JOptionPane.showInputDialog("Qual o ano desejado?"));
        try {
            List<Pedido> pedidosDoDia = sistema.pesquisarPedidosDoDia(diaPedido, mesPedido, anoPedido);
            for (Pedido p : pedidosDoDia) {
                JOptionPane.showMessageDialog(janela, p.toString());
            }
        } catch (PedidoInexistenteException d){
            JOptionPane.showMessageDialog(janela,"Não existem pedidos neste dia.");
        }
    }
}
