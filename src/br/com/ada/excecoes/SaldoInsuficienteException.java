package br.com.ada.excecoes;

public class SaldoInsuficienteException extends RuntimeException{
    public SaldoInsuficienteException(String msg) {
        super(msg);
    }
}
