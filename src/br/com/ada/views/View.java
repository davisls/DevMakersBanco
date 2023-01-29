package br.com.ada.views;

import br.com.ada.excecoes.SenhaForaDoPadraoException;
import br.com.ada.validacoes.ValidarInput;

import java.util.Scanner;

public abstract class View {
    public Scanner sc = new Scanner(System.in);
    public ValidarInput validarInput = new ValidarInput();

    public double getDouble () {
        double valor = 0;

        try {
            valor = Double.parseDouble(getString());
        } catch (Exception e) {
            System.out.println("Valor inválido, tente novamente.");
            getDouble();
        }

        return valor;
    }

    public int pedirOpcao() {
        int valor = 0;
        try {
            valor = Integer.parseInt(getString());
        } catch (NumberFormatException ex) {
            System.out.println("Valor inválido, tente novamente.");
            pedirOpcao();
        }
        return valor;
    }

    public String getString() {
        String string = sc.nextLine();
        if(validarInput.getValidarString().isVazio(string)){
            return getString();
        };
        return string;
    }

    public String pedirCpf() {
        boolean isValid = false;
        String cpf;
        do {
            System.out.println("Digite o seu cpf:");
            cpf =  getString();
            isValid = validarInput.getValidarCpf().validarFormatoInput(cpf);
        } while (!isValid);
        return cpf;
    }

    public String pedirCnpj() {
        System.out.println("Digite o seu cnpj:");
        String cnpj = getString();
        return cnpj;
        //todo - validar cnpj
    }

    public String pedirNome() {
        System.out.println("Digite o seu nome:");
        String nome = getString();
        return nome;
    }

    public String pedirSenha() {
        System.out.println("Digite sua senha:");
        String senha = getString();
        try {
            validarInput.getValidarSenha().validarTamanhoSenha(senha);
        } catch(SenhaForaDoPadraoException ex) {
            System.out.println(ex.getMessage());
            return pedirSenha();
        }
        return senha;
    }
}
