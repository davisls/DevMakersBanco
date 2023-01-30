package br.com.ada.views.contas;


import br.com.ada.contas.ContaInvestimento;


public class ContaInvestimentoView extends ContaView {
    private static final ContaInvestimentoView INSTANCE = new ContaInvestimentoView();

    public static ContaInvestimentoView getInstance() {
        return INSTANCE;
    }

    public void menuInicial(ContaInvestimento conta) {
        boolean sair = false;
        do {
            System.out.println("\nVocê está na sua conta INVESTIMENTO.");
            System.out.println("O número dessa conta é: " + conta.getNumeroConta());
            System.out.println("O que deseja fazer?");
            System.out.println("\nDigite 1 para consultar o saldo.");
            System.out.println("Digite 2 para realizar um saque.");
            System.out.println("Digite 3 para realizar um depósito.");
            System.out.println("Digite 4 para realizar uma transferência.");
            System.out.println("Digite 5 para retornar ao menu anterior");

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
                    menuTransferencia(conta);
                    break;
                case 5:
                    sair = true;
                    //todo - metodo retornar não esta funcionando.
                    break;
                default:
                    System.out.println("Opção inválida, por favor digite novamente");
                    menuInicial(conta);
            }
        } while (!sair);
    }
}
