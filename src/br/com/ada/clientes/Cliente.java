package br.com.ada.clientes;

import br.com.ada.contas.Conta;

import java.util.List;

public abstract class Cliente {
    private String nome;
    private String senha;
    private List<Conta> contas;

    public Cliente(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
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
}
