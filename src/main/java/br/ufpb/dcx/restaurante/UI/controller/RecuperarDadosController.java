package br.ufpb.dcx.restaurante.UI.controller;

import br.ufpb.dcx.restaurante.SistemaRestaurante;
import br.ufpb.dcx.restaurante.UI.panels.MenuSlide;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class RecuperarDadosController implements ActionListener {
    private SistemaRestaurante sistema;
    private MenuSlide janela;
    public RecuperarDadosController(SistemaRestaurante sistema, MenuSlide janela){
        this.sistema = sistema;
        this.janela = janela;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            sistema.recuperarPedido();
            JOptionPane.showMessageDialog(janela, "Tudo pronto!\nSeus dados foram recuperados sem problemas.");
        } catch (IOException s) {
            JOptionPane.showMessageDialog(janela, "Interrupção temporária.\nDados não recuperados");
        }
    }
}
