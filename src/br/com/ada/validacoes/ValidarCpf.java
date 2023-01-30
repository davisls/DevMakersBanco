package br.com.ada.validacoes;

import br.com.ada.clientes.ClienteFisico;
import br.com.ada.excecoes.CpfFormatoInvalidoException;
import br.com.ada.excecoes.CpfNaoCadastradoException;
import br.com.ada.repositorio.cliente.RepositorioClienteFisico;

import java.util.List;

public class ValidarCpf {

    public void validarFormatoInput(String cpf){
        boolean validar;
        ValidacaoDocumento validacaoDocumento = new ValidacaoDocumento();
        validar = validacaoDocumento.isCPF(cpf);
        if (!validar){
            throw new CpfFormatoInvalidoException("Este cpf não esta em um formato válido.");
        }
    }

    public void isCpfCadastrado(String cpf) {
        boolean isCpfCadastrado = false;
        List<ClienteFisico> clientes = RepositorioClienteFisico.getInstance().retornarClientesFisico();
        for (ClienteFisico cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                isCpfCadastrado = true;
            }
        }
        if (isCpfCadastrado == false) {
            throw new CpfNaoCadastradoException("CPF não cadastrado!");
        }
    }
}
