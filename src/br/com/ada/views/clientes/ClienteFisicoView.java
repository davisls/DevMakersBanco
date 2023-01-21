package br.com.ada.views.clientes;

import br.com.ada.banco.Banco;
import br.com.ada.clientes.Cliente;
import br.com.ada.views.View;

public class ClienteFisicoView extends View {
    private static final ClienteFisicoView INSTANCE = new ClienteFisicoView();

    public static ClienteFisicoView getInstance() {
        return INSTANCE;
    }

    public void menuAdicionarConta(Cliente cliente) {
        System.out.println("Por favor selecione o modelo de conta que deseja abrir:");
        System.out.println("Digite P para Conta Poupança");
        System.out.println("Digite I para Conta Investimento");
        String opcaoAbrirConta = sc.nextLine();

        if (opcaoAbrirConta.equalsIgnoreCase("P")) {
            Banco.getInstance().criaContaPoupanca(cliente);
        } else if (opcaoAbrirConta.equalsIgnoreCase("I")) {
            Banco.getInstance().criaContaInvestimento(cliente);
        } else {
            System.out.println("Opção inválida, por favor digite novamente");
            menuAdicionarConta(cliente);
        }
    }
}
