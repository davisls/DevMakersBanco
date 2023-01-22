package br.com.ada.repositorio;

import java.util.List;

public interface IRepositorio<T> {
    List<T> retornarTodos();
    void adicionar(T t);
    void deletar(T t);
}
