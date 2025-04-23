package br.ufpb.dcx.restaurante.UI.Controller;

import br.ufpb.dcx.restaurante.SistemaRestaurante;
import br.ufpb.dcx.restaurante.UI.Panels.MenuSlide;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PedidosExistentesController implements ActionListener {
    private SistemaRestaurante sistema;
    private MenuSlide janela;

    public PedidosExistentesController(SistemaRestaurante sistema, MenuSlide janela){
        this.sistema = sistema;
        this.janela = janela;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(sistema.pesquisaTodosPedidos().isEmpty()){
            JOptionPane.showMessageDialog(janela,"Não existe pedidos atualmente!");
        } else{
            JOptionPane.showMessageDialog(janela,sistema.pesquisaTodosPedidos());
        }
    }
}
