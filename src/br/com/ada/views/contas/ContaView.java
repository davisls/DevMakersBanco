package br.com.ada.views.contas;

import br.com.ada.contas.Conta;
import br.com.ada.views.View;

public class ContaView extends View {
    public void menuSaque(Conta conta) {
        menuSaldo(conta);
        System.out.println("Quanto deseja sacar?");
        double valorSaque = getDouble();
        conta.sacar(valorSaque);
    }

    public void menuSaldo(Conta conta) {
        System.out.println("Seu saldo é " + conta.getSaldo() + ".");
    }

    public void menuDeposito(Conta conta) {
        System.out.println("Quanto deseja depositar?");
        double valorDeposito = getDouble();
        conta.depositar(valorDeposito);
    }

    public void menuTransferencia(Conta conta) {
        System.out.println("Digite o valor que vai ser transferido:");
        double valorParaTransferencia = getDouble();
        System.out.println("Digite o número da conta para qual você quer transferir o dinheiro:");
        String numeroContaDestino = getString();

        conta.transferir(valorParaTransferencia,numeroContaDestino);
    }
}
