package br.com.ada.views.clientes;

import br.com.ada.banco.Banco;
import br.com.ada.clientes.Cliente;
import br.com.ada.contas.ContaCorrente;
import br.com.ada.contas.ContaInvestimento;
import br.com.ada.contas.ContaPoupanca;
import br.com.ada.contas.TipoConta;
import br.com.ada.repositorio.conta.RepositorioContaCorrente;
import br.com.ada.repositorio.conta.RepositorioContaInvestimento;
import br.com.ada.repositorio.conta.RepositorioContaPoupanca;
import br.com.ada.views.View;
import br.com.ada.views.contas.ContaCorrenteView;
import br.com.ada.views.contas.ContaInvestimentoView;
import br.com.ada.views.contas.ContaPoupancaView;

public class ClienteFisicoView extends View implements IClienteView {
    private static final ClienteFisicoView INSTANCE = new ClienteFisicoView();

    public static ClienteFisicoView getInstance() {
        return INSTANCE;
    }

    @Override
    public void menuInicial(Cliente cliente) {
            System.out.println("\n ~~~~~< Bem vindo " + cliente.getNome() + "! >~~~~~");

            if (cliente.getContas().stream().anyMatch(conta -> conta.getTipoConta() == TipoConta.CORRENTE)) {
                System.out.println("Digite 1 para acessar sua Conta Corrente.");
            }

            if (cliente.getContas().stream().anyMatch(conta -> conta.getTipoConta() == TipoConta.POUPANCA)) {
                System.out.println("Digite 2 para acessar sua Conta Poupança.");
            }

            if (cliente.getContas().stream().anyMatch(conta -> conta.getTipoConta() == TipoConta.INVESTIMENTO)) {
                System.out.println("Digite 3 para acessar sua Conta Investimento.");
            }

            System.out.println("Digite 4 para criar uma conta.");
            System.out.println("Digite 5 para retornar");

            int tipoConta = pedirOpcao();

            switch (tipoConta){
                case 1:
                    ContaCorrente cc = RepositorioContaCorrente.getInstance().retornarContaCorrente(cliente);
                    ContaCorrenteView.getInstance().menuInicial(cc);
                    break;
                case 2:
                    ContaPoupanca cp = RepositorioContaPoupanca.getInstance().retornarContaPoupanca(cliente);
                    ContaPoupancaView.getInstance().menuInicial(cp);
                    break;
                case 3:
                    ContaInvestimento ci = RepositorioContaInvestimento.getInstance().retornarContaInvestimento(cliente);
                    ContaInvestimentoView.getInstance().menuInicial(ci);
                    break;
                case 4:
                    menuAdicionarConta(cliente);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opção inválida, por favor digite novamente");
                    menuInicial(cliente);
            }
    }


    @Override
    public void menuAdicionarConta(Cliente cliente) {
        if (cliente.getContas().size() == 3) {
            System.out.println("😱 Você já tem todas as nossas opções de conta abertas. ");
            menuInicial(cliente);
        }

        System.out.println("Selecione o modelo de conta que deseja abrir:");

        if (cliente.getContas().stream().noneMatch(conta -> conta.getTipoConta() == TipoConta.INVESTIMENTO)) {
            System.out.println("Digite 1 para Conta Investimento.");
        }

        if (cliente.getContas().stream().noneMatch(conta -> conta.getTipoConta() == TipoConta.POUPANCA)) {
            System.out.println("Digite 2 para Conta Poupança.");
        }

        int tipoConta = pedirOpcao();

        switch (tipoConta){
            case 1:
                Banco.getInstance().criaContaInvestimento(cliente);
                System.out.println("💲 Conta investimento criada com sucesso!");
                break;
            case 2:
                Banco.getInstance().criaContaPoupanca(cliente);
                System.out.println("💲 Conta poupança criada com sucesso!");
                break;
            default:
                System.out.println("Opção inválida, por favor digite novamente");
                menuAdicionarConta(cliente);
        }
        menuInicial(cliente);
    }
}
