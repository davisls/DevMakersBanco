package br.com.ada.utils;

public class Verificar {
    public void existeSaldo(double saque, double saldo) {
        if (saque > saldo) {
            System.out.println("saldo indisponível");
        }
    }
}
