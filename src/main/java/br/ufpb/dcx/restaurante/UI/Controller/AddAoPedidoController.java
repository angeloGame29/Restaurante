package br.ufpb.dcx.restaurante.UI.Controller;

import br.ufpb.dcx.restaurante.Exceptions.PedidoInexistenteException;
import br.ufpb.dcx.restaurante.Produto;
import br.ufpb.dcx.restaurante.SistemaRestaurante;
import br.ufpb.dcx.restaurante.UI.Panels.MenuSlide;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AddAoPedidoController implements ActionListener {
    private SistemaRestaurante sistema;
    private MenuSlide janela;
    public AddAoPedidoController(SistemaRestaurante sistema, MenuSlide janela){
        this.sistema=sistema;
        this.janela=janela;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String CodPedidoAAdicionar = JOptionPane.showInputDialog("Qual o código do pedido?");
        String nomeItem = JOptionPane.showInputDialog("Qual o item que deseja adicionar ao pedido?");
        double valorItem = Double.parseDouble(JOptionPane.showInputDialog("Qual o preço do pedido?"));
        Produto meuNovoLanche = new Produto(nomeItem,"",valorItem);
        List<Produto> ItemAAdicionarLista= new ArrayList<>();
        ItemAAdicionarLista.add(meuNovoLanche);
        try {
            sistema.adicionarAoPedido(CodPedidoAAdicionar, ItemAAdicionarLista);
            JOptionPane.showMessageDialog(janela, "O(s) item(s) foi/foram adicionado(s)!");
        } catch (PedidoInexistenteException a) {
            JOptionPane.showMessageDialog(janela, "O pedido informado não existe.");
        }
    }
}
