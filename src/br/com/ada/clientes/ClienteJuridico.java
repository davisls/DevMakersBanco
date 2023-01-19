package br.com.ada.clientes;

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

    }
}
