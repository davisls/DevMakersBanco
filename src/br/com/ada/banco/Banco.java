package br.com.ada.banco;

import br.com.ada.clientes.Cliente;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Cliente> clienteList = new ArrayList<>();

    public Banco(){
    }

    public void adicionarClienteNaLista(Cliente cliente){
        clienteList.add(cliente);
    }

    public void removerClienteNaLista(Cliente cliente){
        clienteList.remove(cliente);
    }


}
