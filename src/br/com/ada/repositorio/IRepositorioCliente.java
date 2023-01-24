package br.com.ada.repositorio;

import br.com.ada.clientes.ICliente;

import java.util.List;

public interface IRepositorioCliente <T extends ICliente> extends IRepositorio<T>{
        List<T> retornarClientesPorNome(String nome);
}
