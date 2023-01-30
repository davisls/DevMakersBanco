package br.com.ada.clientes;

import br.com.ada.banco.Banco;
import br.com.ada.contas.Conta;

import java.util.ArrayList;
import java.util.List;

public abstract class Cliente implements ICliente{

    private String id;
    private String nome;
    private String senha;
    private List<Conta> contas = new ArrayList<>();

    private TipoCliente tipoCliente;

    public Cliente(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
        this.id = String.valueOf(++Banco.getInstance().contador);
    }

    public String getNome() {
        return this.nome;
    }

    public boolean verificaSenha(String senhaInserida) {
        return this.senha.equals(senhaInserida);
    }

    public void adicionarConta(Conta conta) {
        this.contas.add(conta);
    }

    public List<Conta> getContas() {
        return contas;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getId() {
        return id;
    }
}
