package br.com.ada.repositorio.conta;

import br.com.ada.clientes.Cliente;
import br.com.ada.contas.ContaPoupanca;
import br.com.ada.contas.TipoConta;

public class RepositorioContaPoupanca extends RepositorioConta implements IRepositorioContaPoupanca{

    private static final RepositorioContaPoupanca INSTANCE = new RepositorioContaPoupanca();

    public static RepositorioContaPoupanca getInstance() {
        return INSTANCE;
    }

    @Override
    public ContaPoupanca retornarContaPoupanca(Cliente cliente) {
        return retornarContaPorCliente(cliente).stream().filter(conta -> conta.getTipoConta() == TipoConta.POUPANCA)
                .map(conta -> (ContaPoupanca) conta)
                .findFirst()
                .orElse(null);
    }
}
