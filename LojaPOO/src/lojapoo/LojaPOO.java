/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojapoo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author MrFELIS
 */
public class LojaPOO {

    private static int menu(){
        int opcao;
        Boolean continua;
        do{
        continua=true;  
        String menu="Loja IMPLACAVEL";
        menu+=  "\n1 - Cadastrar"+
                "\n2 - Registrar Compra"+
                "\n3 - Relatorios"+
                "\n4 - Salvar Dados"+
                "\n5 - Carregar Dados"+
                "\n6 - Sair";
        String opc=JOptionPane.showInputDialog(menu);
        if(opc == null) return 6;
        opcao=Integer.parseInt(opc);
        if(opcao>0 && opcao<7) continua=false;
        }while(continua);
        return opcao;
    }
    
    private static int menuCadastrar(){
        int opcao;
        Boolean continua;
        do{
        continua=true; 
        String menu="Menu Cadastrar";
        menu+=  "\n1 - Cliente"+
                "\n2 - Produto"+
                "\n3 - Voltar";
        String opc=JOptionPane.showInputDialog(menu);
        if(opc == null) return 4;
        opcao=Integer.parseInt(opc);
        if(opcao>0 && opcao<7) continua=false;
        }while(continua);
        return opcao;
    }
    
    private static int menuCadastrarProduto()  {
        int opcao;
        Boolean continua;
        do{
        continua=true; 
        String menu="Menu Cadastrar";
        menu+=  "\n1 - Produto Nacional"+
                "\n2 - Produto Internacional"+
                "\n3 - Voltar";
                String opc=JOptionPane.showInputDialog(menu);
        if(opc == null) return 4;
        opcao=Integer.parseInt(opc);
        if(opcao>0 && opcao<4) continua=false;
        }while(continua);
        return opcao;
    }

    private static int menuRelatorios(){
    int opcao;
    Boolean continua;
    do{
        continua=true;
        String menu="Menu Cadastrar";
        menu+=  "\n1 - Listar Clientes"+
                "\n2 - Listar Cliente Especifico"+
                "\n3 - Listar Gastos de um Cliente"+
                "\n4 - Listar Produtos"+
                "\n5 - Listar Produto Especifico"+
                "\n6 - Listar Vendas"+
                "\n7 - Listar Venda Especifica"+
                "\n8 - Listar Venda por tipo de pagamento"+
                "\n9 - Listar Venda por tipo de pagamento detalhado"+
                "\n10 - Voltar";
        String opc=JOptionPane.showInputDialog(menu);
        if(opc == null) return 11;
        opcao=Integer.parseInt(opc);
        if(opcao>0 && opcao<11) continua=false;
    }while(continua);
    return opcao;
}

    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        //===VARIAVEIS DE CONTROLE====//
        Boolean continua;
        Boolean continua2;
        int opcao;
        int opcao2;
        //====ARRAY==================//
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Produto> produtos = new ArrayList<>();
        //======
        String nome;
        String cpf;
        
        String codigo;
        String desc;
        float valor;
        float taxaImposto;
        float taxaImportacao;     
        

        String msg;
        Cliente cli;
        Produto pro;
        JanelaRelatorio rel;
        
