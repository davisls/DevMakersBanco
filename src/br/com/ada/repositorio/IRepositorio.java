package br.com.ada.repositorio;

import java.util.List;

public interface IRepositorio<T> {
    List<T> retornarTodos();
    T retornarUmElemento(String id);
    void adicionar(T t);
    void deletar(T t);
}
