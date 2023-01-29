package br.com.ada.clientes;

import br.com.ada.contas.IAdicionarConta;
import br.com.ada.views.clientes.ClienteJuridicoView;

public class ClienteJuridico extends Cliente implements IAdicionarConta,IClienteJuridico {
    private String cnpj;

    public ClienteJuridico(String nome, String senha, String cnpj) {
        super(nome, senha);
        this.cnpj = cnpj;
        super.setTipoCliente(TipoCliente.JURIDICO);
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public void adicionaConta() {
        ClienteJuridicoView.getInstance().menuAdicionarConta(this);
    }
}
