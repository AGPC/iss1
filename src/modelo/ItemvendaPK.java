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
public class ItemvendaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "Venda_idVenda")
    private int vendaidVenda;
    @Basic(optional = false)
    @Column(name = "Produto_idProduto")
    private int produtoidProduto;

    public ItemvendaPK() {
    }

    public ItemvendaPK(int vendaidVenda, int produtoidProduto) {
        this.vendaidVenda = vendaidVenda;
        this.produtoidProduto = produtoidProduto;
    }

    public int getVendaidVenda() {
        return vendaidVenda;
    }

    public void setVendaidVenda(int vendaidVenda) {
        this.vendaidVenda = vendaidVenda;
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
        hash += (int) vendaidVenda;
        hash += (int) produtoidProduto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemvendaPK)) {
            return false;
        }
        ItemvendaPK other = (ItemvendaPK) object;
        if (this.vendaidVenda != other.vendaidVenda) {
            return false;
        }
        if (this.produtoidProduto != other.produtoidProduto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.ItemvendaPK[ vendaidVenda=" + vendaidVenda + ", produtoidProduto=" + produtoidProduto + " ]";
    }
    
}
