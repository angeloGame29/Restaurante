package br.ufpb.dcx.restaurante.janela.pane.footPanes;

import br.ufpb.dcx.restaurante.Produto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PainelCarrinho extends JPanel {
    private JButton btnRemover = new JButton("Remover");

    public PainelCarrinho(Produto produto) {
        setLayout(new BorderLayout(5, 5));
        setBorder(BorderFactory.createLineBorder(Color.GRAY));
        setBackground(new Color(255, 245, 230));

        JLabel nome = new JLabel(produto.getNome());
        JLabel preco = new JLabel("R$ " + String.format("%.2f", produto.getPreco()));

        add(nome, BorderLayout.CENTER);
        add(preco, BorderLayout.EAST);
        add(btnRemover, BorderLayout.SOUTH);
    }

    // Novo método para adicionar listener depois
    public void adicionarRemoverListener(ActionListener listener) {
        btnRemover.addActionListener(listener);
    }
}
