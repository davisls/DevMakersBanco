package br.com.ada.contas;

import br.com.ada.clientes.Cliente;

public class ContaPoupanca extends Conta implements IConta {
    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }
    @Override
    public void depositar(double valor) {

    }

    @Override
    public void sacar(double valor) {

    }

    @Override
    public void investir(double valor) {

    }
}
