package br.com.ada.repositorio.cliente;

import br.com.ada.clientes.ClienteJuridico;
import br.com.ada.clientes.TipoCliente;

import java.util.List;
import java.util.stream.Collectors;

public class RepositorioClienteJuridico extends RepositorioCliente implements IRepositorioClienteJuridico<ClienteJuridico>{

    private static final RepositorioClienteJuridico INSTANCE = new RepositorioClienteJuridico();

    public static RepositorioClienteJuridico getInstance() {
        return INSTANCE;
    }

    @Override
    public List<ClienteJuridico> retornarClientesJuridico() {
        return retornarTodos().stream().filter(cliente -> cliente.getTipoCliente() == TipoCliente.JURIDICO)
                .map(clienteJuridico -> (ClienteJuridico) clienteJuridico)
                .collect(Collectors.toList());
    }

    @Override
    public ClienteJuridico retornarClientePorCnpj(String cnpj) {
        return retornarClientesJuridico().stream().filter(clienteJuridico -> clienteJuridico.getCnpj().equalsIgnoreCase(cnpj))
                .findFirst().orElseThrow();
    }
}
