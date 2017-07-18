/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojapoo;

import java.util.ArrayList;

/**
 *
 * @author MrFELIS
 */
public class Cliente {
    private String cpf;
    private String nome;
    private ArrayList<Venda> vendas;

    public Cliente(String nome, String cpf) {
        this.cpf = cpf;
        this.nome = nome;
        vendas = new ArrayList<>();
    }
    public Cliente(){
    }

    public String getNome() {
        return nome;
    }
    
    public String dadosCliente(){
        String msg ="\nNome "+nome+
                    "\nCPF "+ cpf;
        return msg;  
    }
    public static Cliente procurarCliente(ArrayList<Cliente> clientes, String msg ){
        for(Cliente cliente : clientes){
            if(cliente.getNome().equals(msg)) return cliente;
        }
        return null;
    }

    public String totalGasto(){
        String msg="";
        for(Venda venda: vendas){
         msg=venda.getData()
        }
        return msg;
    }
}
