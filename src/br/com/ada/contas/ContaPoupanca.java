package br.com.ada.contas;

import br.com.ada.clientes.Cliente;

public class ContaPoupanca extends Conta implements IConta {
    public ContaPoupanca(Cliente cliente) {
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
