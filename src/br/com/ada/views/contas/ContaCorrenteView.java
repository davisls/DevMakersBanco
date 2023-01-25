package br.com.ada.views.contas;

import br.com.ada.contas.*;
import br.com.ada.repositorio.conta.RepositorioContaCorrente;
import br.com.ada.repositorio.conta.RepositorioContaInvestimento;
import br.com.ada.repositorio.conta.RepositorioContaPoupanca;
import br.com.ada.views.View;
import br.com.ada.views.clientes.ClienteFisicoView;

public class ContaCorrenteView extends View {
    private static final ContaCorrenteView INSTANCE = new ContaCorrenteView();

    public static ContaCorrenteView getInstance() {
        return INSTANCE;
    }

    public void menuInicial(ContaCorrente conta) {
        System.out.println("Você está na sua conta corrente, o que deseja fazer?");
        System.out.println("Digite 1 para consultar o saldo.");
        System.out.println("Digite 2 para realizar um saque.");
        System.out.println("Digite 3 para realizar um depósito.");
        System.out.println("Digite 4 para realizar um investimento.");
        System.out.println("Digite 5 para realizar uma transfrência.");

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
                menuInvestimento(conta);
                break;
            case 5:
                menuTransferencia(conta);
                break;
            default:
                System.out.println("Opção inválida, por favor digite novamente");
                menuInicial(conta);
        }
    }

    public void menuSaque(ContaCorrente conta) {
        menuSaldo(conta);
        System.out.println("Quanto deseja sacar?");
        double valorSaque = Double.parseDouble(sc.nextLine());
        conta.sacar(valorSaque);
    }

    public void menuSaldo(ContaCorrente conta) {
        System.out.println("Seu saldo é " + conta.getSaldo() + ".");
    }

    public void menuDeposito(ContaCorrente conta) {
        System.out.println("Quanto deseja depositar?");
        double valorDeposito = Double.parseDouble(sc.nextLine());
        conta.depositar(valorDeposito);
    }

    public void menuInvestimento(ContaCorrente conta) {
        boolean temContaParaInvestir = false;

        if (conta.getCliente().getContas().stream().anyMatch(contaCliente -> contaCliente.getTipoConta() == TipoConta.INVESTIMENTO)) {
            System.out.println("Digite 1 para investir na Conta Investimento");
            temContaParaInvestir = true;
        }

        if (conta.getCliente().getContas().stream().anyMatch(contaCliente -> contaCliente.getTipoConta() == TipoConta.POUPANCA)) {
            System.out.println("Digite 2 para investir na Conta Poupança");
            temContaParaInvestir = true;
        }

        if (!temContaParaInvestir) {
            System.out.println("No momento essa é sua melhor conta disponível em termos de rentabilidade.");
            menuInicial(conta);
        }

        int tipoConta = Integer.parseInt(sc.nextLine());

        System.out.println("Quanto deseja investir?");
        double valorInvestimento = Double.parseDouble(sc.nextLine());

        switch (tipoConta){
            case 1:
                ContaPoupanca cp = RepositorioContaPoupanca.getInstance().retornarContaPoupanca(conta.getCliente());
                cp.investir(valorInvestimento);
                break;
            case 2:
                ContaInvestimento ci = RepositorioContaInvestimento.getInstance().retornarContaInvestimento(conta.getCliente());
                ci.investir(valorInvestimento);
                break;
            default:
                System.out.println("Opção inválida, por favor digite novamente");
                menuInvestimento(conta);
        }
    }

    public void menuTransferencia(ContaCorrente conta) {

    }
}
