package br.com.ada.contas;

import br.com.ada.clientes.Cliente;

public abstract class Conta {

    private int numeroConta;
    private Cliente cliente;
    private double saldo;

    private TipoConta tipoConta;

    public Conta(Cliente cliente) {
        this.cliente = cliente;
        this.numeroConta = (int)(Math.random() * 99999) + 10000;
        this.saldo = 0;
    }

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

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

}
