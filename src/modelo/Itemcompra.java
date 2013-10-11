/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Luiz
 */
@Entity
@Table(name = "itemcompra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Itemcompra.findAll", query = "SELECT i FROM Itemcompra i"),
    @NamedQuery(name = "Itemcompra.findByCompraidCompra", query = "SELECT i FROM Itemcompra i WHERE i.itemcompraPK.compraidCompra = :compraidCompra"),
    @NamedQuery(name = "Itemcompra.findByProdutoidProduto", query = "SELECT i FROM Itemcompra i WHERE i.itemcompraPK.produtoidProduto = :produtoidProduto"),
    @NamedQuery(name = "Itemcompra.findByQuantidade", query = "SELECT i FROM Itemcompra i WHERE i.quantidade = :quantidade"),
    @NamedQuery(name = "Itemcompra.findByValor", query = "SELECT i FROM Itemcompra i WHERE i.valor = :valor")})
public class Itemcompra implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ItemcompraPK itemcompraPK;
    @Basic(optional = false)
    @Column(name = "quantidade")
    private int quantidade;
    @Basic(optional = false)
    @Column(name = "valor")
    private float valor;
    @JoinColumn(name = "Produto_idProduto", referencedColumnName = "idProduto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Produto produto;
    @JoinColumn(name = "Compra_idCompra", referencedColumnName = "idCompra", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Compra compra;

    public Itemcompra() {
    }

    public Itemcompra(ItemcompraPK itemcompraPK) {
        this.itemcompraPK = itemcompraPK;
    }

    public Itemcompra(ItemcompraPK itemcompraPK, int quantidade, float valor) {
        this.itemcompraPK = itemcompraPK;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public Itemcompra(int compraidCompra, int produtoidProduto) {
        this.itemcompraPK = new ItemcompraPK(compraidCompra, produtoidProduto);
    }

    public ItemcompraPK getItemcompraPK() {
        return itemcompraPK;
    }

    public void setItemcompraPK(ItemcompraPK itemcompraPK) {
        this.itemcompraPK = itemcompraPK;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemcompraPK != null ? itemcompraPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Itemcompra)) {
            return false;
        }
        Itemcompra other = (Itemcompra) object;
        if ((this.itemcompraPK == null && other.itemcompraPK != null) || (this.itemcompraPK != null && !this.itemcompraPK.equals(other.itemcompraPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Itemcompra[ itemcompraPK=" + itemcompraPK + " ]";
    }
    
}
