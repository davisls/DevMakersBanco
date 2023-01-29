package br.com.ada.validacoes;

import br.com.ada.clientes.ClienteJuridico;
import br.com.ada.repositorio.cliente.RepositorioClienteJuridico;

import java.util.List;

public class ValidarCnpj {

    public boolean validarFormatoInput(String cnpj){
        ValidacaoDocumento validacaoDocumento = new ValidacaoDocumento();
        return validacaoDocumento.isCNPJ(cnpj);
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
