package br.ufpb.dcx.restaurante.UI.controller;

import br.ufpb.dcx.restaurante.SistemaRestaurante;
import br.ufpb.dcx.restaurante.UI.panels.MenuSlide;
import br.ufpb.dcx.restaurante.exceptions.PedidoInexistenteException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcularPedidoController implements ActionListener {
    private SistemaRestaurante sistema;
    private MenuSlide janela;

    public CalcularPedidoController(SistemaRestaurante sistema, MenuSlide janela){
        this.sistema = sistema;
        this.janela = janela;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String nomePedidoT = JOptionPane.showInputDialog("Digite o nome do cliente:");
        String codigo = JOptionPane.showInputDialog("Digite o codigo do pedido:");
        try {
            double total = sistema.calcularTotalPedido(codigo);
            JOptionPane.showMessageDialog(janela, "Valor do pedido R$: "+ total);
        }catch (
                PedidoInexistenteException j){
            JOptionPane.showMessageDialog(janela, "Desculpe, pedido inexistente.");
        }
    }
}
