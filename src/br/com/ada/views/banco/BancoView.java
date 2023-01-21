package br.com.ada.views.banco;

import br.com.ada.banco.Banco;
import br.com.ada.clientes.ClienteFisico;
import br.com.ada.clientes.ClienteJuridico;
import br.com.ada.views.View;

public class BancoView extends View {
    private static final BancoView INSTANCE = new BancoView();

    public static BancoView getInstance() {
        return INSTANCE;
    }

    public void menuInicial() {
        System.out.println("Bem vindo ao Banco");
        System.out.println("Digite C para abrir conta.");
        System.out.println("Digite L para acessar sua conta.");
        System.out.println("Digite F para encerrar a sessão.");
        String opcaoMenu = sc.nextLine().toUpperCase();

        if (opcaoMenu.equals("C")) {
            menuCadastro();
        } else if (opcaoMenu.equals("L")) {

        } else if (opcaoMenu.equals("F")) {

        } else {
            System.out.println("Opção inválida, por favor digite novamente");
            menuInicial();
        }
    }

    public void menuCadastro() {
        System.out.println("Selecione se você é pessoa jurídica ou física:");
        System.out.println("Digite J para pessoa jurídica.");
        System.out.println("Digite F para pessoa física.");
        String tipoPessoa = sc.nextLine().toUpperCase();

        if (!tipoPessoa.equals("J") && !tipoPessoa.equals("F")) {
            System.out.println("Opção inválida, por favor digite novamente");
            menuCadastro();
        }

        System.out.println("Digite o seu nome:");
        String nome = sc.nextLine();

        System.out.println("Digite sua senha:");
        String senha = sc.nextLine();

        if (tipoPessoa.equals("J")) {
            System.out.println("Digite o seu cnpj:");
            String cnpj =  sc.nextLine();
            ClienteJuridico cliente = new ClienteJuridico(nome, senha, cnpj);
            Banco.getInstance().adicionarClienteNaLista(cliente);
        } else if (tipoPessoa.equals("F")) {
            System.out.println("Digite o seu cpf:");
            String cpf =  sc.nextLine();
            ClienteFisico cliente = new ClienteFisico(nome, senha, cpf);
            Banco.getInstance().adicionarClienteNaLista(cliente);
        }
    }
}
