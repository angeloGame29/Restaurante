package br.ufpb.dcx.restaurante.UI.controller;

import br.ufpb.dcx.restaurante.Pedido;
import br.ufpb.dcx.restaurante.SistemaRestaurante;
import br.ufpb.dcx.restaurante.UI.panels.MenuSlide;
import br.ufpb.dcx.restaurante.exception.PedidoInexistenteException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PesquisarPedidoController implements ActionListener {

    private SistemaRestaurante sistema;
    private MenuSlide janela;

    public PesquisarPedidoController(SistemaRestaurante sistema, MenuSlide janela){
        this.sistema = sistema;
        this.janela = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String CodigoPedido = JOptionPane.showInputDialog("Qual o código do pedido? ");
        try{
            Pedido p =sistema.pesquisaPedidoPorCodigo(CodigoPedido);
            JOptionPane.showMessageDialog(janela,"Seu pedido é: "+p.toString());
        } catch (PedidoInexistenteException p){
            JOptionPane.showMessageDialog(janela,"Desculpe, pedido Inexistente!");
        }
    }
}
