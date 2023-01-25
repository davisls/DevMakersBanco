package br.com.ada.contas;

import br.com.ada.clientes.Cliente;
import br.com.ada.clientes.ClienteJuridico;

import java.util.List;

public class ContaCorrente extends Conta implements IConta {

    public ContaCorrente(Cliente cliente) {
        super(cliente);
        super.setTipoConta(TipoConta.CORRENTE);
    }

    @Override
    public void depositar(double valor) {
        this.setSaldo(this.getSaldo() + valor);
    }

    @Override
    public void sacar(double valor) {
        double taxa = 0;
        if (this.getCliente() instanceof ClienteJuridico) {
            taxa = 0.005;
        }

        double saqueComTaxa = valor + (valor * taxa);
        //imagino q a taxa de saque é aplicada sobre o valor de saque (ou é ao saldo?)
        //todo - separar em um outro método essa validação de saldo suficiente
        if (saqueComTaxa > getSaldo()) {
            System.out.println("saldo indisponível");
            return;
            //todo - fazer exceção
        }

        this.setSaldo(this.getSaldo() - saqueComTaxa);
    }

    @Override
    public void investir(double valor) {
        //vai mudar com as interfaces
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }


}
