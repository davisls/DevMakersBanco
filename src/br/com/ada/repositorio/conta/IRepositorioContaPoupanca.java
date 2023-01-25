package br.com.ada.repositorio.conta;

import br.com.ada.clientes.Cliente;
import br.com.ada.contas.ContaPoupanca;

public interface IRepositorioContaPoupanca {
    ContaPoupanca retornarContaPoupanca(Cliente cliente);
}
