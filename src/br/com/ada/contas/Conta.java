package br.com.ada.contas;

import br.com.ada.clientes.Cliente;
import br.com.ada.clientes.TipoCliente;

public abstract class Conta implements IConta {

    private int numeroConta;
    private Cliente cliente;
    private double saldo;
    private double taxaSaque;
    private double rendimentoDeposito;

    private TipoConta tipoConta;

    public Conta(Cliente cliente) {
        this.cliente = cliente;
        this.numeroConta = (int)(Math.random() * 99999) + 10000;
        this.saldo = 0;
        this.taxaSaque = (cliente.getTipoCliente() == TipoCliente.FISICO ? 0 : 0.005);
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

    public void setTaxaSaque(double taxaSaque) {
        this.taxaSaque = taxaSaque;
    }

    public double getTaxaSaque() {
        return taxaSaque;
    }

    public void setRendimentoDeposito(double rendimentoDeposito) {
        this.rendimentoDeposito = rendimentoDeposito;
    }

    public double getRendimentoDeposito() {
        return rendimentoDeposito;
    }

    public void depositar(double valor) {
        this.setSaldo(this.getSaldo() + valor + valor * this.getRendimentoDeposito());
    }

    @Override
    public void sacar(double valor) {
        //double taxa = 0;

//        if (this.getCliente().getTipoCliente() == TipoCliente.JURIDICO) {
//            taxa = 0.005;
//        }

        double saqueComTaxa = valor + (valor * this.getTaxaSaque());
        //todo - separar em um outro método essa validação de saldo suficiente
        if (saqueComTaxa > getSaldo()) {
            System.out.println("saldo indisponível");
            return;
            //todo - fazer exceção
        }

        this.setSaldo(this.getSaldo() - saqueComTaxa);
    }



    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

}
