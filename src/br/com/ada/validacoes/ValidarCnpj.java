package br.com.ada.validacoes;

import br.com.ada.clientes.ClienteJuridico;
import br.com.ada.excecoes.DocumentoFormatoInvalidoException;
import br.com.ada.repositorio.cliente.RepositorioClienteJuridico;

import java.util.List;

public class ValidarCnpj {

    public void validarFormatoInputCnpj(String cnpj){
        boolean validar;
        ValidacaoDocumento validacaoDocumento = new ValidacaoDocumento();
        validar = validacaoDocumento.isCNPJ(cnpj);
        if (!validar){
            throw new DocumentoFormatoInvalidoException("Este CNPJ não esta em um formato válido.");
        }
    }
    public boolean isCnpjCadastrado(String cnpj) {
        List<ClienteJuridico> clientes = RepositorioClienteJuridico.getInstance().retornarClientesJuridico();
        for (ClienteJuridico cliente : clientes) {
            if (cliente.getCnpj().equals(cnpj)) {
                return true;
            }
        }
        return false;
    }
}
