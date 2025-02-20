package br.ufpb.dcx.restaurante.classDeException;

public class PedidoExistenteException extends Exception{
    public PedidoExistenteException(String msg){
        super(msg);
    }
    public PedidoExistenteException(){
        super();
    }
}
