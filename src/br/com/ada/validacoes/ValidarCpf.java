package br.com.ada.validacoes;

import br.com.ada.clientes.ClienteFisico;
import br.com.ada.repositorio.cliente.RepositorioClienteFisico;

import java.util.List;

public class ValidarCpf {

    public boolean validarFormatoInput(String cpf){
        ValidacaoDocumento validacaoDocumento = new ValidacaoDocumento();
        return validacaoDocumento.isCPF(cpf);
    }

    public boolean isCpfCadastrado(String cpf) {
        List<ClienteFisico> clientes = RepositorioClienteFisico.getInstance().retornarClientesFisico();
        for (ClienteFisico cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }
}
