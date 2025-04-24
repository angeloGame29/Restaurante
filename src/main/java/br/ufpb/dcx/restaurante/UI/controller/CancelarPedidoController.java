package br.ufpb.dcx.restaurante.UI.controller;

import br.ufpb.dcx.restaurante.exceptions.PedidoInexistenteException;
import br.ufpb.dcx.restaurante.SistemaRestaurante;
import br.ufpb.dcx.restaurante.UI.panels.MenuSlide;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CancelarPedidoController implements ActionListener {
    private SistemaRestaurante sistema;
    private MenuSlide janela;
    public CancelarPedidoController(SistemaRestaurante sistema, MenuSlide janela){
        this.sistema = sistema;
        this.janela = janela;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String CodigoPedidoACancelar = JOptionPane.showInputDialog("Qual o código do pedido que deseja cancelar? ");
        try {
            sistema.cancelarPedido(CodigoPedidoACancelar);
            JOptionPane.showMessageDialog(janela, "Pedido Cancelado!");
        } catch (PedidoInexistenteException c){
            JOptionPane.showMessageDialog(janela,c.getMessage());
        }
    }
}
