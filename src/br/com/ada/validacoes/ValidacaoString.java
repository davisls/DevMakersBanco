package br.com.ada.validacoes;

public class ValidacaoString {

    public boolean isTamanhoCorreto(String string, int tamanho) {
        int tamanhoString = string.length();
        return (tamanhoString == tamanho);
    }

    public boolean isVazio(String string) {
       return string.isBlank();
    }
}
