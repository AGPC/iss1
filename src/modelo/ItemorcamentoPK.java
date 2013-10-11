/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Luiz
 */
@Embeddable
public class ItemorcamentoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "Orcamento_idOrcamento")
    private int orcamentoidOrcamento;
    @Basic(optional = false)
    @Column(name = "Orcamento_formaPagamento")
    private String orcamentoformaPagamento;
    @Basic(optional = false)
    @Column(name = "Produto_idProduto")
    private int produtoidProduto;

    public ItemorcamentoPK() {
    }

    public ItemorcamentoPK(int orcamentoidOrcamento, String orcamentoformaPagamento, int produtoidProduto) {
        this.orcamentoidOrcamento = orcamentoidOrcamento;
        this.orcamentoformaPagamento = orcamentoformaPagamento;
        this.produtoidProduto = produtoidProduto;
    }

    public int getOrcamentoidOrcamento() {
        return orcamentoidOrcamento;
    }

    public void setOrcamentoidOrcamento(int orcamentoidOrcamento) {
        this.orcamentoidOrcamento = orcamentoidOrcamento;
    }

    public String getOrcamentoformaPagamento() {
        return orcamentoformaPagamento;
    }

    public void setOrcamentoformaPagamento(String orcamentoformaPagamento) {
        this.orcamentoformaPagamento = orcamentoformaPagamento;
    }

    public int getProdutoidProduto() {
        return produtoidProduto;
    }

    public void setProdutoidProduto(int produtoidProduto) {
        this.produtoidProduto = produtoidProduto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) orcamentoidOrcamento;
        hash += (orcamentoformaPagamento != null ? orcamentoformaPagamento.hashCode() : 0);
        hash += (int) produtoidProduto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemorcamentoPK)) {
            return false;
        }
        ItemorcamentoPK other = (ItemorcamentoPK) object;
        if (this.orcamentoidOrcamento != other.orcamentoidOrcamento) {
            return false;
        }
        if ((this.orcamentoformaPagamento == null && other.orcamentoformaPagamento != null) || (this.orcamentoformaPagamento != null && !this.orcamentoformaPagamento.equals(other.orcamentoformaPagamento))) {
            return false;
        }
        if (this.produtoidProduto != other.produtoidProduto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.ItemorcamentoPK[ orcamentoidOrcamento=" + orcamentoidOrcamento + ", orcamentoformaPagamento=" + orcamentoformaPagamento + ", produtoidProduto=" + produtoidProduto + " ]";
    }
    
}
