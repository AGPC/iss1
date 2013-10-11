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
@Table(name = "itemvenda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Itemvenda.findAll", query = "SELECT i FROM Itemvenda i"),
    @NamedQuery(name = "Itemvenda.findByVendaidVenda", query = "SELECT i FROM Itemvenda i WHERE i.itemvendaPK.vendaidVenda = :vendaidVenda"),
    @NamedQuery(name = "Itemvenda.findByProdutoidProduto", query = "SELECT i FROM Itemvenda i WHERE i.itemvendaPK.produtoidProduto = :produtoidProduto"),
    @NamedQuery(name = "Itemvenda.findByQuantidade", query = "SELECT i FROM Itemvenda i WHERE i.quantidade = :quantidade"),
    @NamedQuery(name = "Itemvenda.findByValor", query = "SELECT i FROM Itemvenda i WHERE i.valor = :valor"),
    @NamedQuery(name = "Itemvenda.findByDesconto", query = "SELECT i FROM Itemvenda i WHERE i.desconto = :desconto")})
public class Itemvenda implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ItemvendaPK itemvendaPK;
    @Basic(optional = false)
    @Column(name = "quantidade")
    private int quantidade;
    @Basic(optional = false)
    @Column(name = "valor")
    private float valor;
    @Basic(optional = false)
    @Column(name = "desconto")
    private float desconto;
    @JoinColumn(name = "Produto_idProduto", referencedColumnName = "idProduto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Produto produto;
    @JoinColumn(name = "Venda_idVenda", referencedColumnName = "idVenda", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Venda venda;

    public Itemvenda() {
    }

    public Itemvenda(ItemvendaPK itemvendaPK) {
        this.itemvendaPK = itemvendaPK;
    }

    public Itemvenda(ItemvendaPK itemvendaPK, int quantidade, float valor, float desconto) {
        this.itemvendaPK = itemvendaPK;
        this.quantidade = quantidade;
        this.valor = valor;
        this.desconto = desconto;
    }

    public Itemvenda(int vendaidVenda, int produtoidProduto) {
        this.itemvendaPK = new ItemvendaPK(vendaidVenda, produtoidProduto);
    }

    public ItemvendaPK getItemvendaPK() {
        return itemvendaPK;
    }

    public void setItemvendaPK(ItemvendaPK itemvendaPK) {
        this.itemvendaPK = itemvendaPK;
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

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemvendaPK != null ? itemvendaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Itemvenda)) {
            return false;
        }
        Itemvenda other = (Itemvenda) object;
        if ((this.itemvendaPK == null && other.itemvendaPK != null) || (this.itemvendaPK != null && !this.itemvendaPK.equals(other.itemvendaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Itemvenda[ itemvendaPK=" + itemvendaPK + " ]";
    }
    
}
