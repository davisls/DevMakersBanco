package br.com.ada.repositorio;

import br.com.ada.clientes.IClienteJuridico;

import java.util.List;

public interface IRepositorioClienteJuridico<T extends IClienteJuridico> extends IRepositorioCliente {
    List<T> retornarClientesJuridico();
    T retornarClientePorCnpj(String cnpj);
}
