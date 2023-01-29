package br.com.ada.views.contas;

import br.com.ada.contas.Conta;
import br.com.ada.contas.ContaInvestimento;
import br.com.ada.contas.ContaPoupanca;
import br.com.ada.contas.TipoConta;
import br.com.ada.repositorio.conta.RepositorioContaInvestimento;
import br.com.ada.repositorio.conta.RepositorioContaPoupanca;
import br.com.ada.views.View;

public class ContaPoupancaView extends ContaView {
    private static final ContaPoupancaView INSTANCE = new ContaPoupancaView();

    public static ContaPoupancaView getInstance() {
        return INSTANCE;
    }

    public void menuInicial(ContaPoupanca conta) {
        boolean sair = false;
        do {
            System.out.println("Você está na sua conta poupança, o que deseja fazer?");
            System.out.println("Digite 1 para consultar o saldo.");
            System.out.println("Digite 2 para realizar um saque.");
            System.out.println("Digite 3 para realizar um depósito.");
            System.out.println("Digite 4 para realizar um investimento.");
            System.out.println("Digite 5 para realizar uma transferência.");
            System.out.println("Digite 6 ppara retornar ao menu anterior");

            int tipoConta = getInt();

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
                    menuInvestimento(conta);
                    break;
                case 5:
                    menuTransferencia(conta);
                    break;
                default:
                    System.out.println("Opção inválida, por favor digite novamente");
                    menuInicial(conta);
            }
        } while (!sair);

    }

    public void menuInvestimento(ContaPoupanca conta) {
        if (conta.getCliente().getContas().stream().noneMatch(contaCliente -> contaCliente.getTipoConta() == TipoConta.INVESTIMENTO)) {
            System.out.println("No momento essa é sua melhor conta disponível em termos de rentabilidade.");
            menuInicial(conta);
        }

        System.out.println("Digite 1 para investir na Conta Investimento");

        int tipoConta = getInt();

        System.out.println("Quanto deseja investir?");
        double valorInvestimento = getDouble();

        switch (tipoConta){
            case 1:
                ContaInvestimento ci = RepositorioContaInvestimento.getInstance().retornarContaInvestimento(conta.getCliente());
                conta.investir(valorInvestimento, ci);
                break;
            default:
                System.out.println("Opção inválida, por favor digite novamente");
                menuInvestimento(conta);
        }
    }

}
