package br.com.ada.contas;

import br.com.ada.clientes.Cliente;
import br.com.ada.clientes.TipoCliente;
import br.com.ada.validacoes.ValidacaoConta;

import static br.com.ada.utilidades.InformacoesDeTaxas.TAXA_SAQUE_CLIENTE_FISICO;
import static br.com.ada.utilidades.InformacoesDeTaxas.TAXA_SAQUE_CLIENTE_JURIDICO;

public abstract class Conta implements IConta {

    private String numeroConta;
    private Cliente cliente;
    private double saldo;
    private double taxaSaque;
    private double rendimentoDeposito;
    private TipoConta tipoConta;
    private ValidacaoConta valida;

    public Conta(Cliente cliente) {
        this.cliente = cliente;
        this.numeroConta = String.valueOf(((int) (Math.random() * 99999) + 10000));
        this.saldo = 0;
        this.taxaSaque = (cliente.getTipoCliente() == TipoCliente.FISICO ? TAXA_SAQUE_CLIENTE_FISICO : TAXA_SAQUE_CLIENTE_JURIDICO);
        this.valida = new ValidacaoConta();
    }

    public String getNumeroConta() {
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
        this.setSaldo(this.getSaldo() + valor * this.getRendimentoDeposito());
    }

    @Override
    public void sacar(double valor) {
        double saqueComTaxa = valor * this.getTaxaSaque();
        valida.ValidaSaldoSuficienteParaSaque(saqueComTaxa, this.saldo);
//        try {
        //todo- colocar try catch na view
//        } catch (SaldoInsuficienteException ex) {
//            System.out.println(ex.getMessage());
//        }

        this.setSaldo(this.getSaldo() - saqueComTaxa);
    }

    @Override
    public void transferir(double valor, String numeroContaDestino) {
        //todo - tratar exceção na view
        Conta contaDestino = valida.ValidaContaDestino(numeroContaDestino);
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

}
