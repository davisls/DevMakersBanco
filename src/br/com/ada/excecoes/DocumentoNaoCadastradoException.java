package br.com.ada.excecoes;

public class DocumentoNaoCadastradoException extends RuntimeException{
    public DocumentoNaoCadastradoException(String message) {
        super(message);
    }
}
