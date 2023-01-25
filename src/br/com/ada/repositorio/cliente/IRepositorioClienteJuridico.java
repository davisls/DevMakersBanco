package br.com.ada.repositorio.cliente;

import br.com.ada.clientes.IClienteJuridico;

import java.util.List;

public interface IRepositorioClienteJuridico<T extends IClienteJuridico> {
    List<T> retornarClientesJuridico();
    T retornarClientePorCnpj(String cnpj);
}
