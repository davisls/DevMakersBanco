package br.com.ada.validacoes;

import br.com.ada.clientes.Cliente;
import br.com.ada.contas.Conta;
import br.com.ada.excecoes.ContaNaoExisteException;
import br.com.ada.excecoes.SaldoInsuficienteException;
import br.com.ada.repositorio.cliente.RepositorioCliente;
import br.com.ada.repositorio.conta.RepositorioConta;

import java.util.List;

public class ValidacaoConta {

    public void ValidaSaldoSuficienteParaSaque(double saque, double saldo) {
        if (saque < saldo) {
            throw new SaldoInsuficienteException("Seu saldo é insuficiente para a transação");
        }
    }

    public Conta ValidaContaDestino(String numeroContaDestino) {
        Conta contaDestino = null;
        List<Cliente> clientes = RepositorioCliente.getInstance().retornarTodos();
        for (Cliente clienteCadastrado : clientes) {
            contaDestino = RepositorioConta.getInstance().retornarContaPorNumero(clienteCadastrado, numeroContaDestino);
            if (contaDestino != null) {
                return contaDestino;
            }
        }
        throw new ContaNaoExisteException("A conta destino não existe em nosso cadastro");
    }
}
