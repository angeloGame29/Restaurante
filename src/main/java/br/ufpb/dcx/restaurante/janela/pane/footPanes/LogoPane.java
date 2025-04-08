package br.ufpb.dcx.restaurante.janela.pane.footPanes;

import javax.swing.*;
import java.awt.*;

public class LogoPane extends JPanel {
    public LogoPane(){
        setLayout(new GridLayout(1,1));
        setBackground(Color.decode("#ee7e4c"));
        JLabel lblText = new JLabel("logo", SwingConstants.CENTER);
        add(lblText);
    }
}
