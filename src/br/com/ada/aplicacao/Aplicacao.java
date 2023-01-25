package br.com.ada.aplicacao;


import br.com.ada.banco.Banco;
import br.com.ada.clientes.ClienteFisico;
import br.com.ada.views.clientes.ClienteFisicoView;

public class Aplicacao {
    public static void main(String[] args) {
       //  Banco.getInstance().iniciar();
        ClienteFisico c = new ClienteFisico("davi", "davi", "123");
        Banco.getInstance().criaContaCorrente(c);
        // Banco.getInstance().criaContaInvestimento(c);
        ClienteFisicoView.getInstance().menuInicial(c);
    }
}
