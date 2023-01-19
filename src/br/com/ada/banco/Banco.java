package br.com.ada.banco;

import br.com.ada.clientes.Cliente;
import br.com.ada.clientes.ClienteFisico;
import br.com.ada.clientes.ClienteJuridico;
import br.com.ada.contas.ContaCorrente;
import br.com.ada.contas.ContaInvestimento;
import br.com.ada.contas.ContaPoupanca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banco {
    private List<Cliente> clienteList = new ArrayList<>();

    private static final Banco INSTANCE = new Banco(new ArrayList<>());

    private Banco(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    public static Banco getInstance() {
        return INSTANCE;
    }

    public void menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bem vindo ao Banco");
        System.out.println("Digite C para abrir conta.");
        System.out.println("Digite L para acessar sua conta.");
        System.out.println("Digite F para encerrar a sessão.");
        String opcaoMenu = sc.nextLine();

        if (opcaoMenu.equalsIgnoreCase("C")) {
            menuCadastro();
        } else if (opcaoMenu.equalsIgnoreCase("L")) {

        } else if (opcaoMenu.equalsIgnoreCase("F")) {

        } else {
            System.out.println("Opção inválida, por favor digite novamente");
            menu();
        }
    }

    public void menuCadastro() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Selecione se você é pessoa jurídica ou física:");
        System.out.println("Digite J para pessoa jurídica.");
        System.out.println("Digite F para pessoa física.");
        String tipoPessoa = sc.nextLine();

        if (!tipoPessoa.equalsIgnoreCase("J") && !tipoPessoa.equalsIgnoreCase("F")) {
            System.out.println("Opção inválida, por favor digite novamente");
            menuCadastro();
        }

        System.out.println("Digite o seu nome:");
        String nome = sc.nextLine();

        System.out.println("Digite sua senha:");
        String senha = sc.nextLine();

        if (tipoPessoa.equalsIgnoreCase("J")) {
            System.out.println("Digite o seu cnpj:");
            String cnpj =  sc.nextLine();
            ClienteJuridico cliente = new ClienteJuridico(nome, senha, cnpj);
            adicionarClienteNaLista(cliente);
        } else if (tipoPessoa.equalsIgnoreCase("F")) {
            System.out.println("Digite o seu cpf:");
            String cpf =  sc.nextLine();
            ClienteFisico cliente = new ClienteFisico(nome, senha, cpf);
            adicionarClienteNaLista(cliente);
        }
    }

    public void adicionarClienteNaLista(Cliente cliente){
        clienteList.add(cliente);
    }

    public void removerClienteNaLista(Cliente cliente){
        clienteList.remove(cliente);
    }

    public void criaContaCorrente(Cliente cliente) {
        ContaCorrente contaCorrente = new ContaCorrente(cliente);
        cliente.adicionarConta(contaCorrente);
    }

    public void criaContaInvestimento(Cliente cliente) {
        ContaInvestimento contaInvestimento = new ContaInvestimento(cliente);
        cliente.adicionarConta(contaInvestimento);
    }

    public void criaContaPoupanca(Cliente cliente) {
        ContaPoupanca contaPoupanca = new ContaPoupanca(cliente);
        cliente.adicionarConta(contaPoupanca);
    }
}
