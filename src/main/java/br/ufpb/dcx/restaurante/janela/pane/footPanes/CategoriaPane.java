package br.ufpb.dcx.restaurante.janela.pane.footPanes;

import javax.swing.*;
import java.awt.*;

public class CategoriaPane extends JPanel {
    public CategoriaPane (){
        setLayout(new GridLayout(1,1));
        setBackground(Color.decode("#ee7e4c"));
        JLabel lblText = new JLabel("categoria", SwingConstants.CENTER);
        add(lblText);
    }
}
