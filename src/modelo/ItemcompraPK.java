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
public class ItemcompraPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "Compra_idCompra")
    private int compraidCompra;
    @Basic(optional = false)
    @Column(name = "Produto_idProduto")
    private int produtoidProduto;

    public ItemcompraPK() {
    }

    public ItemcompraPK(int compraidCompra, int produtoidProduto) {
        this.compraidCompra = compraidCompra;
        this.produtoidProduto = produtoidProduto;
    }

    public int getCompraidCompra() {
        return compraidCompra;
    }

    public void setCompraidCompra(int compraidCompra) {
        this.compraidCompra = compraidCompra;
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
        hash += (int) compraidCompra;
        hash += (int) produtoidProduto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemcompraPK)) {
            return false;
        }
        ItemcompraPK other = (ItemcompraPK) object;
        if (this.compraidCompra != other.compraidCompra) {
            return false;
        }
        if (this.produtoidProduto != other.produtoidProduto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.ItemcompraPK[ compraidCompra=" + compraidCompra + ", produtoidProduto=" + produtoidProduto + " ]";
    }
    
}
