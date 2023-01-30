package br.com.ada.excecoes;

public class CpfFormatoInvalidoException extends RuntimeException {
    public CpfFormatoInvalidoException(String s) {
        super(s);
    }
}
