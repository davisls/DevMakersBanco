package br.com.ada.contas;

public interface IConta {
    void depositar(double valor);
    void sacar(double valor);
    void investir(double valor);

    void transferir(double valor, IConta contaDestino);
}
