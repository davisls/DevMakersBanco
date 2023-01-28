package br.com.ada.views.contas;

import br.com.ada.contas.*;
import br.com.ada.repositorio.cliente.RepositorioClienteFisico;
import br.com.ada.repositorio.cliente.RepositorioClienteJuridico;
import br.com.ada.repositorio.conta.RepositorioConta;
import br.com.ada.repositorio.conta.RepositorioContaCorrente;
import br.com.ada.repositorio.conta.RepositorioContaInvestimento;
import br.com.ada.repositorio.conta.RepositorioContaPoupanca;
import br.com.ada.views.View;
import br.com.ada.views.banco.BancoView;
import br.com.ada.views.clientes.ClienteFisicoView;

public class ContaCorrenteView extends View {
    private static final ContaCorrenteView INSTANCE = new ContaCorrenteView();

    public static ContaCorrenteView getInstance() {
        return INSTANCE;
    }


    //todo - esse menu tem que retornar para o menu das opções de conta (já logado),
    // isso vale para os outros menus iniciais dos outros tipos de conta
    public void menuInicial(ContaCorrente conta) {
        boolean sair = false;
        do {
            System.out.println("Você está na sua conta corrente, o que deseja fazer?");
            System.out.println("Digite 1 para consultar o saldo.");
            System.out.println("Digite 2 para realizar um saque.");
            System.out.println("Digite 3 para realizar um depósito.");
            System.out.println("Digite 4 para realizar um investimento.");
            System.out.println("Digite 5 para realizar uma transfêrencia.");
            System.out.println("Digite 6 para retornar ao menu anterior");

            int tipoConta = getInt();

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

    public void menuSaque(ContaCorrente conta) {
        menuSaldo(conta);
        System.out.println("Quanto deseja sacar?");
        double valorSaque = getDouble();
        conta.sacar(valorSaque);
        System.out.println();

    }

    public void menuSaldo(ContaCorrente conta) {
        System.out.println("Seu saldo é " + conta.getSaldo() + ".");
        System.out.println();
    }

    public void menuDeposito(ContaCorrente conta) {
        System.out.println("Quanto deseja depositar?");
        double valorDeposito = getDouble();
        conta.depositar(valorDeposito);
        System.out.println();
    }

    public void  menuInvestimento(ContaCorrente conta) {
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
            System.out.println();
            menuInicial(conta);
        }

        int tipoConta = getInt();

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
        System.out.println();
    }

    public void menuTransferencia(ContaCorrente conta) {
        //todo implementar metodo
        System.out.println("Digite o valor que vai ser transferido:");
        double valorParaTransferencia = getDouble();
        System.out.println("Digite o número da conta para qual você quer transferir o dinheiro:");
        String numeroContaDestino = getString();

        conta.transferir(valorParaTransferencia,numeroContaDestino);
    }
}
