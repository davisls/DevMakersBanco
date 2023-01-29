package br.com.ada.validacoes;

public class Verificar {
    public void existeSaldo(double saque, double saldo) {
        if (saque > saldo) {
            System.out.println("saldo indisponível");
        }
    }
}
