package br.com.ada.clientes;

import br.com.ada.banco.Banco;

import java.util.Scanner;

public class ClienteJuridico extends Cliente implements ICliente {
    private String cnpj;

    public ClienteJuridico(String nome, String senha, String cnpj) {
        super(nome, senha);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public void adicionaConta() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Por favor selecione o modelo de conta que deseja abrir:");
        System.out.println("Digite I para Conta Investimento");
        String opcaoAbrirConta = sc.nextLine();

        if (opcaoAbrirConta.equalsIgnoreCase("I")) {
            Banco.getInstance().criaContaInvestimento(this);
        } else {
            System.out.println("Opção inválida, por favor digite novamente");
            adicionaConta();
        }
    }
}
