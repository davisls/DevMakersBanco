package br.com.ada.validacoes;

public class ValidacaoString {

    public boolean validarTamanho(String string, int tamanho) {
        int tamanhoString = string.length();
        return (tamanhoString>tamanho);
    }


    public boolean validarVazio(String string) {
       return string.isBlank();
    }
}
