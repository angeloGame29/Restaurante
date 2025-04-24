package br.ufpb.dcx.restaurante.UI.panels;

import br.ufpb.dcx.restaurante.UI.controller.UsuarioController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static br.ufpb.dcx.restaurante.UI.panels.ModImagem.deixaTamanhoIcon;

public class BarraMenu extends JPanel {
    private MenuSlide menuSlide;
    private JButton bntMenu, bntUser;

    JLabel titulo;
    ImageIcon logo = new ImageIcon("./imgs/icones/logoRes.png");
    ImageIcon user = new ImageIcon("./imgs/icones/user.png");
    ImageIcon menu = new ImageIcon("./imgs/icones/menu.png");
    public BarraMenu (MenuSlide menuSlide){
        this.menuSlide = menuSlide;

        //============CONFIGURAÇÕES DO PANE====================
        setPreferredSize(new Dimension(0, 100));
        setLayout(new GridLayout(2,1));

        JPanel menuInformacoes = new JPanel();
        menuInformacoes.setBackground(Color.decode("#ead56c"));
        menuInformacoes.setLayout(new BorderLayout());

        titulo = new JLabel("SISTEMA RESTAURANTE");
        titulo.setFont(new Font("SansSerif", Font.BOLD, 18));
        titulo.setForeground(Color.black);

        bntUser = new JButton(deixaTamanhoIcon(user));
        bntUser.setBackground(null);
        bntUser.setFocusable(false);
        bntUser.setBorder(null);
        bntUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        JLabel lblLogo = new JLabel(deixaTamanhoIcon(logo));

        JPanel menuBnt = new JPanel();
        menuBnt.setBackground(Color.decode("#d94052"));
        menuBnt.setLayout(new BorderLayout());

        Label lblMenu = new Label("MENU");
        lblMenu.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblMenu.setForeground(Color.black);

        bntMenu = new JButton(deixaTamanhoIcon(menu));
        bntMenu.setBackground(null);
        bntMenu.setFocusable(false);
        bntMenu.setFocusable(false);
        bntMenu.setBorder(null);
        bntMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        menuBnt.add(bntMenu, BorderLayout.WEST);
        menuBnt.add(lblMenu,BorderLayout.CENTER);

        bntMenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                boolean isVisible = menuSlide.isVisible();
                menuSlide.setVisible(!isVisible); // Alterna visibilidade
                revalidate(); // Atualiza layout
                repaint();
            }
        });
        bntUser.addActionListener(new UsuarioController() {
        });

        menuInformacoes.add(bntUser,BorderLayout.EAST);
        menuInformacoes.add(lblLogo, BorderLayout.WEST);
        menuInformacoes.add(titulo, BorderLayout.CENTER);
        add(menuInformacoes);
        add(menuBnt);
    }
}
