package br.com.ada.contas;

import br.com.ada.clientes.Cliente;
import br.com.ada.clientes.TipoCliente;

public class ContaInvestimento extends Conta {
    public ContaInvestimento(Cliente cliente) {
        super(cliente);
        super.setTipoConta(TipoConta.INVESTIMENTO);
        super.setRendimentoDeposito(cliente.getTipoCliente() == TipoCliente.FISICO ? 0.015 : 0.035);
    }


}
