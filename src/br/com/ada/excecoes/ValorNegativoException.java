package br.com.ada.excecoes;

public class ValorNegativoException extends RuntimeException {
    public ValorNegativoException(String message) {
        super(message);
    }
}
