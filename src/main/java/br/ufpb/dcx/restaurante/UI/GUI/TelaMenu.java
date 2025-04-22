package br.ufpb.dcx.restaurante.UI.GUI;

import br.ufpb.dcx.restaurante.MeuSistemaRestaurante;
import br.ufpb.dcx.restaurante.Produto;
import br.ufpb.dcx.restaurante.SistemaRestaurante;
import br.ufpb.dcx.restaurante.UI.controller.PedidoController;
import br.ufpb.dcx.restaurante.UI.panels.BarraMenu;
import br.ufpb.dcx.restaurante.UI.panels.MenuSlide;
import br.ufpb.dcx.restaurante.UI.panels.Menufooter;
import br.ufpb.dcx.restaurante.UI.panels.footPanels.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TelaMenu extends JFrame {

    private CardLayout cardLayout;
    private JPanel painelCentral;
    private SistemaRestaurante sistemaRestaurante;

    public TelaMenu() {

        setTitle("MENU");
        setSize(850, 700);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.decode("#ee7e4c"));

        this.sistemaRestaurante = new MeuSistemaRestaurante();

        // Menu lateral
        MenuSlide menuWest = new MenuSlide(sistemaRestaurante);
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

        CarrinhoPane carrinhoPane = new CarrinhoPane(sistemaRestaurante);
        JScrollPane scrollCarrinho = new JScrollPane(carrinhoPane);
        scrollCarrinho.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollCarrinho.getVerticalScrollBar().setUnitIncrement(16);

        PesquisaPane pesquisaPane = new PesquisaPane();
        SistemaRestaurante sistema = new MeuSistemaRestaurante();
        sistema.cadastraCardapio("Pizza Margherita", "./imgs/cardapio/pizza.png", 25.00);
        sistema.cadastraCardapio("Hambúrguer", "./imgs/cardapio/hamburgue.jpg", 18.00);
        sistema.cadastraCardapio("Hambúrguer-Xbacon", "./imgs/cardapio/hamburgue.jpg", 18.00);
        sistema.cadastraCardapio("Hambúrguer-Xtudo", "./imgs/cardapio/hamburgue.jpg", 18.00);
        sistema.cadastraCardapio("Coxinha", "./imgs/cardapio/coxinha.png", 8.00);
        List<Produto> cardapio = sistema.cardapio();

        // Lista de produtos
//        List<Produto> cardapio = List.of(
//                new Produto("Pizza Margherita", "pizza.png", 25.00),
//                new Produto("Hambúrguer", "./imgs/hamburgue.jpg", 18.00),
//                new Produto("Suco Natural", "suco.png", 7.00),
//                new Produto("laranja","",2),
//                new Produto("pizza","", 10),
//                new Produto("suco","", 10),
//                new Produto("vinho","", 10),
//                new Produto("cerveja","", 10),
//                new Produto("pera","", 10),
//                new Produto("uva","", 10),
//                new Produto("salada","", 10)
//        );

        for (Produto p : cardapio) {
            PainelProduto painel = new PainelProduto(p, e -> {
                // Cria painel do produto no carrinho com ação de remoção
                PainelCarrinho painelC = new PainelCarrinho(p);
                painelC.adicionarRemoverListener(ev -> {
                    carrinhoPane.removerProduto(p, painelC);
                    PedidoController.removerProdutoDoPedido(p);
                });
                carrinhoPane.adicionarProduto(painelC, p);

                PedidoController.adicionarProdutoAoPedido(p);
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
