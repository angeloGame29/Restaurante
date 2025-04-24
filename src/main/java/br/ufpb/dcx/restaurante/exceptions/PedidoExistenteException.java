package br.ufpb.dcx.restaurante.exceptions;

public class PedidoExistenteException extends Exception{
    public PedidoExistenteException(String msg){
        super(msg);
    }
    public PedidoExistenteException(){
        super();
    }
}
