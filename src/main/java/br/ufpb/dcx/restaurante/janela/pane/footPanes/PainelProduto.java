package br.ufpb.dcx.restaurante.janela.pane.footPanes;

import br.ufpb.dcx.restaurante.Produto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PainelProduto extends JPanel {

    public PainelProduto(Produto produto, ActionListener aoAdicionar) {
        setLayout(new BorderLayout(5, 5));
        setBorder(BorderFactory.createLineBorder(Color.GRAY));
        setBackground(Color.WHITE);

        // Imagem do produto
        ImageIcon icon = new ImageIcon(produto.getImagemPath());
        Image img = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        JLabel imagemLabel = new JLabel(new ImageIcon(img), JLabel.CENTER);

        // Nome + preço
        JLabel nomeLabel = new JLabel(produto.toString(), JLabel.CENTER);

        // Botão de adicionar
        JButton btnAdd = new JButton("Adicionar");
        btnAdd.addActionListener(aoAdicionar);

        add(nomeLabel, BorderLayout.NORTH);
        add(imagemLabel, BorderLayout.CENTER);
        add(btnAdd, BorderLayout.SOUTH);
    }
}
