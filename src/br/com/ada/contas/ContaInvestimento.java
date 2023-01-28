package br.com.ada.contas;

import br.com.ada.clientes.Cliente;
import br.com.ada.clientes.TipoCliente;
import br.com.ada.utils.Verificar;

public class ContaInvestimento extends Conta {
    public ContaInvestimento(Cliente cliente) {
        super(cliente);
        super.setTipoConta(TipoConta.INVESTIMENTO);
        // todo
        super.setRendimentoDeposito(cliente.getTipoCliente() == TipoCliente.FISICO ? 1.015 : 1.035);
    }

    Verificar verificar = new Verificar();
    @Override
    public void depositar(double valor) {
        this.setSaldo(this.getSaldo() + (valor * this.getRendimentoDeposito()));
    }

    @Override
    public void sacar(double valor) {
        double taxa = valor * this.getTaxaSaque();
        double saque = valor + taxa;
        double saldo = getSaldo();
        verificar.existeSaldo(saque, saldo);
        this.setSaldo(this.getSaldo() - saque);
    }

    public void transferir(double valor, Conta contaDestino) {
        sacar(valor);
        contaDestino.depositar(valor);;
    }

}
