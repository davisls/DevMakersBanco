package br.com.ada.clientes;

import br.com.ada.banco.Banco;

import java.util.Scanner;

public class ClienteFisico extends Cliente implements ICliente {
    private String cpf;

    public ClienteFisico(String nome, String senha, String cpf) {
        super(nome, senha);
        this.cpf = cpf;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void adicionaConta() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Por favor selecione o modelo de conta que deseja abrir:");
        System.out.println("Digite P para Conta Poupança");
        System.out.println("Digite I para Conta Investimento");
        String opcaoAbrirConta = sc.nextLine();

        if (opcaoAbrirConta.equalsIgnoreCase("P")) {
            Banco.getInstance().criaContaPoupanca(this);
        } else if (opcaoAbrirConta.equalsIgnoreCase("I")) {
            Banco.getInstance().criaContaInvestimento(this);
        } else {
            System.out.println("Opção inválida, por favor digite novamente");
            adicionaConta();
        }
    }
}
