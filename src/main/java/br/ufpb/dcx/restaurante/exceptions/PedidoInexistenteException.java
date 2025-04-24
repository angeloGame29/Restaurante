package br.ufpb.dcx.restaurante.exceptions;

public class PedidoInexistenteException extends Exception{
    public PedidoInexistenteException(String msg){
        super(msg);
    }
    public PedidoInexistenteException(){
        super();
    }
}
