package br.ufpb.dcx.restaurante.UI.panels;

import br.ufpb.dcx.restaurante.SistemaRestaurante;
import br.ufpb.dcx.restaurante.UI.controller.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MenuSlide extends JPanel {
    JButton bnt1, bnt2, bnt3, bnt4;
    private SistemaRestaurante sistema;
    public MenuSlide(SistemaRestaurante sistema){
        setPreferredSize(new Dimension(160,0));
        setBorder(new EmptyBorder(5,10,10,10));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.decode("#4b4452"));
        this.sistema = sistema;
        RecuperarDadosController r = new RecuperarDadosController(sistema, this);
        new Thread(()-> r.actionPerformed(null)).start();

        bnt1 = new JButton("Gerenciamento");
        // Subpainel com botões ocultos
        JPanel painelSubMenuGeren = new JPanel();
        painelSubMenuGeren.setBackground(Color.decode("#4b4452"));
        painelSubMenuGeren.setFont(new Font("SansSerif", Font.CENTER_BASELINE, 20));
        painelSubMenuGeren.setLayout(new BoxLayout(painelSubMenuGeren, BoxLayout.Y_AXIS));
        painelSubMenuGeren.setVisible(false); // começa escondido

        // Subitens
        JButton subMenuCadastrar = new JButton("> Inserir ao cardapio");
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

        JButton subMenuCancelar = new JButton("> Cancelar Pedido");
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

        JButton subMenuTodosPedidos = new JButton("> Verificar se existe pedido");
        subMenuTodosPedidos.setBackground(null);
        subMenuTodosPedidos.setBorder(null);
        subMenuTodosPedidos.setFocusable(false);
        subMenuTodosPedidos.setForeground(Color.lightGray);
        subMenuTodosPedidos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        JButton subMenuAdd = new JButton("> Adicionar ao pedido");
        subMenuAdd.setBackground(null);
        subMenuAdd.setBorder(null);
        subMenuAdd.setFocusable(false);
        subMenuAdd.setForeground(Color.lightGray);
        subMenuAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));



        painelSubMenuSistema.add(subMenuCalcular);
        painelSubMenuSistema.add(subMenuAdd);

        bnt3 = new JButton("Consulta");
        JPanel painelSubMenuConsulta = new JPanel();
        painelSubMenuConsulta.setBackground(Color.decode("#4b4452"));
        painelSubMenuConsulta.setFont(new Font("SansSerif", Font.CENTER_BASELINE, 20));
        painelSubMenuConsulta.setLayout(new BoxLayout(painelSubMenuConsulta, BoxLayout.Y_AXIS));
        painelSubMenuConsulta.setVisible(false);

        JButton subMenuPdia = new JButton("> Pesquisar pedidos do dia");
        subMenuPdia.setBackground(null);
        subMenuPdia.setBorder(null);
        subMenuPdia.setFocusable(false);
        subMenuPdia.setForeground(Color.lightGray);
        subMenuPdia.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        JButton subMenuPcodigo = new JButton("> Pesquisar pelo código");
        subMenuPcodigo.setBackground(null);
        subMenuPcodigo.setBorder(null);
        subMenuPcodigo.setFocusable(false);
        subMenuPcodigo.setForeground(Color.lightGray);
        subMenuPcodigo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        painelSubMenuConsulta.add(subMenuPdia);
        painelSubMenuConsulta.add(subMenuPcodigo);
        painelSubMenuConsulta.add(subMenuTodosPedidos);

        bnt4 = new JButton("Sair");



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
            if (painelSubMenuGeren.isVisible()) {
                painelSubMenuGeren.setVisible(!painelSubMenuGeren.isVisible());
                revalidate(); // atualiza layout
                repaint();
            }
            painelSubMenuSistema.setVisible(!painelSubMenuSistema.isVisible());
            revalidate(); // atualiza layout
            repaint();
        });
        bnt3.addActionListener(e -> {
            if (painelSubMenuSistema.isVisible()){//se o painel sistema tiver visivel, fecha ele pra mim
                painelSubMenuSistema.setVisible(!painelSubMenuSistema.isVisible());
                revalidate(); // atualiza layout
                repaint();
            }//e abre o consulta
            painelSubMenuConsulta.setVisible(!painelSubMenuConsulta.isVisible());
            revalidate(); // atualiza layout
            repaint();
        });
        bnt4.addActionListener(e -> {
            for (Window w: Window.getWindows()){
                w.dispose();
            }
        });
        subMenuCalcular.addActionListener(new CalcularPedidoController(sistema, this));
        subMenuSalvar.addActionListener(new SalvarDadosController(sistema,this));
        subMenuPcodigo.addActionListener(new PesquisarPedidoPorCodigoController(sistema, this));
        subMenuAdd.addActionListener(new AddAoPedidoController(sistema, this));
        subMenuTodosPedidos.addActionListener(new PedidosExistentesController(sistema, this));
        subMenuPdia.addActionListener(new PesquisarPedidosPorDiaController(sistema,this));
        subMenuCancelar.addActionListener(new CancelarPedidoController(sistema, this));
        add(bnt1);
        add(painelSubMenuGeren);
        add(bnt2);
        add(painelSubMenuSistema);
        add(bnt3);
        add(painelSubMenuConsulta);
        add(bnt4);
    }
}
