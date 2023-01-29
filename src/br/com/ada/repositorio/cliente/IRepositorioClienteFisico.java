package br.com.ada.repositorio.cliente;

import br.com.ada.clientes.IClienteFisico;

import java.util.List;

public interface IRepositorioClienteFisico<T extends IClienteFisico>{

    List<T> retornarClientesFisico();
    T retornarClientePorCpf(String cpf);
}
