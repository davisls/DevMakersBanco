package br.com.ada.clientes;

import br.com.ada.contas.IAdicionarConta;
import br.com.ada.views.clientes.ClienteFisicoView;

public class ClienteFisico extends Cliente implements IAdicionarConta {
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
