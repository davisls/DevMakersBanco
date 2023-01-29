package br.com.ada.repositorio.cliente;

import br.com.ada.clientes.ICliente;
import br.com.ada.repositorio.IRepositorio;

import java.util.List;

public interface IRepositorioCliente <T extends ICliente> extends IRepositorio<T> {
        List<T> retornarClientesPorNome(String nome);
}
