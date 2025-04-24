package br.ufpb.dcx.restaurante.UI.panels.footPanels;

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
