package br.ufpb.dcx.restaurante.UI.panels.footPanels;

import br.ufpb.dcx.restaurante.MeuSistemaRestaurante;
import br.ufpb.dcx.restaurante.Produto;
import br.ufpb.dcx.restaurante.SistemaRestaurante;
import br.ufpb.dcx.restaurante.UI.controller.PedidoController;
import br.ufpb.dcx.restaurante.UI.panels.MenuSlide;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoPane extends JPanel {
    private List<Produto> itens = new ArrayList<>();
    private JLabel labelTotal;
    private JButton comprar;
    SistemaRestaurante sistema;


    public CarrinhoPane(SistemaRestaurante sistema) {
        setLayout(new GridLayout(10,1)); // Painéis empilhados verticalmente
        setBackground(Color.WHITE);
        this.sistema = sistema;
        labelTotal = new JLabel("Total: R$ 0.00");
        labelTotal.setFont(new Font("Arial", Font.BOLD, 16));
        labelTotal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        comprar = new JButton("Comprar");

        comprar.addActionListener(new PedidoController(sistema, this));

        add(labelTotal); // Exibe o total no topo do painel
        add(comprar);
    }

    // Adiciona o painel e o produto
    public void adicionarProduto(PainelCarrinho painel, Produto produto) {
        itens.add(produto);
        this.add(painel);// Adiciona o painel visual ao carrinho
        atualizarCarrinho();// Atualiza o total
        revalidate();
        repaint();
    }

    // Remove o produto e o painel correspondente
    public void removerProduto(Produto produto, PainelCarrinho painel) {
        itens.remove(produto);
        this.remove(painel);
        atualizarCarrinho();
        revalidate();
        repaint();
    }

    private void atualizarCarrinho() {
        labelTotal.setText("Total: R$ " + String.format("%.2f", calcularTotal()));
    }


    private double calcularTotal() {
        return itens.stream().mapToDouble(Produto::getPreco).sum();
    }

}
