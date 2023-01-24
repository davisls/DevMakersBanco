package br.com.ada.repositorio;

import br.com.ada.clientes.ClienteFisico;
import br.com.ada.clientes.TipoCliente;

import java.util.List;
import java.util.stream.Collectors;

public class RepositorioClienteFisico extends RepositorioCliente implements IRepositorioClienteFisico<ClienteFisico>{
    private static final RepositorioClienteFisico INSTANCE = new RepositorioClienteFisico();

    public static RepositorioClienteFisico getInstance() {
        return INSTANCE;
    }


    @Override
    public List<ClienteFisico> retornarClientesFisico() {
        return retornarTodos().stream().filter(cliente -> cliente.getTipoCliente() == TipoCliente.FISICO)
                .map(clienteFisico -> (ClienteFisico) clienteFisico)
                .collect(Collectors.toList());
    }

    @Override
    public ClienteFisico retornarClientePorCpf(String cpf) {

        return retornarClientesFisico().stream().filter(clienteFisico -> clienteFisico.getCpf().equalsIgnoreCase(cpf))
                .findFirst()
                .orElseThrow();
    }
}
