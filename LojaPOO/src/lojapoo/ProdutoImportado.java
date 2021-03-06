/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojapoo;

/**
 *
 * @author MrFELIS
 */
public class ProdutoImportado extends Produto {
    private float taxaImposto;
    private float taxaImportacao;
    private String tipo;

    public ProdutoImportado(float taxaImposto, float taxaImportacao, String codigo, String descricao, float valor) {
        super(codigo, descricao, valor);
        this.taxaImposto = taxaImposto;
        this.taxaImportacao = taxaImportacao;
        tipo = "importado";
    }
    @Override
    public float getValor() {
        return valor;
    }
    @Override
    public String getDescricao() {
        return descricao;
    }
    @Override
    public String getCodigo(){
        return codigo;
    }
    @Override
    float calculaPreco(){
        float valorTotal;
        valorTotal=getValor()+taxaImposto+taxaImportacao;
        return valorTotal;
    }
    
    @Override
        float valorTotal(){
        return super.valor + (taxaImposto/100 * super.valor) + (taxaImportacao/100 * super.valor);
        }
    @Override
    public String dadosProdutos(){
    String msg ="Produto "+getCodigo()+
            "\nDescricao "+getDescricao()+
            "\nValor R$"+getValor()+
            "\nTaxa de Imposto R$"+taxaImposto+
            "\nTaxa de Importacao R$"+taxaImportacao;
        return msg;  
    }
}
