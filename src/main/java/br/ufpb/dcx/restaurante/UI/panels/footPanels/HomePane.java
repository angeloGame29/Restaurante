package br.ufpb.dcx.restaurante.UI.panels.footPanels;

import javax.swing.*;
import java.awt.*;

public class HomePane extends JPanel {

    public HomePane() {
        setLayout(new GridLayout(2, 5, 10, 10)); // Um item abaixo do outro
        setBorder(BorderFactory.createTitledBorder("Cardápio"));
        setBackground(Color.decode("#ee7e4c"));
    }

    public void adicionarProduto(PainelProduto produto) {
        this.add(produto);
    }
}
