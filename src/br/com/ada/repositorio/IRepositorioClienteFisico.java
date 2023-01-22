package br.com.ada.repositorio;

import br.com.ada.clientes.IClienteFisico;

import java.util.List;

public interface IRepositorioClienteFisico<T extends IClienteFisico> extends IRepositorioCliente{

    List<T> retornarClientesFisico();
    T retornarClientePorCpf(String cpf);
}
