package br.ufpb.dcx.restaurante.janela.pane.footPanes;

import javax.swing.*;
import java.awt.*;

public class PesquisaPane extends JPanel {
    public PesquisaPane(){
        setLayout(new GridLayout(1,1));
        setBackground(Color.decode("#ee7e4c"));
        JLabel lblText = new JLabel("pesquisar", SwingConstants.CENTER);
        add(lblText);
    }
}
