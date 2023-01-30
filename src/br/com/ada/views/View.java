package br.com.ada.views;

import br.com.ada.excecoes.DocumentoFormatoInvalidoException;
import br.com.ada.excecoes.SenhaForaDoPadraoException;
import br.com.ada.excecoes.ValorNegativoException;
import br.com.ada.validacoes.ValidarInput;

import java.util.Scanner;

public abstract class View {
    public Scanner sc = new Scanner(System.in);
    public ValidarInput validarInput = new ValidarInput();


    public double getDouble () {
        try {
            double valor = 0;
            valor = Double.parseDouble(getString());
            validarInput.getValidarValoresPositivos().validarValoresPositivos(valor);
            return valor;
        } catch (NumberFormatException e) {
            System.out.println("Valor inválido, tente novamente.");
            return getDouble();
        }
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

    public String pedirCpf() throws DocumentoFormatoInvalidoException {
        String cpf;
        System.out.println("Digite o seu cpf:");
        cpf =  getString();
        validarInput.getValidarCpf().validarFormatoInputCpf(cpf);
        return cpf;
    }

    public String pedirCnpj() throws DocumentoFormatoInvalidoException {
        String cnpj;
        System.out.println("Digite o seu cnpj:");
        cnpj = getString();
        validarInput.getValidarCnpj().validarFormatoInputCnpj(cnpj);
        return cnpj;
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
