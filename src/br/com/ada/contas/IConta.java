package br.com.ada.contas;

public interface IConta {
    void depositar(double valor);
    void sacar(double valor);

    void investir(double valor);
    //todo - separar método em outras duas interfaces, já que não é aplicável a contaInvestimento
    // e precisamos de um investir em conta poupaça e um investir em contaInvestimento
    void transferir(double valor, IConta contaDestino);
}
