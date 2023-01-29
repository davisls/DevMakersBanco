package br.com.ada.views.banco;

import br.com.ada.banco.Banco;
import br.com.ada.clientes.ClienteFisico;
import br.com.ada.clientes.ClienteJuridico;
import br.com.ada.views.View;

public class MenuCadastroView extends View {
    public void menuCadastro() {
        System.out.println("");
        System.out.println("Cadastro");
        System.out.println("Digite o seu nome:");
        String nome = getString();
        System.out.println("Digite sua senha:");
        String senha = getString();
        //todo - vai ter alguma forma de validar nome??

        System.out.println("Selecione se você é pessoa jurídica ou física:");
        System.out.println("Digite 1 para pessoa jurídica.");
        System.out.println("Digite 2 para pessoa física.");
        System.out.println("Digite 3 para retornar ao menu inicial");
        int tipoPessoa = getInt();
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
        // todo - validar se a senha criada tem um tamanho especifico ou algo assim??
    }


}
