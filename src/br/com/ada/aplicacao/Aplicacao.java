package br.com.ada.aplicacao;

import br.com.ada.banco.Banco;
import br.com.ada.clientes.ClienteJuridico;
import br.com.ada.contas.ContaCorrente;

public class Aplicacao {
    public static void main(String[] args) {
        ClienteJuridico cliente = new ClienteJuridico("may","123", "123");
        ContaCorrente cc = new ContaCorrente(cliente);
        cc.depositar(100);
        cc.sacar(100);
        System.out.println(cc.getSaldo());
    }
}
