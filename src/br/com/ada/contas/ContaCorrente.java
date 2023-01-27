package br.com.ada.contas;

import br.com.ada.clientes.Cliente;
import br.com.ada.clientes.ClienteJuridico;
import br.com.ada.clientes.TipoCliente;

import java.util.List;

public class ContaCorrente extends Conta implements IInvestimento {

    public ContaCorrente(Cliente cliente) {
        super(cliente);
        super.setTipoConta(TipoConta.CORRENTE);
        super.setRendimentoDeposito(0);
    }

//    @Override
//    public void depositar(double valor) {
//        this.setSaldo(this.getSaldo() + valor + valor * this.getRendimentoDeposito());
//    }
//
//    @Override
//    public void sacar(double valor) {
//        //double taxa = 0;
//
////        if (this.getCliente().getTipoCliente() == TipoCliente.JURIDICO) {
////            taxa = 0.005;
////        }
//
//        double saqueComTaxa = valor + (valor * this.getTaxaSaque());
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
//        this.sacar(valor);
//        contaDestino.depositar(valor);
//    }


    @Override
    public void investir(double valor, Conta contaDestino) {
        transferir(valor, contaDestino);
    }
}
