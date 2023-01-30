package br.com.ada.views.contas;

import br.com.ada.contas.ContaInvestimento;
import br.com.ada.contas.ContaPoupanca;
import br.com.ada.contas.TipoConta;
import br.com.ada.excecoes.SaldoInsuficienteException;
import br.com.ada.excecoes.ValorNegativoException;
import br.com.ada.repositorio.conta.RepositorioContaInvestimento;

public class ContaPoupancaView extends ContaView {
    private static final ContaPoupancaView INSTANCE = new ContaPoupancaView();

    public static ContaPoupancaView getInstance() {
        return INSTANCE;
    }

    public void menuInicial(ContaPoupanca conta) {
        boolean sair = false;
        do {
            System.out.println("\nVocê está na sua conta poupança.");
            System.out.println("O número dessa conta é: " + conta.getNumeroConta());
            System.out.println("O que deseja fazer?");
            System.out.println("\nDigite 1 para consultar o saldo.");
            System.out.println("Digite 2 para realizar um saque.");
            System.out.println("Digite 3 para realizar um depósito.");
            System.out.println("Digite 4 para realizar um investimento.");
            System.out.println("Digite 5 para realizar uma transferência.");
            System.out.println("Digite 6 ppara retornar ao menu anterior");

            int tipoConta = pedirOpcao();

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
        try {
            if (conta.getCliente().getContas().stream().noneMatch(contaCliente -> contaCliente.getTipoConta() == TipoConta.INVESTIMENTO)) {
                System.out.println("\nNo momento essa é sua melhor conta disponível em termos de rentabilidade.");
                menuInicial(conta);
            }

            System.out.println("Digite 1 para investir na Conta Investimento");

            int tipoConta = pedirOpcao();

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
        } catch (ValorNegativoException | SaldoInsuficienteException e){
            System.out.println(e.getMessage());
        }

    }

}
