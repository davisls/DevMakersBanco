package br.com.ada.repositorio.conta;

import br.com.ada.clientes.Cliente;
import br.com.ada.contas.ContaCorrente;
import br.com.ada.contas.TipoConta;

public class RepositorioContaCorrente extends RepositorioConta implements IRepositorioContaCorrente{

    private static final RepositorioContaCorrente INSTANCE = new RepositorioContaCorrente();

    public static RepositorioContaCorrente getInstance() {
        return INSTANCE;
    }

    @Override
    public ContaCorrente retornarContaCorrente(Cliente cliente) {
        return retornarContaPorCliente(cliente).stream().filter(conta -> conta.getTipoConta() == TipoConta.CORRENTE)
                .map(conta -> (ContaCorrente) conta)
                .findFirst()
                .orElse(null);
    }
}
