package br.com.ada.views.contas;

import br.com.ada.contas.*;
import br.com.ada.excecoes.SaldoInsuficienteException;
import br.com.ada.excecoes.ValorNegativoException;
import br.com.ada.repositorio.conta.RepositorioContaInvestimento;
import br.com.ada.repositorio.conta.RepositorioContaPoupanca;

public class ContaCorrenteView extends ContaView {
    private static final ContaCorrenteView INSTANCE = new ContaCorrenteView();

    public static ContaCorrenteView getInstance() {
        return INSTANCE;
    }

    public void menuInicial(ContaCorrente conta) {
        boolean sair = false;
        do {
            System.out.println("\nVocê está na sua conta corrente.");
            System.out.println("O número dessa conta é: " + conta.getNumeroConta());
            System.out.println("O que deseja fazer?");
            System.out.println("\nDigite 1 para consultar o saldo.");
            System.out.println("Digite 2 para realizar um saque.");
            System.out.println("Digite 3 para realizar um depósito.");
            System.out.println("Digite 4 para realizar um investimento.");
            System.out.println("Digite 5 para realizar uma transfêrencia.");
            System.out.println("Digite 6 para retornar ao menu anterior");

            int tipoConta = pedirOpcao();

            switch (tipoConta) {
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
                case 6:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida, por favor digite novamente");
            }
        } while (!sair);
    }

    public void  menuInvestimento(ContaCorrente conta) {
        try {
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
                System.out.println("\nNo momento essa é sua melhor conta disponível em termos de rentabilidade.");
                System.out.println();
                menuInicial(conta);
            }

            int tipoConta = pedirOpcao();

            System.out.println("Quanto deseja investir?");
            double valorInvestimento = getDouble();

            switch (tipoConta){
                case 1:
                    ContaInvestimento ci = RepositorioContaInvestimento.getInstance().retornarContaInvestimento(conta.getCliente());
                    conta.investir(valorInvestimento, ci);
                    break;
                case 2:
                    ContaPoupanca cp = RepositorioContaPoupanca.getInstance().retornarContaPoupanca(conta.getCliente());
                    conta.investir(valorInvestimento, cp);
                    break;
                default:
                    System.out.println("Opção inválida, por favor digite novamente");
                    menuInvestimento(conta);
            }
        } catch (ValorNegativoException | SaldoInsuficienteException e){
            System.out.println(e.getMessage());
            menuInicial(conta);
        }
    }

}
