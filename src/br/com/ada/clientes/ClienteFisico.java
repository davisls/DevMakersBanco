package br.com.ada.clientes;

import br.com.ada.banco.Banco;
import br.com.ada.views.clientes.ClienteFisicoView;

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
        ClienteFisicoView.getInstance().menuAdicionarConta(this);
    }
}
