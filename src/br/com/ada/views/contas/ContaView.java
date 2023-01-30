package br.com.ada.views.contas;

import br.com.ada.contas.Conta;
import br.com.ada.excecoes.ContaNaoExisteException;
import br.com.ada.excecoes.SaldoInsuficienteException;
import br.com.ada.excecoes.ValorNegativoException;
import br.com.ada.views.View;

public class ContaView extends View {
    public void menuSaque(Conta conta) {
        menuSaldo(conta);
        try {
            System.out.println("Quanto deseja sacar?");
            double valorSaque= getDouble();
            conta.sacar(valorSaque);
            System.out.println("Saque realizado com sucesso!");
        }catch (SaldoInsuficienteException | ValorNegativoException e){
            System.out.println(e.getMessage());
            menuSaque(conta);
        }
    }

    public void menuSaldo(Conta conta) {
        System.out.println("Seu saldo é " + String.format("%.2f",conta.getSaldo())  + ".");
    }

    public void menuDeposito(Conta conta) {
        try{
            System.out.println("Quanto deseja depositar?");
            double valorDeposito = getDouble();
            conta.depositar(valorDeposito);
        } catch (ValorNegativoException e){
            System.out.println(e.getMessage());
            menuDeposito(conta);
        }
    }

    public void menuTransferencia(Conta conta) {
        try {
            System.out.println("Digite o valor que vai ser transferido:");
            double valorParaTransferencia = getDouble();
            System.out.println("Digite o número da conta para qual você quer transferir o dinheiro:");
            String numeroContaDestino = getString();
            conta.transferir(valorParaTransferencia,numeroContaDestino);
            System.out.println("Transferência realizada com sucesso!");
        } catch (SaldoInsuficienteException | ContaNaoExisteException | ValorNegativoException e ){
            System.out.println(e.getMessage());
            menuTransferencia(conta);
        }
    }
}
