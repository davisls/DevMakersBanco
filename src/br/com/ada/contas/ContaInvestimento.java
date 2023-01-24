package br.com.ada.contas;

import br.com.ada.clientes.Cliente;

public class ContaInvestimento extends Conta implements IConta {
    public ContaInvestimento(Cliente cliente) {
        super(cliente);
    }
    @Override
    public void depositar(double valor) {

    }

    @Override
    public void sacar(double valor) {

    }

    @Override
    public void investir(double valor) {
        //não vai existir aqui com a aplicação das interfaces para investimento
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {

    }


}
