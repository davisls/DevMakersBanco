package br.com.ada.excecoes;

public class ContaNaoExisteException extends RuntimeException{
    public ContaNaoExisteException(String msg) {
        super(msg);
    }
}
