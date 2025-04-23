package br.ufpb.dcx.restaurante.Exceptions;

public class PedidoInexistenteException extends Exception{
    public PedidoInexistenteException(String msg){
        super(msg);
    }
    public PedidoInexistenteException(){
        super();
    }
}
