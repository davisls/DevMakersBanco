package br.com.ada.contas;

import br.com.ada.clientes.Cliente;

public class ContaCorrente extends Conta implements IConta {
    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }
    @Override
    public void depositar() {

    }

    @Override
    public void sacar() {

    }

    @Override
    public void investir() {

    }
}
