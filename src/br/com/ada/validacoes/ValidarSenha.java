package br.com.ada.validacoes;

import br.com.ada.clientes.Cliente;
import br.com.ada.excecoes.SenhaErradaException;
import br.com.ada.excecoes.SenhaForaDoPadraoException;
import br.com.ada.utilidades.InformacoesDeInput;

public class ValidarSenha extends ValidacaoString{

    public void validarTamanhoSenha(String senha) throws SenhaForaDoPadraoException{
        if (!isTamanhoCorreto(senha, InformacoesDeInput.TAMANHO_SENHA)) {
            throw new SenhaForaDoPadraoException("A senha precisa ter " + InformacoesDeInput.TAMANHO_SENHA + " caracteres");
        }

    }

    public void validarSenhaDoCliente(Cliente cliente, String senha) throws SenhaErradaException {
        if (!cliente.verificaSenha(senha)) {
            throw new SenhaErradaException("A senha digitada não corresponde a senha cadastrada.");

        }
    }
}
