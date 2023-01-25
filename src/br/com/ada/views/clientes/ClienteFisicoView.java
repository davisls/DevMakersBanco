package br.com.ada.views.clientes;

import br.com.ada.banco.Banco;
import br.com.ada.clientes.Cliente;
import br.com.ada.views.View;

public class ClienteFisicoView extends View implements IClienteView {
    private static final ClienteFisicoView INSTANCE = new ClienteFisicoView();

    public static ClienteFisicoView getInstance() {
        return INSTANCE;
    }

    public void menuAdicionarConta(Cliente cliente) {
        System.out.println("selecione o modelo de conta que deseja abrir:");
        System.out.println("Digite 1 para Conta Poupança.");
        System.out.println("Digite 2 para Conta Investimento.");
        int tipoConta = Integer.parseInt(sc.nextLine());
        switch (tipoConta){
            case 1:
                Banco.getInstance().criaContaPoupanca(cliente);
                break;
            case 2:
                Banco.getInstance().criaContaInvestimento(cliente);
                break;
            default:
                System.out.println("Opção inválida, por favor digite novamente");
                menuAdicionarConta(cliente);
        }
    }
}
