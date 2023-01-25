package br.com.ada.repositorio.cliente;

import br.com.ada.banco.Banco;
import br.com.ada.clientes.Cliente;

import java.util.List;
import java.util.stream.Collectors;

public class RepositorioCliente implements IRepositorioCliente<Cliente>{

    private static final RepositorioCliente INSTANCE = new RepositorioCliente();

    public static RepositorioCliente getInstance() {
        return INSTANCE;
    }

    @Override
    public List<Cliente> retornarTodos() {
        return Banco.getInstance().getClienteList();
    }

    @Override
    public Cliente retornarUmElemento(String id) {
        return retornarTodos().stream().filter(cliente -> cliente.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElseThrow();
    }

    @Override
    public void adicionar(Cliente cliente) {
        List<Cliente> clientes = retornarTodos();
        clientes.add(cliente);
        Banco.getInstance().setClienteList(clientes);
    }

    @Override
    public void deletar(Cliente cliente) {
        boolean remove = retornarTodos().remove(cliente);
        if (remove) System.out.println("cliente removido");
    }

    @Override
    public List<Cliente> retornarClientesPorNome(String nome) {
        return retornarTodos().stream().filter(cliente -> cliente.getNome() == nome).collect(Collectors.toList());
    }
}
