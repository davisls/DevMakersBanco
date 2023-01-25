package br.com.ada.views.clientes;

import br.com.ada.banco.Banco;
import br.com.ada.clientes.Cliente;
import br.com.ada.contas.TipoConta;
import br.com.ada.views.View;

public class ClienteJuridicoView extends View implements IClienteView {
    private static final ClienteJuridicoView INSTANCE = new ClienteJuridicoView();

    public static ClienteJuridicoView getInstance() {
        return INSTANCE;
    }

    public void menuInicial(Cliente cliente) {
        System.out.println("Bem vindo " + cliente.getNome() + "!");

        if (cliente.getContas().stream().anyMatch(conta -> conta.getTipoConta() == TipoConta.CORRENTE)) {
            System.out.println("Digite 1 para acessar sua Conta Corrente.");
        }

        if (cliente.getContas().stream().anyMatch(conta -> conta.getTipoConta() == TipoConta.INVESTIMENTO)) {
            System.out.println("Digite 2 para acessar sua Conta Investimento.");
        }

        System.out.println("Digite 3 para criar uma conta.");

        int tipoConta = Integer.parseInt(sc.nextLine());

        switch (tipoConta){
            case 1:
                System.out.println("chamar menu conta corrente");
                break;
            case 2:
                System.out.println("chamar menu conta investimento");
                break;
            case 3:
                menuAdicionarConta(cliente);
                break;
            default:
                System.out.println("Opção inválida, por favor digite novamente");
                menuInicial(cliente);
        }
    }

    public void menuAdicionarConta(Cliente cliente) {
        if (cliente.getContas().size() == 2) {
            System.out.println("Você já tem todas as nossas opções de conta abertas.");
            menuInicial(cliente);
        }

        System.out.println("Selecione o modelo de conta que deseja abrir:");
        System.out.println("Digite 1 para Conta Investimento.");

        int tipoConta = Integer.parseInt(sc.nextLine());

        if (tipoConta != 1) {
            System.out.println("Opção inválida, por favor digite novamente");
            menuAdicionarConta(cliente);
        }

        Banco.getInstance().criaContaInvestimento(cliente);
        menuInicial(cliente);
    }
}
