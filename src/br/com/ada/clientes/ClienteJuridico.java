package br.com.ada.clientes;

import br.com.ada.banco.Banco;
import br.com.ada.views.clientes.ClienteFisicoView;
import br.com.ada.views.clientes.ClienteJuridicoView;

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
        ClienteJuridicoView.getInstance().menuAdicionarConta(this);
    }
}
