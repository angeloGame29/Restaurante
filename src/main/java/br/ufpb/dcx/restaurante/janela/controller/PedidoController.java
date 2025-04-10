package br.ufpb.dcx.restaurante.janela.controller;

import br.ufpb.dcx.restaurante.*;
import br.ufpb.dcx.restaurante.classDeException.PedidoExistenteException;
import br.ufpb.dcx.restaurante.janela.GUI.TelaMenu;
import br.ufpb.dcx.restaurante.janela.pane.footPanes.CarrinhoPane;
import br.ufpb.dcx.restaurante.janela.pane.footPanes.PainelCarrinho;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PedidoController extends JDialog implements ActionListener {
    private static List<Produto> itensPedido = new ArrayList<>();
    SistemaRestaurante sistema = new MeuSistemaRestaurante();

    public void actionPerformed(ActionEvent e) {
        JDialog pedidoDialog = new JDialog(this, "",true);
        pedidoDialog.setTitle("Finalizar Pedido");
        pedidoDialog.setSize(600, 550);
        pedidoDialog.setLocationRelativeTo(null);
        pedidoDialog.setResizable(true);
        pedidoDialog.getContentPane().setBackground(Color.decode("#4b4452"));
        pedidoDialog.setLayout(new BorderLayout());

        JPanel header = new JPanel();
        JLabel titulo;
        header.setPreferredSize(new Dimension(0,50));
        header.setLayout(new BorderLayout());
        header.setBackground(Color.decode("#9b9b9b"));

        titulo = new JLabel("  Complete seu Pedido:");
        titulo.setForeground(Color.black);

        header.add(titulo, BorderLayout.WEST);

        JPanel body = new JPanel();
        body.setLayout(new BorderLayout());
        body.setPreferredSize(new Dimension(350,0));
        body.setBackground(Color.decode("#e9e9e9"));

        JPanel tituloDoBody = new JPanel();

        JPanel dados = new JPanel();
        dados.setLayout(new GridLayout(10,1, 10,10));
        dados.setBorder(new EmptyBorder(20,20,20,20));
        JLabel lblNome, lblCodigoPedido, lblItens, lblDataPedido;
        JTextField txtNome,txtCodPedido, txtData;

        lblNome = new JLabel("Nome cliente:");
        txtNome = new JTextField();

        lblCodigoPedido = new JLabel("Código pedido:");
        txtCodPedido = new JTextField();

        JComboBox<NumMesa> mesaBox = new JComboBox<>();
        mesaBox.addItem(NumMesa.MESA_01);
        mesaBox.addItem(NumMesa.MESA_02);
        mesaBox.addItem(NumMesa.MESA_03);
        mesaBox.addItem(NumMesa.MESA_04);
        mesaBox.addItem(NumMesa.MESA_05);


        lblDataPedido = new JLabel("Data do pedido:");
        txtData = new JTextField();

        JComboBox<StatusPedido> statusBox = new JComboBox<>();

        statusBox.addItem(StatusPedido.STATUS_ACEITO);
        statusBox.addItem(StatusPedido.STATUS_PREPARANDO);

        dados.add(lblNome);
        dados.add(txtNome);
        dados.add(lblCodigoPedido);
        dados.add(txtCodPedido);

        dados.add(mesaBox);

        dados.add(lblDataPedido);
        dados.add(txtData);

        dados.add(statusBox);

        JPanel botoes = new JPanel();
        botoes.setLayout(new GridLayout(1,2,10,20));
        botoes.setBorder(new EmptyBorder(10,20,20,20));

        JButton btFinalizar, btLimpar;
        btFinalizar = new JButton("FINALIZAR");
        btLimpar = new JButton("LIMPAR");
        botoes.add(btFinalizar);
        botoes.add(btLimpar);

        body.add(tituloDoBody, BorderLayout.NORTH);
        body.add(dados, BorderLayout.CENTER);
        body.add(botoes, BorderLayout.SOUTH);

        JPanel anside = new JPanel();
        anside.setPreferredSize(new Dimension(250,0));
        anside.setBorder(new EmptyBorder(20,30,20,10));
        anside.setLayout(new BorderLayout());
        anside.setBackground(Color.decode("#4b4452"));
        lblItens = new JLabel("Itens do pedido:");
        JTextArea itens = new JTextArea();
        itens.setText("");
        System.out.println("Qtd de produtos: " + itensPedido.size());
        for (Produto p : PedidoController.getItensPedido()) {
            itens.append("Produto: " + p.getNome() + "\n" +
                    "Preço: R$ " + p.getPreco() + "\n\n");
        }

        itens.setEditable(false);

        anside.add(lblItens,BorderLayout.NORTH);
        anside.add(itens, BorderLayout.CENTER);

        btFinalizar.addActionListener(event ->{
            String nome = txtNome.getText();
            String codPedido = txtCodPedido.getText();
            NumMesa numMesa = (NumMesa) mesaBox.getSelectedItem();
            List<Produto> produtos = itensPedido;
            SistemaData dataPedido = SistemaData.converteEmSistemaData(txtData.getText());
            StatusPedido statusPedido = (StatusPedido) statusBox.getSelectedItem();

            Pedido p = new Pedido(nome,codPedido,numMesa,produtos,dataPedido,statusPedido);

            try {
                sistema.cadastrarPedido(p);
                JOptionPane.showMessageDialog(pedidoDialog,"Pedido cadastrado com sucesso!");
            } catch (PedidoExistenteException ex) {
                JOptionPane.showMessageDialog(pedidoDialog, "pedido já existe: " + p.getCodPedido());
            }
            dispose();
        });

        pedidoDialog.add(header, BorderLayout.NORTH);
        pedidoDialog.add(body, BorderLayout.WEST);
        pedidoDialog.add(anside, BorderLayout.EAST);

        pedidoDialog.setVisible(true);
    }

    public static void adicionarProdutoAoPedido(Produto produto) {
        itensPedido.add(produto);
    }

    public static List<Produto> getItensPedido() {
        return itensPedido;
    }
    public static void removerProdutoDoPedido(Produto produto) {
        itensPedido.remove(produto);
    }
    public static void limparPedido() {
        itensPedido.clear();
    }
}
