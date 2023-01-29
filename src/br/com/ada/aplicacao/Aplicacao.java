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
        ClienteFisico cliente = new ClienteFisico("May", "1234", "456");
        RepositorioClienteFisico.getInstance().adicionar(cliente);
        ContaCorrente cc = new ContaCorrente(cliente);
        RepositorioContaCorrente.getInstance().adiconarConta(cliente, cc);
        ContaInvestimento ci = new ContaInvestimento(cliente);
        RepositorioContaInvestimento.getInstance().adiconarConta(cliente, ci);

        ClienteJuridico bethania = new ClienteJuridico("Bethania", "0001", "321");
        RepositorioClienteJuridico.getInstance().adicionar(bethania);
        ContaCorrente conta = new ContaCorrente(bethania);
        RepositorioContaCorrente.getInstance().adiconarConta(bethania, conta);

        System.out.println(cc.getCliente().getNome() + " - número da conta corrente: " + cc.getNumeroConta());
        System.out.println(ci.getCliente().getNome() + " - número da conta investimento: " + ci.getNumeroConta());
        System.out.println(conta.getCliente().getNome() + " - número da conta corrente: " +conta.getNumeroConta());

        Banco.getInstance().iniciar();
    }
}
