package br.com.ada.contas;

import br.com.ada.clientes.Cliente;
import br.com.ada.clientes.TipoCliente;

import static br.com.ada.utilidades.InformacoesDeTaxas.TAXA_RENDIMENTO_DEPOSITO_POUPANCA;

public class ContaPoupanca extends Conta implements IInvestimento {
    public ContaPoupanca(Cliente cliente) {
        super(cliente);
        super.setTipoConta(TipoConta.POUPANCA);
        super.setRendimentoDeposito(TAXA_RENDIMENTO_DEPOSITO_POUPANCA);

    }

    @Override
    public void investir(double valor, Conta contaDestino) {
         transferir(valor, contaDestino.getNumeroConta());
    }

}
