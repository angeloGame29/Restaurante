import br.ufpb.dcx.restaurante.*;
import br.ufpb.dcx.restaurante.classDeException.PedidoExistenteException;
import br.ufpb.dcx.restaurante.classDeException.PedidoInexistenteException;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ProgramaSistemaRestauranteTest {
    @Test
    public void testaCadastroAndExiste(){
        SistemaRestaurante sistema = new MeuSistemaRestaurante();
        ArrayList<ItemPedido> itens = new ArrayList<>();
        Lanche lanche = new Lanche("burgue",14);
        Bebida bebida = new Bebida("coca-cola", 5);
        itens.add(lanche);
        itens.add(bebida);

        Pedido pedido = new Pedido("Joao", "n002", "01",itens,new SistemaData(11,02,2024),"Aceito");
        try {
            sistema.cadastrarPedido(pedido);
            assertTrue(sistema.existePedidoCodigo(pedido.getCodPedido()));
        }catch (PedidoExistenteException e){
            e.printStackTrace();
            fail("Exceção não esperada!");
        }
    }

    @Test
    public void testpesquisarPedidosDoDia (){
        SistemaRestaurante sistema = new MeuSistemaRestaurante();
        ArrayList<ItemPedido> itens = new ArrayList<>();
        Lanche lanche = new Lanche("burgue",14);
        Bebida bebida = new Bebida("coca-cola", 5);
        itens.add(lanche);
        itens.add(bebida);

        Pedido pedido = new Pedido("Diogo", "n002", "01",itens,new SistemaData(11,02,2024),"Aceito");
        Pedido pedido2 = new Pedido("Ruan", "n003", "01",itens,new SistemaData(11,02,2024),"Aceito");
        try {
            sistema.cadastrarPedido(pedido);
            assertTrue(1 == sistema.pesquisarPedidosDoDia(11,02,2024).size());
            sistema.cadastrarPedido(pedido2);
            assertTrue(2== sistema.pesquisarPedidosDoDia(11,02,2024).size());

        }catch (PedidoExistenteException | PedidoInexistenteException e){
            e.printStackTrace();
            fail("Exceção não esperada!");
        }
    }
    @Test
    public void testAdicionarAoPedido(){
        SistemaRestaurante sistema = new MeuSistemaRestaurante();
        ArrayList<ItemPedido> itens = new ArrayList<>();
        Lanche lanche = new Lanche("burgue",14);
        Bebida bebida = new Bebida("coca-cola", 5);
        itens.add(lanche);
        itens.add(bebida);

        ArrayList<ItemPedido> itens2 = new ArrayList<>();
        Lanche lanche2 = new Lanche("pizza",35);
        Bebida bebida2 = new Bebida("coca-cola zero", 5);
        itens2.add(lanche2);
        itens2.add(bebida2);


        Pedido pedido = new Pedido("Diogo", "n002", "01",itens,new SistemaData(11,02,2024),"Aceito");
        try {
            sistema.cadastrarPedido(pedido);
            assertTrue(2 == sistema.pesquisaPedidoPorCodigo("n002").getItens().size());
            sistema.adicionarAoPedido("n002",itens2);
            assertEquals(sistema.pesquisaPedidoPorCodigo("n002").getItens().size(), 4);

        }catch (PedidoExistenteException | PedidoInexistenteException e){
            e.printStackTrace();
            fail("Exceção não esperada!");
        }
    }

    @Test
    public void testAtualizaStatusDoPedido(){
        SistemaRestaurante sistema = new MeuSistemaRestaurante();
        ArrayList<ItemPedido> itens = new ArrayList<>();
        Lanche lanche = new Lanche("burgue",14);
        Bebida bebida = new Bebida("coca-cola", 5);
        itens.add(lanche);
        itens.add(bebida);


        Pedido pedido = new Pedido("Diogo", "n002", "01",itens,new SistemaData(11,02,2024),"Aceito");
        try {
            sistema.cadastrarPedido(pedido);
            assertTrue(sistema.pesquisaPedidoPorCodigo("n002").getStatusPedido().equals("Aceito"));
            sistema.atualizaStatusDoPedido("n002","Preparando");
            assertTrue(sistema.pesquisaPedidoPorCodigo("n002").getStatusPedido().equals("Preparando"));

        }catch (PedidoExistenteException | PedidoInexistenteException e){
            e.printStackTrace();
            fail("Exceção não esperada!");
        }
    }

    @Test
    public void testCancelarPedido(){
        SistemaRestaurante sistema = new MeuSistemaRestaurante();
        ArrayList<ItemPedido> itens = new ArrayList<>();
        Lanche lanche = new Lanche("burgue",14);
        Bebida bebida = new Bebida("coca-cola", 5);
        itens.add(lanche);
        itens.add(bebida);


        Pedido pedido = new Pedido("Diogo", "n002", "01",itens,new SistemaData(11,02,2024),"Aceito");
        try {
            sistema.cadastrarPedido(pedido);
            assertTrue(sistema.existePedidoCodigo("n002"));
            sistema.cancelarPedido("n002");
            assertFalse(sistema.existePedidoCodigo("n002"));

        }catch (PedidoExistenteException | PedidoInexistenteException e){
            e.printStackTrace();
            fail("Exceção não esperada!");
        }
    }

    @Test
    public void testCalcularTotalPedido(){
        SistemaRestaurante sistema = new MeuSistemaRestaurante();

        ArrayList<ItemPedido> itens = new ArrayList<>();
        Lanche lanche = new Lanche("burgue",14);
        Bebida bebida = new Bebida("coca-cola", 5);
        itens.add(lanche);
        itens.add(bebida);

        ArrayList<ItemPedido> itens2 = new ArrayList<>();
        Lanche lanche2 = new Lanche("pizza",35);
        Bebida bebida2 = new Bebida("coca-cola zero", 5);
        itens2.add(lanche2);
        itens2.add(bebida2);


        Pedido pedido = new Pedido("Diogo", "n002", "01",itens,new SistemaData(11,02,2024),"Aceito");
        try {
            sistema.cadastrarPedido(pedido);
            assertTrue(19 == sistema.calcularTotalPedido("n002"));
            sistema.adicionarAoPedido("n002",itens2);
            assertEquals(59, sistema.calcularTotalPedido("n002"), 0.01);//delta é a margem de erro

        }catch (PedidoExistenteException | PedidoInexistenteException e){
            e.printStackTrace();
            fail("Exceção não esperada!");
        }
    }


}
