package br.com.ada.repositorio.conta;

import br.com.ada.clientes.Cliente;
import br.com.ada.contas.ContaInvestimento;

public interface IRepositorioContaInvestimento {
    ContaInvestimento retornarContaInvestimento(Cliente cliente);
}
