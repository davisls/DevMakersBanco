package br.com.ada.contas;

import br.com.ada.clientes.Cliente;
import br.com.ada.clientes.TipoCliente;

public class ContaPoupanca extends Conta implements IInvestimento {
    public ContaPoupanca(Cliente cliente) {
        super(cliente);
        super.setTipoConta(TipoConta.POUPANCA);
        super.setRendimentoDeposito(0.01);

    }

    @Override
    public void investir(double valor, Conta contaDestino) {
        transferir(valor, contaDestino);
    }
//    @Override
//    public void depositar(double valor) {
//        this.setSaldo(this.getSaldo() + valor + valor * this.getRendimentoDeposito());
//    }
//
//    @Override
//    public void sacar(double valor) {
//        double taxa = 0;
//
//        if (this.getCliente().getTipoCliente() == TipoCliente.JURIDICO) {
//            taxa = 0.005;
//        }
//
//        double saqueComTaxa = valor + (valor * taxa);
//        //todo - separar em um outro método essa validação de saldo suficiente
//        if (saqueComTaxa > getSaldo()) {
//            System.out.println("saldo indisponível");
//            return;
//            //todo - fazer exceção
//        }
//
//        this.setSaldo(this.getSaldo() - saqueComTaxa);
//    }
//
//
//
//    @Override
//    public void transferir(double valor, Conta contaDestino) {
//
//    }
//
//
//
}
