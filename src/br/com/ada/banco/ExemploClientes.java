package br.com.ada.banco;

import br.com.ada.clientes.ClienteFisico;
import br.com.ada.clientes.ClienteJuridico;
import br.com.ada.contas.ContaCorrente;
import br.com.ada.contas.ContaInvestimento;
import br.com.ada.repositorio.cliente.RepositorioClienteFisico;
import br.com.ada.repositorio.cliente.RepositorioClienteJuridico;
import br.com.ada.repositorio.conta.RepositorioContaCorrente;
import br.com.ada.repositorio.conta.RepositorioContaInvestimento;

public class ExemploClientes {
    //Classe criada para pré-cadastrar clientes para os exemplos durante a apresentação

    public static void criarClientesExemplo() {
        ClienteFisico cliente = new ClienteFisico("May", "1234", "27930497003");
        RepositorioClienteFisico.getInstance().adicionar(cliente);
        ContaCorrente cc = new ContaCorrente(cliente);
        RepositorioContaCorrente.getInstance().adiconarConta(cliente, cc);
        ContaInvestimento ci = new ContaInvestimento(cliente);
        RepositorioContaInvestimento.getInstance().adiconarConta(cliente, ci);

        ClienteJuridico bethania = new ClienteJuridico("Bethania", "0001", "60553182000150");
        RepositorioClienteJuridico.getInstance().adicionar(bethania);
        ContaCorrente conta = new ContaCorrente(bethania);
        RepositorioContaCorrente.getInstance().adiconarConta(bethania, conta);

        System.out.println();
        System.out.println(cliente.getNome() + " - CPF: " + cliente.getCpf() + " Senha: 1234");
        System.out.println(cliente.getNome() + " - número da conta corrente: " + cc.getNumeroConta());
        System.out.println(cliente.getNome() + " - número da conta investimento: " + ci.getNumeroConta());
        System.out.println(conta.getCliente().getNome() + " - CNPJ: " + bethania.getCnpj() + " Senha: 0001");
        System.out.println(conta.getCliente().getNome() + " - número da conta corrente: " +conta.getNumeroConta());
        System.out.println();
    }
}
