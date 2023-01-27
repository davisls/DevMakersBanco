package br.com.ada.aplicacao;


import br.com.ada.banco.Banco;
import br.com.ada.clientes.ClienteFisico;
import br.com.ada.clientes.ClienteJuridico;
import br.com.ada.contas.ContaCorrente;
import br.com.ada.contas.ContaInvestimento;
import br.com.ada.repositorio.cliente.RepositorioClienteFisico;
import br.com.ada.repositorio.cliente.RepositorioClienteJuridico;
import br.com.ada.repositorio.conta.RepositorioContaCorrente;
import br.com.ada.repositorio.conta.RepositorioContaInvestimento;

public class Aplicacao {
    public static void main(String[] args) {
        ClienteFisico cliente = new ClienteFisico("May", "123", "456");
        RepositorioClienteFisico.getInstance().adicionar(cliente);
        ContaCorrente cc = new ContaCorrente(cliente);
        RepositorioContaCorrente.getInstance().adiconarConta(cliente, cc);
        System.out.println(cc.getNumeroConta());
        ContaInvestimento ci = new ContaInvestimento(cliente);
        RepositorioContaInvestimento.getInstance().adiconarConta(cliente, ci);
        System.out.println(ci.getNumeroConta());

        cc.depositar(100);
        cc.transferir(10,ci.getNumeroConta());

        System.out.println(cc.getSaldo());
        System.out.println(ci.getSaldo());

//        ClienteJuridico bethania = new ClienteJuridico("Bethania", "000", "321");
//        RepositorioClienteJuridico.getInstance().adicionar(bethania);
//        ContaCorrente conta = new ContaCorrente(bethania);
//        RepositorioContaCorrente.getInstance().adiconarConta(bethania, conta);
//
//        Banco.getInstance().iniciar();
    }
}
