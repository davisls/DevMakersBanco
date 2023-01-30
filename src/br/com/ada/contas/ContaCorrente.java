package br.com.ada.contas;

import br.com.ada.clientes.Cliente;
import br.com.ada.clientes.ClienteJuridico;
import br.com.ada.clientes.TipoCliente;

import java.util.List;

import static br.com.ada.utilidades.InformacoesDeTaxas.TAXA_RENDIMENTO_DEPOSITO_CORRENTE;

public class ContaCorrente extends Conta implements IInvestimento {

    public ContaCorrente(Cliente cliente) {
        super(cliente);
        super.setTipoConta(TipoConta.CORRENTE);
        super.setRendimentoDeposito(TAXA_RENDIMENTO_DEPOSITO_CORRENTE);
    }

    @Override
    public void investir(double valor, Conta contaDestino) {
         transferir(valor, contaDestino.getNumeroConta());
    }
}
