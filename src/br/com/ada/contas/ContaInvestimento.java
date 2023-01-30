package br.com.ada.contas;

import br.com.ada.clientes.Cliente;
import br.com.ada.clientes.TipoCliente;

import static br.com.ada.utilidades.InformacoesDeTaxas.TAXA_RENDIMENTO_DEPOSITO_INVESTIMENTO_FISICO;
import static br.com.ada.utilidades.InformacoesDeTaxas.TAXA_RENDIMENTO_DEPOSITO_INVESTIMENTO_JURIDICO;

public class ContaInvestimento extends Conta {
    public ContaInvestimento(Cliente cliente) {
        super(cliente);
        super.setTipoConta(TipoConta.INVESTIMENTO);
        super.setRendimentoDeposito(cliente.getTipoCliente() == TipoCliente.FISICO ? TAXA_RENDIMENTO_DEPOSITO_INVESTIMENTO_FISICO : TAXA_RENDIMENTO_DEPOSITO_INVESTIMENTO_JURIDICO);
    }

}
