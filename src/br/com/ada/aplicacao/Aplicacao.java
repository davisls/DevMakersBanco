package br.com.ada.aplicacao;

import br.com.ada.banco.Banco;
import br.com.ada.banco.ExemploClientes;

public class Aplicacao {
    public static void main(String[] args) {
        ExemploClientes.criarClientesExemplo();
        Banco.getInstance().iniciar();
    }
}
