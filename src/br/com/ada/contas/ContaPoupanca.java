package br.com.ada.contas;

import br.com.ada.clientes.Cliente;
import br.com.ada.clientes.TipoCliente;

public class ContaPoupanca extends Conta implements IInvestimento {
    public ContaPoupanca(Cliente cliente) {
        super(cliente);
        super.setTipoConta(TipoConta.POUPANCA);
        super.setRendimentoDeposito(0.01);

    }

    @Override
    public void investir(double valor, Conta contaDestino) {
         transferir(valor, contaDestino.getNumeroConta());
    }

}
