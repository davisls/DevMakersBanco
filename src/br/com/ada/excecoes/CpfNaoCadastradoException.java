package br.com.ada.excecoes;

public class CpfNaoCadastradoException extends RuntimeException{
    public CpfNaoCadastradoException(String message) {
        super(message);
    }
}
