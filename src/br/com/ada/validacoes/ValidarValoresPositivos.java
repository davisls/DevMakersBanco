package br.com.ada.validacoes;

import br.com.ada.excecoes.ValorNegativoException;


public class ValidarValoresPositivos {
    public void validarValoresPositivos(Double valor){
        if (valor < 0){
            throw new ValorNegativoException("Valor não pode ser negativo");
        }
    }
}
