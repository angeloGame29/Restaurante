package br.ufpb.dcx.restaurante.UI.panels.footPanels;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PesquisaPane extends JPanel {
    JButton pesquisarPorCodigo, pesquisarPorDia, pesquisarSeExiste;
    public PesquisaPane(){
        setLayout(new GridLayout(7,1,5,5));
        setBorder(new EmptyBorder(10,20,10,20));
        setBackground(Color.decode("#ee7e4c"));
        JLabel lblText = new JLabel("TIPOS DE PESQUISA:", SwingConstants.CENTER);
        add(lblText);

        pesquisarPorCodigo = new JButton();
        pesquisarPorCodigo.setBackground(Color.decode("#ead56c"));

        pesquisarPorDia = new JButton();
        pesquisarPorDia.setBackground(Color.decode("#ead56c"));

        pesquisarSeExiste = new JButton();
        pesquisarSeExiste.setBackground(Color.decode("#ead56c"));

        add(pesquisarPorCodigo);
        add(pesquisarPorDia);
        add(pesquisarSeExiste);
    }
}
