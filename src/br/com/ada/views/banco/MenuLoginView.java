package br.com.ada.views.banco;

import br.com.ada.clientes.ClienteFisico;
import br.com.ada.clientes.ClienteJuridico;
import br.com.ada.excecoes.CpfNaoCadastradoException;
import br.com.ada.excecoes.SenhaErradaException;
import br.com.ada.repositorio.cliente.RepositorioClienteFisico;
import br.com.ada.repositorio.cliente.RepositorioClienteJuridico;
import br.com.ada.views.View;
import br.com.ada.views.clientes.ClienteFisicoView;
import br.com.ada.views.clientes.ClienteJuridicoView;

public class MenuLoginView extends View {
    public void menuLogin() {
        System.out.println("");
        System.out.println("Login");
        System.out.println("Selecione se você é pessoa jurídica ou física:");
        System.out.println("Digite 1 para pessoa jurídica.");
        System.out.println("Digite 2 para pessoa física.");
        System.out.println("Digite 3 para retornar ao menu inicial");
        int tipoPessoa = pedirOpcao();

        switch (tipoPessoa){
            case 1:
                menuLoginClienteJuridico();
                break;
            case 2:
                menuLoginClienteFisico();
                break;
            case 3:
                return;
            default:
                System.out.println("Opção inválida, por favor digite novamente");
                menuLogin();
        }

    }

    private void menuLoginClienteJuridico() {
        String cnpj = pedirCnpj();
        if (!validarInput.getValidarCnpj().isCnpjCadastrado(cnpj)) {
            //todo - exceção cnpj não cadastrado
            System.out.println("esse cnpj não esta cadastrado!");
            return;
        }
        ClienteJuridico cliente = RepositorioClienteJuridico.getInstance().retornarClientePorCnpj(cnpj);

        System.out.println("Digite sua senha:");
        String senhaInserida = getString();
        if (!cliente.verificaSenha(senhaInserida)) {
            //todo - exceção para senha errada
            System.out.println("senha inválida");
            return;
        }
        System.out.println("cliente juridico logado");
        ClienteJuridicoView.getInstance().menuInicial(cliente);
    }

    private void menuLoginClienteFisico() {
        String cpf = pedirCpf();
        if (!validarInput.getValidarCpf().isCpfCadastrado(cpf)) {
            throw new CpfNaoCadastradoException("Cpf não cadastrado!");
        }
        ClienteFisico cliente = RepositorioClienteFisico.getInstance().retornarClientePorCpf(cpf);

        String senhaInserida = pedirSenha();
        try {
            validarInput.getValidarSenha().validarSenhaDoCliente(cliente, senhaInserida);

        } catch (SenhaErradaException ex){
            System.out.println(ex.getMessage());
            menuLoginClienteFisico();
        }
//
        System.out.println("cliente fisico logado");
        ClienteFisicoView.getInstance().menuInicial(cliente);
    }

}
