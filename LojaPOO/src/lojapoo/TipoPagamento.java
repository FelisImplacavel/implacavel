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
abstract class TipoPagamento {
    protected String tipoPagamento;

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    } 
    abstract String exibirDados();
}
