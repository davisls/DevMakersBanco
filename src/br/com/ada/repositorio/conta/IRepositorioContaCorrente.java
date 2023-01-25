package br.com.ada.repositorio.conta;

import br.com.ada.clientes.Cliente;
import br.com.ada.contas.ContaCorrente;

public interface IRepositorioContaCorrente {
    ContaCorrente retornarContaCorrente(Cliente cliente);
}
