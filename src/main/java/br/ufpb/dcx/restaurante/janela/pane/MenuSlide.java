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
        JPanel painelSubMenuGeren = new JPanel();
        painelSubMenuGeren.setBackground(Color.decode("#4b4452"));
        painelSubMenuGeren.setFont(new Font("SansSerif", Font.CENTER_BASELINE, 20));
        painelSubMenuGeren.setLayout(new BoxLayout(painelSubMenuGeren, BoxLayout.Y_AXIS));
        painelSubMenuGeren.setVisible(false); // começa escondido

        // Subitens
        JButton subMenuCadastrar = new JButton("> Cadastrar Pedido");
        subMenuCadastrar.setBackground(null);
        subMenuCadastrar.setBorder(null);
        subMenuCadastrar.setFocusable(false);
        subMenuCadastrar.setForeground(Color.lightGray);
        subMenuCadastrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        JButton subMenuSalvar = new JButton("> Salvar Pedidos");
        subMenuSalvar.setBackground(null);
        subMenuSalvar.setBorder(null);
        subMenuSalvar.setFocusable(false);
        subMenuSalvar.setForeground(Color.lightGray);
        subMenuSalvar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        JButton subMenuCancelar = new JButton("> Cancelar");
        subMenuCancelar.setBackground(null);
        subMenuCancelar.setBorder(null);
        subMenuCancelar.setFocusable(false);
        subMenuCancelar.setForeground(Color.lightGray);
        subMenuCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        painelSubMenuGeren.add(subMenuCadastrar);
        painelSubMenuGeren.add(subMenuSalvar);
        painelSubMenuGeren.add(subMenuCancelar);

        bnt2 = new JButton("Sistema");
        JPanel painelSubMenuSistema = new JPanel();
        painelSubMenuSistema.setBackground(Color.decode("#4b4452"));
        painelSubMenuSistema.setFont(new Font("SansSerif", Font.CENTER_BASELINE, 20));
        painelSubMenuSistema.setLayout(new BoxLayout(painelSubMenuSistema, BoxLayout.Y_AXIS));
        painelSubMenuSistema.setVisible(false);

        JButton subMenuCalcular = new JButton("> Calcular Pedidos");
        subMenuCalcular.setBackground(null);
        subMenuCalcular.setBorder(null);
        subMenuCalcular.setFocusable(false);
        subMenuCalcular.setForeground(Color.lightGray);
        subMenuCalcular.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        JButton subMenuExiste = new JButton("> Verificar");
        subMenuExiste.setBackground(null);
        subMenuExiste.setBorder(null);
        subMenuExiste.setFocusable(false);
        subMenuExiste.setForeground(Color.lightGray);
        subMenuExiste.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        JButton subMenuAdd = new JButton("> Adicionar pedido");
        subMenuAdd.setBackground(null);
        subMenuAdd.setBorder(null);
        subMenuAdd.setFocusable(false);
        subMenuAdd.setForeground(Color.lightGray);
        subMenuAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));



        painelSubMenuSistema.add(subMenuCalcular);
        painelSubMenuSistema.add(subMenuExiste);
        painelSubMenuSistema.add(subMenuAdd);

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
            painelSubMenuGeren.setVisible(!painelSubMenuGeren.isVisible());
            revalidate(); // atualiza layout
            repaint();
        });
        bnt2.addActionListener(e -> {
            painelSubMenuSistema.setVisible(!painelSubMenuSistema.isVisible());
            revalidate(); // atualiza layout
            repaint();
        });

        add(bnt1);
        add(painelSubMenuGeren);
        add(bnt2);
        add(painelSubMenuSistema);
        add(bnt3);
        add(bnt4);
    }
}
