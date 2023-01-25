package br.com.ada.repositorio.conta;

import br.com.ada.clientes.Cliente;
import br.com.ada.contas.ContaInvestimento;
import br.com.ada.contas.TipoConta;

public class RepositorioContaInvestimento extends RepositorioConta implements IRepositorioContaInvestimento{

    private static final RepositorioContaInvestimento INSTANCE = new RepositorioContaInvestimento();

    public static RepositorioContaInvestimento getInstance() {
        return INSTANCE;
    }

    @Override
    public ContaInvestimento retornarContaInvestimento(Cliente cliente) {
        return retornarContaPorCliente(cliente).stream().filter(conta -> conta.getTipoConta() == TipoConta.INVESTIMENTO)
                .map(conta -> (ContaInvestimento) conta)
                .findFirst()
                .orElse(null);
    }
}
