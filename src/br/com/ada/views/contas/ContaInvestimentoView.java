package br.com.ada.views.contas;

import br.com.ada.contas.Conta;
import br.com.ada.contas.ContaInvestimento;
import br.com.ada.views.View;

public class ContaInvestimentoView extends View {
    private static final ContaInvestimentoView INSTANCE = new ContaInvestimentoView();

    public static ContaInvestimentoView getInstance() {
        return INSTANCE;
    }

    public void menuInicial(ContaInvestimento conta) {
        System.out.println("Você está na sua conta investimento, o que deseja fazer?");
        System.out.println("Digite 1 para consultar o saldo.");
        System.out.println("Digite 2 para realizar um saque.");
        System.out.println("Digite 3 para realizar um depósito.");
        System.out.println("Digite 4 para realizar uma transferência.");

        int tipoConta = Integer.parseInt(sc.nextLine());

        switch (tipoConta){
            case 1:
                menuSaldo(conta);
                break;
            case 2:
                menuSaque(conta);
                break;
            case 3:
                menuDeposito(conta);
                break;
            case 4:
                menuTransferencia(conta);
                break;
            default:
                System.out.println("Opção inválida, por favor digite novamente");
                menuInicial(conta);
        }
    }

    public void menuSaque(ContaInvestimento conta) {
        menuSaldo(conta);
        System.out.println("Quanto deseja sacar?");
        double valorSaque = Double.parseDouble(sc.nextLine());
        conta.sacar(valorSaque);
    }

    public void menuSaldo(ContaInvestimento conta) {
        System.out.println("Seu saldo é " + conta.getSaldo() + ".");
    }

    public void menuDeposito(ContaInvestimento conta) {
        System.out.println("Quanto deseja depositar?");
        double valorDeposito = Double.parseDouble(sc.nextLine());
        conta.depositar(valorDeposito);
    }

    public void menuTransferencia(ContaInvestimento conta) {
        System.out.println("Quanto deseja depositar?");
        double valorDeposito = Double.parseDouble(sc.nextLine());
        conta.depositar(valorDeposito);
    }
}
