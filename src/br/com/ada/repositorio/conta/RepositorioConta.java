package br.com.ada.repositorio.conta;

import br.com.ada.clientes.Cliente;
import br.com.ada.contas.Conta;

import java.util.List;

public class RepositorioConta implements IRepositorioConta{

    private static final RepositorioConta INSTANCE = new RepositorioConta();

    public static RepositorioConta getInstance() {
        return INSTANCE;
    }
    @Override
    public List<Conta> retornarContaPorCliente(Cliente cliente) {
        return cliente.getContas();
    }

    @Override
    public Conta retornarContaPorNumero(Cliente cliente, String numeroConta) {
        return retornarContaPorCliente(cliente).stream().filter(conta -> conta.getNumeroConta() == Integer.parseInt(numeroConta))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void adiconarConta(Cliente cliente, Conta conta) {
        retornarContaPorCliente(cliente).add(conta);
    }

    @Override
    public void deletarConta(Cliente cliente, Conta conta) {
        retornarContaPorCliente(cliente).remove(conta);
    }
}
