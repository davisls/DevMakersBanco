package br.com.ada.views.banco;

import br.com.ada.banco.Banco;
import br.com.ada.clientes.Cliente;
import br.com.ada.clientes.ClienteFisico;
import br.com.ada.clientes.ClienteJuridico;
import br.com.ada.repositorio.cliente.RepositorioClienteFisico;
import br.com.ada.repositorio.cliente.RepositorioClienteJuridico;
import br.com.ada.views.View;

import java.util.List;

//todo - será que tavez não seja melhor criar tipo uma 'viewCadastro'
public class BancoView extends View {
    private static final BancoView INSTANCE = new BancoView();

    public static BancoView getInstance() {
        return INSTANCE;
    }

    public void menuInicial() {
        boolean sair = false;
        do {
            System.out.println("Bem vindo ao Banco");
            System.out.println("Digite 1 para abrir conta.");
            System.out.println("Digite 2 para acessar sua conta.");
            System.out.println("Digite 3 para encerrar a sessão.");
            int opcaoMenu = Integer.parseInt(sc.nextLine());
            switch (opcaoMenu) {
                case 1:
                    menuCadastro();
                    break;
                case 2:
                    //todo - criar função nessa classe para login
                    menuLogin();
                    // depois do login deverá chamar um menu do cliente
                    System.out.println("Foi escolhida a opção acessar conta");
                    break;
                case 3:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida, por favor digite novamente");
            }
        } while (!sair);
    }

    public void menuCadastro() {

        System.out.println("Digite o seu nome:");
        String nome = sc.nextLine();
        System.out.println("Digite sua senha:");
        String senha = sc.nextLine();
        //todo - vai ter alguma forma de validar nome??

        System.out.println("Selecione se você é pessoa jurídica ou física:");
        System.out.println("Digite 1 para pessoa jurídica.");
        System.out.println("Digite 2 para pessoa física.");
        System.out.println("Digite 3 para retornar ao menu inicial");
        int tipoPessoa = Integer.parseInt(sc.nextLine());
        switch (tipoPessoa){
            case 1:
                ClienteJuridico clienteJuridico = Banco.getInstance().criarClienteJuridico(nome,senha,pedirCnpj());
                Banco.getInstance().cadastrarCliente(clienteJuridico);
                break;
            case 2:
                ClienteFisico clienteFisico = Banco.getInstance().criarClienteFisico(nome,senha, pedirCpf());
                Banco.getInstance().cadastrarCliente(clienteFisico);
                break;
            case 3:
                menuInicial();
            default:
                System.out.println("Opção inválida, por favor digite novamente");
                menuCadastro();
        }
        // todo - validar se a senha criada tem um tamanho especifico ou algo assim??
        }

    private String pedirCpf() {
        System.out.println("Digite o seu cpf:");
        String cpf =  sc.nextLine();
        return cpf;
        //todo - validar cpf
    }

    private String pedirCnpj() {
        System.out.println("Digite o seu cnpj:");
        String cnpj =  sc.nextLine();
        return cnpj;
        //todo - validar cnpj
    }

    private void menuLogin() {
        System.out.println("Selecione se você é pessoa jurídica ou física:");
        System.out.println("Digite 1 para pessoa jurídica.");
        System.out.println("Digite 2 para pessoa física.");
        System.out.println("Digite 3 para retornar ao menu inicial");
        int tipoPessoa = Integer.parseInt(sc.nextLine());

        switch (tipoPessoa){
            case 1:
                menuLoginClienteJuridico();
                break;
            case 2:
                menuLoginClienteFisico();
                break;
            case 3:
                menuInicial();
            default:
                System.out.println("Opção inválida, por favor digite novamente");
                menuCadastro();
        }

    }

    //todo - onde colocar esses dois métodos?
    private boolean isCnpjCadastrado(String cnpj) {
        boolean isCnpjCadastrado = false;
        List<ClienteJuridico> clientes = RepositorioClienteJuridico.getInstance().retornarClientesJuridico();
        for (ClienteJuridico cliente : clientes) {
            if (cliente.getCnpj() == cnpj) {
                isCnpjCadastrado = true;
            }
        }
        return isCnpjCadastrado;
    }
    private boolean isCpfCadastrado(String cpf) {
        boolean isCpfCadastrado = false;
        List<ClienteFisico> clientes = RepositorioClienteFisico.getInstance().retornarClientesFisico();
        for (ClienteFisico cliente : clientes) {
            if (cliente.getCpf() == cpf) {
                isCpfCadastrado = true;
            }
        }
        return isCpfCadastrado;
    }

    private void menuLoginClienteJuridico() {
        String cnpj = pedirCnpj();
        if (!isCnpjCadastrado(cnpj)) {
            //exceção cnpj não cadastrado
            System.out.println("esse cnpj não esta cadastrado");
            return;
        }

        ClienteJuridico cliente = RepositorioClienteJuridico.getInstance().retornarClientePorCnpj(cnpj);

        System.out.println("Digite sua senha:");
        String senhaInserida = sc.nextLine();
        if (!cliente.verificaSenha(senhaInserida)) {
            //todo - exceção para senha errada
            System.out.println("senha inválida");
        }
        System.out.println("cliente juridico logado");
        //menuInicialClienteJuridico(Cliente)
    }

    private void menuLoginClienteFisico() {
        String cpf = pedirCpf();
        if (!isCpfCadastrado(cpf)) {
            //exceção cpf não cadastrado
            System.out.println("esse cpf não esta cadastrado");
            return;
        }

        ClienteFisico cliente = RepositorioClienteFisico.getInstance().retornarClientePorCpf(cpf);

        System.out.println("Digite sua senha:");
        String senhaInserida = sc.nextLine();
        if (!cliente.verificaSenha(senhaInserida)) {
            //todo - exceção para senha errada
            System.out.println("senha inválida");
        }
        System.out.println("cliente fisico logado");
        //menuInicialClienteFisico(Cliente)
    }


}
