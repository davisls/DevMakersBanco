package br.com.ada.repositorio.conta;

import br.com.ada.clientes.Cliente;
import br.com.ada.contas.Conta;

import java.util.List;

public interface IRepositorioConta<T> {

    List<T> retornarContaPorCliente(Cliente cliente);

    T retornarContaPorNumero(Cliente cliente, String numeroConta);

    void adiconarConta(Cliente cliente, Conta conta);

    void deletarConta(Cliente cliente, Conta conta);

}
