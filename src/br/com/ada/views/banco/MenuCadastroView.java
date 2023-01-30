package br.com.ada.views.banco;

import br.com.ada.banco.Banco;
import br.com.ada.clientes.ClienteFisico;
import br.com.ada.clientes.ClienteJuridico;
import br.com.ada.excecoes.DocumentoFormatoInvalidoException;
import br.com.ada.views.View;

public class MenuCadastroView extends View {
    public void menuCadastro() {
        System.out.println("\nCadastro");
        String nome = pedirNome();
        String senha = pedirSenha();

        System.out.println("\nSelecione se você é pessoa jurídica ou física:");
        System.out.println("Digite 1 para pessoa jurídica.");
        System.out.println("Digite 2 para pessoa física.");
        System.out.println("Digite 3 para retornar ao menu inicial");

        int tipoPessoa = pedirOpcao();
        try {
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
                    return;
                default:
                    System.out.println("Opção inválida, por favor digite novamente");
                    menuCadastro();
            }
        } catch (DocumentoFormatoInvalidoException e){
            System.out.println(e.getMessage());
            System.out.println("Cadastro não realizado!");
            menuCadastro();
        }
    }
}