        FileOutputStream fos = new FileOutputStream("teste.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        do{       
            continua=true;
            opcao=menu();
            switch(opcao){
               case 1:
                  do{
                       opcao2=menuCadastrar();
                       continua2=true;
                       switch(opcao2){
                           case 1:
                               nome = JOptionPane.showInputDialog("Insira o nome do Cliente");
                               cpf =(JOptionPane.showInputDialog("Insira CPF"));
                               Cliente cl = new Cliente(nome, cpf);
                               clientes.add(cl);
                               
                               break;
                           case 2:
                               do{
                                   continua2=true;
                                   opcao2=menuCadastrarProduto(); 
                                   switch(opcao2){
                                       case 1:
                                            codigo = JOptionPane.showInputDialog("Nome Produto Nacional");
                                            desc =(JOptionPane.showInputDialog("Descricao Produto Nacional"));
                                            valor =Float.parseFloat(JOptionPane.showInputDialog("Valor Produto Nacional"));
                                            taxaImposto =Float.parseFloat(JOptionPane.showInputDialog("Taxa Imposto Produto Nacional"));
                                            Produto prod = new ProdutoNacional(taxaImposto, codigo,desc, valor);
                                            produtos.add(prod);
                                            break;
                                       case 2:
                                            codigo = JOptionPane.showInputDialog("Codigo Produto Importado");
                                            desc =(JOptionPane.showInputDialog("Descricao Produto Importado"));
                                            valor =Float.parseFloat(JOptionPane.showInputDialog("Valor Produto Importado"));
                                            taxaImposto =Float.parseFloat(JOptionPane.showInputDialog("Taxa Imposto Produto Importado"));
                                            taxaImportacao = Float.parseFloat(JOptionPane.showInputDialog("Taxa Importacao"));
                                            prod = new ProdutoImportado(taxaImposto, taxaImportacao, codigo,desc, valor);
                                            produtos.add(prod);
                                           break;   
                                       case 3:
                                           continua2=false;
                                           break;
                                       case 4:
                                           continua2=false;     //FECHAR PROGRAMA, BOTAO X E CANCELAR
                                           continua=false;
                                           break;
                                    }
                                }while(continua2);
                               continua2=true;
                               break;
                              
                            case 3:
                               continua2=false;
                               break;
                       
                            case 4:
                                continua2=false;    //FECHAR PROGRAMA, BOTAO X E CANCELAR
                                continua=false;
                                break;                    
                   }  
                   }while(continua2);
                    break;
              //==================CASE 2=========================================================================
               case 2:
                   if(clientes.isEmpty()) JOptionPane.showMessageDialog(null, "Não há Clientes Cadastrados");
                   if(produtos.isEmpty()) JOptionPane.showMessageDialog(null, "Não há Produtos Cadastrados");
                   msg=JOptionPane.showInputDialog("Registrar Comprar\nInsira nome do Cliente:");      
                   cli = Cliente.procurarCliente(clientes, msg);
                   if(cli != null){
                       msg=JOptionPane.showInputDialog("Produto");
                       
                   }
                   break;
             //===================CASE 3===============================================================================
               case 3:
                   do{
                       opcao2=menuRelatorios();
                       continua2=true;
                       switch(opcao2){
                           case 1:
                               msg="";
                               if(clientes.isEmpty()) JOptionPane.showMessageDialog(null, "Nao há Clientes Cadastrados");
                               else{ for (Cliente cliente : clientes) {
                                        msg+="\n";
                                        msg+= cliente.dadosCliente();
                                    }
                               rel = new JanelaRelatorio(msg);
                               rel.exibir();
                               }
                               break;
                           case 2:
                               if(clientes.isEmpty()) JOptionPane.showMessageDialog(null, "Nao há Clientes Cadastrados");
                               else{
                                   Boolean aux=true;
                                   msg=JOptionPane.showInputDialog("Insira Nome Cliente");
                                   for(Cliente cliente: clientes){
                                       if(cliente.getNome().equals(msg)){
                                           JOptionPane.showMessageDialog(null, cliente.dadosCliente());
                                           aux=false;
                                       } 
                                   }
                                   if(aux) JOptionPane.showMessageDialog(null, "Cliente Nao Encontrado");
                               }
                               break;
                           case 3:
                               break;
                           case 4:
                               msg="";
                               if(produtos.isEmpty()) JOptionPane.showMessageDialog(null, "Nao há Produtos Cadastrados");
                               else{ for (Produto produto : produtos) {
                                        msg+="\n";
                                        msg = produto.dadosProdutos();
                                    }
                               rel = new JanelaRelatorio(msg);
                               rel.exibir();
                               }
                               break;
                           case 5:
                               if(produtos.isEmpty()) JOptionPane.showMessageDialog(null, "Nao há Produto Cadastrados");
                               else{
                                   Boolean aux=true;
                                   msg=JOptionPane.showInputDialog("Insira Codigo Produto");
                                   for(Produto produto: produtos){
                                       if(produto.getCodigo().equals(msg)){
                                           JOptionPane.showMessageDialog(null, produto.dadosProdutos());
                                           aux=false;
                                       } 
                                   }
                                   if(aux) JOptionPane.showMessageDialog(null, "Produto Não Encontrado");
                               }
                               break;
                           case 6:
                               break;
                           case 10:
                               continua2=false;
                               break;
                           case 11:
                               continua=false;
                               continua2=false;
                               break;
                       }
                   }while(continua2);
                   break;
               //===========================CASE 4=====================================================
               case 4:
                   
                   break;
               case 6:
                   continua=false;
                   break;
           }
        }while(continua);
    
        oos.close();
        fos.close();
}
}
