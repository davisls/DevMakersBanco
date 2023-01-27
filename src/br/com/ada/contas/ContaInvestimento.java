package br.com.ada.contas;

import br.com.ada.clientes.Cliente;
import br.com.ada.clientes.TipoCliente;

public class ContaInvestimento extends Conta {
    public ContaInvestimento(Cliente cliente) {
        super(cliente);
        super.setTipoConta(TipoConta.INVESTIMENTO);
        super.setRendimentoDeposito(cliente.getTipoCliente() == TipoCliente.FISICO ? 0.015 : 0.035);
    }
//    @Override
//    public void depositar(double valor) {
//        this.setSaldo(this.getSaldo() + valor + valor * this.getRendimentoDeposito());
//    }
//
//    @Override
//    public void sacar(double valor) {
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
//    @Override
//    public void transferir(double valor, Conta contaDestino) {
//    //sacar e depositar
//    }


}
