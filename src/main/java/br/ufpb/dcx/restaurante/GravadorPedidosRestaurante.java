package br.ufpb.dcx.restaurante;
import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.Collection;

import static java.lang.System.in;

public class GravadorPedidosRestaurante {
    private String arquivoRestaurante;

    public GravadorPedidosRestaurante (){
        this.arquivoRestaurante= "pedidos.txt";

    }

    public Collection<Pedido> recuperaPedidos() throws IOException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(this.arquivoRestaurante))){
            Collection<Pedido> pedidosEncontrados = (ArrayList<Pedido>) in.readObject();
            return pedidosEncontrados;
        } catch (ClassNotFoundException | ClassCastException e) {
            throw new RuntimeException(e);
        }
    }

    public void gravarPedidos(Collection<Pedido> pedidos) throws IOException {
        ArrayList<Pedido> pedidosArrayList = new ArrayList<>();
        pedidosArrayList.addAll(pedidos);
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(arquivoRestaurante))){
            out.writeObject(pedidosArrayList);
        }

    }
}