package br.com.ada.contas;

import br.com.ada.clientes.Cliente;
import br.com.ada.clientes.ClienteJuridico;

import java.util.List;

public class ContaCorrente extends Conta implements IConta {

    public ContaCorrente(Cliente cliente) {
        super(cliente);
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
        if (saqueComTaxa > getSaldo()) {
            System.out.println("saldo indisponível");
            return;
            //acho que seria melhor criar e jogar uma exceção aqui...
        }

        this.setSaldo(this.getSaldo() - saqueComTaxa);
    }

    @Override
    public void investir(double valor) {
        ContaInvestimento contaDestino = null;

        for (Conta conta : getCliente().getContas()) {
            if (conta instanceof ContaInvestimento) {
                contaDestino = (ContaInvestimento) conta;
                transferir(valor, contaDestino);
                break;
            }
        }

        if (contaDestino == null) {
            System.out.println("Você não possui uma Conta Investimento");
        }

    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }


}
