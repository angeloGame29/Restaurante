package br.ufpb.dcx.restaurante.UI.controller;

import br.ufpb.dcx.restaurante.SistemaRestaurante;
import br.ufpb.dcx.restaurante.UI.panels.MenuSlide;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SalvarDadosController implements ActionListener {
    private SistemaRestaurante sistema;
    private MenuSlide janela;

    public SalvarDadosController (SistemaRestaurante sistema, MenuSlide janela){
        this.sistema = sistema;
        this.janela = janela;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            sistema.salvarPedido();
            JOptionPane.showMessageDialog(janela,"Pedidos salvos!");
        } catch (IOException s) {
            JOptionPane.showMessageDialog(janela,"Falha de Sistema!\nOs pedidos não foram salvos");
            s.printStackTrace();
        }
    }
}
