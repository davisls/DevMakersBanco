package br.com.ada.contas;

import br.com.ada.clientes.Cliente;
import br.com.ada.clientes.TipoCliente;
import br.com.ada.repositorio.cliente.RepositorioCliente;
import br.com.ada.repositorio.conta.RepositorioConta;

import java.util.List;

public abstract class Conta implements IConta {

    private String numeroConta;
    private Cliente cliente;
    private double saldo;
    private double taxaSaque;
    private double rendimentoDeposito;

    private TipoConta tipoConta;

    public Conta(Cliente cliente) {
        this.cliente = cliente;
        this.numeroConta = String.valueOf(((int) (Math.random() * 99999) + 10000));
        this.saldo = 0;
        this.taxaSaque = (cliente.getTipoCliente() == TipoCliente.FISICO ? 0 : 0.005);
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
        this.setSaldo(this.getSaldo() + valor + valor * this.getRendimentoDeposito());
    }

    @Override
    public void sacar(double valor) {
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
    public void transferir(double valor, String numeroContaDestino) {
        this.sacar(valor);

        Conta contaDestino = null;
        List<Cliente> clientes = RepositorioCliente.getInstance().retornarTodos();
        for (Cliente clienteCadastrado : clientes) {
            Conta conta = RepositorioConta.getInstance().retornarContaPorNumero(clienteCadastrado, numeroContaDestino);
            if (conta != null) contaDestino = conta;
        }
        contaDestino.depositar(valor);
    }

}
