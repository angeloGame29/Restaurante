package br.ufpb.dcx.restaurante.janela.pane.footPanes;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class HomePane extends JPanel {

    public HomePane() {
        setLayout(new GridLayout(2, 5, 10, 10)); // Um item abaixo do outro
        setBorder(BorderFactory.createTitledBorder("Cardápio"));
        setBackground(Color.decode("#fff5ec"));
    }

    public void adicionarProduto(PainelProduto produto) {
        this.add(produto);
    }
}
