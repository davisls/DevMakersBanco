package br.com.ada.banco;

import br.com.ada.clientes.Cliente;
import br.com.ada.clientes.ClienteFisico;
import br.com.ada.clientes.ClienteJuridico;
import br.com.ada.contas.ContaCorrente;
import br.com.ada.contas.ContaInvestimento;
import br.com.ada.contas.ContaPoupanca;
import br.com.ada.views.banco.BancoView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banco {
    private List<Cliente> clienteList = new ArrayList<>();

    private static final Banco INSTANCE = new Banco(new ArrayList<>());

    private Banco(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    public static Banco getInstance() {
        return INSTANCE;
    }

    public void menu() {
        BancoView.getInstance().menuInicial();
    }

    public void adicionarClienteNaLista(Cliente cliente){
        clienteList.add(cliente);
    }

    public void removerClienteNaLista(Cliente cliente){
        clienteList.remove(cliente);
    }

    public void criaContaCorrente(Cliente cliente) {
        ContaCorrente contaCorrente = new ContaCorrente(cliente);
        cliente.adicionarConta(contaCorrente);
    }

    public void criaContaInvestimento(Cliente cliente) {
        ContaInvestimento contaInvestimento = new ContaInvestimento(cliente);
        cliente.adicionarConta(contaInvestimento);
    }

    public void criaContaPoupanca(Cliente cliente) {
        ContaPoupanca contaPoupanca = new ContaPoupanca(cliente);
        cliente.adicionarConta(contaPoupanca);
    }

    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }
}
