package br.ufpb.dcx.restaurante.UI.panels;

import br.ufpb.dcx.restaurante.UI.GUI.TelaMenu;
import br.ufpb.dcx.restaurante.UI.panels.footPanels.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static br.ufpb.dcx.restaurante.UI.panels.ModImagem.colorirIcon;
import static br.ufpb.dcx.restaurante.UI.panels.ModImagem.deixaTamanhoIcon;

public class Menufooter extends JPanel {
    private HomePane homePane;
    private CategoriaPane categoriaPane;
    private LogoPane logoPane;
    private CarrinhoPane carrinhoPane;
    private PesquisaPane pesquisaPane;
    private TelaMenu telaMenu;


    ImageIcon iconeCarrinho = new ImageIcon("./imgs/icones/carrinho.png");
    ImageIcon iconeCategoria = new ImageIcon("./imgs/icones/categoria.png");
    ImageIcon iconeHome = new ImageIcon("./imgs/icones/home.png");
    ImageIcon iconeMenu = new ImageIcon("./imgs/icones/logo.png");
    ImageIcon iconePesquisar = new ImageIcon("./imgs/icones/pesquisar.png");

    JButton bttHome, bttCategoria,bttLogo, bttCarrinho, bttPesquisa;
    private static JButton botaoAtivo = null;

    private static final Color corOriginal = Color.decode("#ee7e4c");
    private static final Color corAnimada = Color.decode("#ead56c");

    public Menufooter(HomePane homePane, CategoriaPane categoriaPane, LogoPane logoPane,
                      CarrinhoPane carrinhoPane, PesquisaPane pesquisaPane, TelaMenu telaMenu) {
        this.homePane = homePane;
        this.categoriaPane = categoriaPane;
        this.logoPane = logoPane;
        this.carrinhoPane = carrinhoPane;
        this.pesquisaPane = pesquisaPane;
        this.telaMenu = telaMenu;

        setPreferredSize(new Dimension(0,70));
        setVisible(true);
        setLayout(new GridLayout(1,5));
        setBackground(Color.decode("#ead56c"));
        bttHome = new JButton(deixaTamanhoIcon(iconeHome));
        bttCategoria = new JButton(deixaTamanhoIcon(iconeCategoria));
        bttLogo = new JButton(deixaTamanhoIcon(iconeMenu));
        bttCarrinho = new JButton(deixaTamanhoIcon(iconeCarrinho));
        bttPesquisa = new JButton(deixaTamanhoIcon(iconePesquisar));

        bttHome.setBackground(null);
        bttHome.setBorder(null);
        bttHome.setFocusable(false);
        bttHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        bttCategoria.setBackground(null);
        bttCategoria.setBorder(null);
        bttCategoria.setFocusable(false);
        bttCategoria.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        bttLogo.setBackground(null);
        bttLogo.setBorder(null);
        bttLogo.setFocusable(false);
        bttLogo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        bttCarrinho.setBackground(null);
        bttCarrinho.setBorder(null);
        bttCarrinho.setFocusable(false);
        bttCarrinho.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        bttPesquisa.setBackground(null);
        bttPesquisa.setBorder(null);
        bttPesquisa.setFocusable(false);
        bttPesquisa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));


        ActionListener animarNoClick = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton clicado = (JButton) e.getSource();

                if (botaoAtivo != null) {
                    //Muda ícone e cor do botão anterior
                    ImageIcon iconeAnterior = (ImageIcon) botaoAtivo.getIcon();
                    botaoAtivo.setIcon(colorirIcon(iconeAnterior, Color.black));
                    botaoAtivo.setBackground(corAnimada);
                }

                //Muda ícone e cor do botão clicado
                ImageIcon iconeNovo = (ImageIcon) clicado.getIcon();
                clicado.setIcon(colorirIcon(iconeNovo, corAnimada));
                clicado.setBackground(corOriginal);

                botaoAtivo = clicado;
            }
        };

        //=============================EVENTO DOS BOTÕES==============================
        bttHome.addActionListener(e -> telaMenu.mostrarPainel("HOME"));
        bttCategoria.addActionListener(e -> telaMenu.mostrarPainel("CATEGORIA"));
        bttLogo.addActionListener(e -> telaMenu.mostrarPainel("LOGO"));
        bttCarrinho.addActionListener(e -> telaMenu.mostrarPainel("CARRINHO"));
        bttPesquisa.addActionListener(e -> telaMenu.mostrarPainel("PESQUISA"));

        bttLogo.addActionListener(animarNoClick);
        bttPesquisa.addActionListener(animarNoClick);
        bttCarrinho.addActionListener(animarNoClick);
        bttCategoria.addActionListener(animarNoClick);
        bttHome.addActionListener(animarNoClick);

        bttHome.setToolTipText("HOME");
        bttCategoria.setToolTipText("CATEGORIA");
        bttLogo.setToolTipText("LOGO");
        bttCarrinho.setToolTipText("CARRINHO");
        bttPesquisa.setToolTipText("PESQUISA");

        add(bttHome);
        add(bttCategoria);
        add(bttLogo);
        add(bttCarrinho);
        add(bttPesquisa);

    }

}
