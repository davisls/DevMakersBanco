package br.com.ada.views;

import br.com.ada.validacoes.ValidacaoString;
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
    public int getInt () {
        int valor = 0;

        try {
            valor = Integer.parseInt(getString());
        } catch (Exception e) {
            System.out.println("Valor inválido, tente novamente.");
            getInt();
        }

        return valor;
    }

    public String getString () {
        String string = sc.nextLine();
        if(validarInput.validarString.validarVazio(string)){
            return getString();
        };
        return string;
    }

    public String pedirCpf() {
        System.out.println("Digite o seu cpf:");
        String cpf =  getString();
        return cpf;
        //todo - validar cpf
    }

    public String pedirCnpj() {
        System.out.println("Digite o seu cnpj:");
        String cnpj =  getString();
        return cnpj;
        //todo - validar cnpj
    }
}
