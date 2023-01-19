package br.com.ada.contas;

import br.com.ada.clientes.Cliente;

public abstract class Conta {

    private int numeroConta;
    private Cliente cliente;
    private double saldo;

    public int getNumeroConta() {
        return numeroConta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void transferencia(double saldo) {

    }




}
