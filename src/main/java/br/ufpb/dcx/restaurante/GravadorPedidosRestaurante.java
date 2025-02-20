package br.ufpb.dcx.restaurante;
import java.io.*;
import java.util.*;

public class GravadorPedidosRestaurante {
    public static final String NOME_PEDIDOS_RESTAURANTE = "pedidos.txt";

    public void gravarPedidos(List<Pedido> pedidos) throws IOException {
        List<String> textoDosPedidos = new ArrayList<>();
        for (Pedido p: pedidos) {
            String textoPedido = p.getNomeCliente() + "###" + p.getCodPedido() +
                    "###" + p.getNumMesa() + "###" + p.getItens().toString() + "###" +
                    p.getDataPedido().toString() + "###" + p.getStatusPedido();
            textoDosPedidos.add(textoPedido);
        }
        this.gravarTexto(textoDosPedidos);
    }

    public List<Pedido> recuperaPedidos() throws IOException {
        List<String> pedidosRestaurante = recuperaTexto();
        List<Pedido> pedidosRecuperados = new ArrayList<>();
        for (String lVisualizada : pedidosRestaurante) {
            String[] dados = lVisualizada.split("###");
            String nomeCliente = dados[0];
            String codPedido = dados[1];
            String numMesa = dados[2];
            List<ItemPedido> itens = converteItens(dados[3]); // Conversão dos itens
            SistemaData dataPedido = converteData(dados[4]); // Conversão da data
            String statusPedido = dados[5];

            Pedido pedido = new Pedido(nomeCliente, codPedido, numMesa, itens, dataPedido, statusPedido);
            pedidosRecuperados.add(pedido);
        }
        return pedidosRecuperados;
    }

    public void gravarTexto(List<String> texto) throws IOException{
        BufferedWriter escritor = null;
        try {
            escritor = new BufferedWriter(new FileWriter(NOME_PEDIDOS_RESTAURANTE));
            for (String s: texto){
                escritor.write(s+"\n");
            }
        }finally{
            if (escritor!=null){
                escritor.close();
            }
        }
    }

    public List<String> recuperaTexto() throws IOException{
        BufferedReader leitor = null;
        List<String> textoLido = new ArrayList<>();
        try {
            leitor = new BufferedReader(new FileReader(NOME_PEDIDOS_RESTAURANTE));
            String texto = null;
            do {
                texto = leitor.readLine();
                if (texto!=null){
                    textoLido.add(texto);
                }

            } while (texto!=null);
        }finally {
            if (leitor!=null){
                leitor.close();
            }
        }
        return textoLido;
    }

    // parte conversão;

    /**
     * Converte os dados Strings para dados ItemPedido
     * @param itensString recbe um dado String
     * @return retorna uma Lista de itens pedidos - List<ItemPedido>
     */
    public List<ItemPedido> converteItens(String itensString) {
        List<ItemPedido> itens = new ArrayList<>();
        itensString = itensString.replace("[", "").replace("]", "");//Vai trocar os chochetes por nada.
        String[] parteItens = itensString.split(";");

        for (String item : parteItens) {
            String[] dado = item.split(",");

            if (dado.length > 0 && dado.length % 2 == 0) { // A quantidade de detalhes vai ser sempre par
                for (int k = 0; dado.length > k; k += 2) {
                    String nomeItem = dado[k].trim();
                    double precoItem = Double.parseDouble(dado[k + 1].trim());
                    itens.add(new Lanche(nomeItem, precoItem));
                }
            }
        }

        return itens;
    }

    /**
     * converte dados String para dados de sistemaData
     * @param dataString recebe dados do tipo String
     * @return e retorna dados do tipo sistmeaData
     */
    public SistemaData converteData(String dataString) {
        String [] parteData = dataString.split("/");
        int dia = Integer.parseInt(parteData[0].trim());
        int mes = Integer.parseInt(parteData[1].trim());
        int ano = Integer.parseInt(parteData[2].trim());
        SistemaData dataConvertida = new SistemaData(dia,mes, ano);
        return dataConvertida;
    }

}