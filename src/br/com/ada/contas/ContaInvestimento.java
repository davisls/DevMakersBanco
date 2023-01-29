package br.com.ada.contas;

import br.com.ada.clientes.Cliente;
import br.com.ada.clientes.TipoCliente;
import br.com.ada.validacoes.Verificar;

public class ContaInvestimento extends Conta {
    public ContaInvestimento(Cliente cliente) {
        super(cliente);
        super.setTipoConta(TipoConta.INVESTIMENTO);
        super.setRendimentoDeposito(cliente.getTipoCliente() == TipoCliente.FISICO ? 1.015 : 1.035);
    }

}
