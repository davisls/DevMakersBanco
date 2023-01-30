package br.com.ada.views.banco;

import br.com.ada.clientes.Cliente;
import br.com.ada.clientes.ClienteFisico;
import br.com.ada.clientes.ClienteJuridico;
import br.com.ada.excecoes.DocumentoFormatoInvalidoException;
import br.com.ada.excecoes.DocumentoNaoCadastradoException;
import br.com.ada.excecoes.SenhaErradaException;
import br.com.ada.repositorio.cliente.RepositorioClienteFisico;
import br.com.ada.repositorio.cliente.RepositorioClienteJuridico;
import br.com.ada.views.View;
import br.com.ada.views.clientes.ClienteFisicoView;
import br.com.ada.views.clientes.ClienteJuridicoView;

public class MenuLoginView extends View {
    public void menuLogin() {
        System.out.println("");
        System.out.println("~~~~< ▶ LOGIN >~~~~");
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
        try {
            String cnpj = pedirCnpj();
            validarInput.getValidarCnpj().isCnpjCadastrado(cnpj);
            ClienteJuridico cliente = RepositorioClienteJuridico.getInstance().retornarClientePorCnpj(cnpj);
            validarSenhaCliente(cliente);
            ClienteJuridicoView.getInstance().menuInicial(cliente);
        } catch (DocumentoFormatoInvalidoException | DocumentoNaoCadastradoException e){
            System.out.println(e.getMessage());
            menuLogin();
        }
    }

    private void menuLoginClienteFisico() {
        try {
            String cpf = pedirCpf();
            validarInput.getValidarCpf().isCpfCadastrado(cpf);
            ClienteFisico cliente = RepositorioClienteFisico.getInstance().retornarClientePorCpf(cpf);
            validarSenhaCliente(cliente);
            ClienteFisicoView.getInstance().menuInicial(cliente);
        } catch (DocumentoFormatoInvalidoException | DocumentoNaoCadastradoException e){
            System.out.println(e.getMessage());
            menuLogin();
        }
    }

    public void validarSenhaCliente(Cliente cliente){
        String senhaInserida = pedirSenha();
        try {
            validarInput.getValidarSenha().validarSenhaDoCliente(cliente, senhaInserida);
        } catch (SenhaErradaException ex){
            System.out.println(ex.getMessage());
            menuLogin();
        }
    }

}
