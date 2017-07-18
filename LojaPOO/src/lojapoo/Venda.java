/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojapoo;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author MrFELIS
 */
public class Venda {
    private String numero;
    private ArrayList<Item> itens;
    private TipoPagamento tipoPago;
    private Cliente cliente;
    private Calendar data;
    
    public Venda(String numero, TipoPagamento tipoPago, Cliente cliente, Calendar data) {
        this.numero = numero;
        this.tipoPago = tipoPago;
        this.cliente = cliente;
        this.data = data;
        itens = new ArrayList<>();
    
    }
    
    private void addItem(Item itens){
        this.itens.add(itens);
    }
    
    private float calcularTotal(){
        float total=0;
        for(Item item:itens){
           // total=itens;
       
    }
        return total;
}
    public String getData(){
        String msg;
        msg ="DATA "+ data.get(Calendar.DAY_OF_MONTH)+ "/" +data.get(Calendar.MONTH) +"/"+ data.get(Calendar.YEAR);
        return msg;
    }
    
    public String exibirEspecifico(){
        String msg="";
        return msg;
    }
    public String exibirDados(){
        return "\nNumero "+numero+"\nTipo de Pagamento "+tipoPago;
    }
}


