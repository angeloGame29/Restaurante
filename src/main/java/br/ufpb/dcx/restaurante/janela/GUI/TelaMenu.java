package br.ufpb.dcx.restaurante.janela.GUI;

import br.ufpb.dcx.restaurante.Produto;
import br.ufpb.dcx.restaurante.janela.pane.BarraMenu;
import br.ufpb.dcx.restaurante.janela.pane.MenuSlide;
import br.ufpb.dcx.restaurante.janela.pane.Menufooter;
import br.ufpb.dcx.restaurante.janela.pane.footPanes.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TelaMenu extends JFrame {

    private CardLayout cardLayout;
    private JPanel painelCentral;

    public TelaMenu() {


        setTitle("MENU");
        setSize(600, 550);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.decode("#ee7e4c"));

        // Menu lateral
        MenuSlide menuWest = new MenuSlide();
        menuWest.setVisible(false);
        add(menuWest, BorderLayout.WEST);

        // Barra superior
        BarraMenu menuNorth = new BarraMenu(menuWest);
        add(menuNorth, BorderLayout.NORTH);

        // CardLayout para alternar os painéis centrais
        cardLayout = new CardLayout();
        painelCentral = new JPanel(cardLayout);


        // Criando os painéis
        HomePane homePane = new HomePane();
        JScrollPane scrollHome = new JScrollPane(homePane);
        scrollHome.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollHome.getVerticalScrollBar().setUnitIncrement(16);

        CategoriaPane categoriaPane = new CategoriaPane();

        LogoPane logoPane = new LogoPane();

        CarrinhoPane carrinhoPane = new CarrinhoPane();
        JScrollPane scrollCarrinho = new JScrollPane(carrinhoPane);
        scrollCarrinho.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollCarrinho.getVerticalScrollBar().setUnitIncrement(16);

        PesquisaPane pesquisaPane = new PesquisaPane();

        // Lista de produtos
        List<Produto> produtos = List.of(
                new Produto("Pizza Margherita", "pizza.png", 25.00),
                new Produto("Hambúrguer", "./imgs/hamburgue.jpg", 18.00),
                new Produto("Suco Natural", "suco.png", 7.00),
                new Produto("laranja","",2),
                new Produto("pizza","", 10),
                new Produto("suco","", 10),
                new Produto("vinho","", 10),
                new Produto("cerveja","", 10),
                new Produto("pera","", 10),
                new Produto("uva","", 10),
                new Produto("salada","", 10)
        );

        for (Produto p : produtos) {
            PainelProduto painel = new PainelProduto(p, e -> {
                // Cria painel do produto no carrinho com ação de remoção
                PainelCarrinho painelC = new PainelCarrinho(p); // construtor sem listener
                painelC.adicionarRemoverListener(ev -> carrinhoPane.removerProduto(p, painelC));
                carrinhoPane.adicionarProduto(painelC, p);
            });

            homePane.adicionarProduto(painel);
        }

        // Adicionando os painéis ao cardLayout
        painelCentral.add(scrollHome, "HOME");
        painelCentral.add(categoriaPane, "CATEGORIA");
        painelCentral.add(logoPane, "LOGO");
        painelCentral.add(scrollCarrinho, "CARRINHO");
        painelCentral.add(pesquisaPane, "PESQUISA");

        add(painelCentral, BorderLayout.CENTER);

        // Rodapé
        Menufooter menuSouth = new Menufooter(homePane, categoriaPane, logoPane, carrinhoPane, pesquisaPane, this);
        add(menuSouth, BorderLayout.SOUTH);
        mostrarPainel("HOME");
    }

    // Método para trocar o pane
    public void mostrarPainel(String nomePainel) {
        cardLayout.show(painelCentral, nomePainel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaMenu minhaTela = new TelaMenu();
            minhaTela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            minhaTela.setVisible(true);
        });
    }
}
