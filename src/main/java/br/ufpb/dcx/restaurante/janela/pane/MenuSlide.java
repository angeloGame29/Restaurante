package br.ufpb.dcx.restaurante.janela.pane;

import javax.swing.*;
import java.awt.*;

public class MenuSlide extends JPanel {
    JButton bnt1, bnt2, bnt3, bnt4;
    public MenuSlide(){
        setPreferredSize(new Dimension(160,0));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.decode("#4b4452"));

        bnt1 = new JButton("Gerenciamento");

        // Subpainel com botões ocultos
        JPanel painelSubMenu = new JPanel();
        painelSubMenu.setBackground(Color.decode("#4b4452"));
        painelSubMenu.setLayout(new BoxLayout(painelSubMenu, BoxLayout.Y_AXIS));
        painelSubMenu.setVisible(false); // começa escondido

        // Subitens
        JButton btnFuncionarios = new JButton(">Cadastrar Pedido");
        btnFuncionarios.setBackground(null);
        btnFuncionarios.setBorder(null);
        btnFuncionarios.setFocusable(false);
        btnFuncionarios.setForeground(Color.lightGray);

        btnFuncionarios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        JButton btnProdutos = new JButton(">Salvar Pedidos");
        btnProdutos.setBackground(null);
        btnProdutos.setBorder(null);
        btnProdutos.setFocusable(false);
        btnProdutos.setForeground(Color.lightGray);
        btnProdutos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        painelSubMenu.add(btnFuncionarios);
        painelSubMenu.add(btnProdutos);

        bnt2 = new JButton("Sistema");
        //TODO IMPLEMENTAR : Subpainel com botões ocultos

        bnt3 = new JButton("Consulta");
        //TODO IMPLEMENTAR : Subpainel com botões ocultos

        bnt4 = new JButton("Sair");
        //TODO IMPLEMENTAR : Subpainel com botões ocultos


        bnt1.setBackground(null);
        bnt1.setBorder(null);
        bnt1.setFocusable(false);
        bnt1.setForeground(Color.WHITE);
        bnt1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        bnt2.setBackground(null);
        bnt2.setBorder(null);
        bnt2.setFocusable(false);
        bnt2.setForeground(Color.WHITE);
        bnt2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        bnt3.setBackground(null);
        bnt3.setBorder(null);
        bnt3.setFocusable(false);
        bnt3.setForeground(Color.WHITE);
        bnt3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        bnt4.setBackground(null);
        bnt4.setBorder(null);
        bnt4.setFocusable(false);
        bnt4.setForeground(Color.WHITE);
        bnt4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));


        // Ação de clique
        bnt1.addActionListener(e -> {
            painelSubMenu.setVisible(!painelSubMenu.isVisible());
            revalidate(); // atualiza layout
            repaint();
        });

        add(bnt1);
        add(painelSubMenu);
        add(bnt2);
        add(bnt3);
        add(bnt4);
    }
}
