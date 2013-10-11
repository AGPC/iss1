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
import javax.persistence.JoinColumns;
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
@Table(name = "itemorcamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Itemorcamento.findAll", query = "SELECT i FROM Itemorcamento i"),
    @NamedQuery(name = "Itemorcamento.findByOrcamentoidOrcamento", query = "SELECT i FROM Itemorcamento i WHERE i.itemorcamentoPK.orcamentoidOrcamento = :orcamentoidOrcamento"),
    @NamedQuery(name = "Itemorcamento.findByOrcamentoformaPagamento", query = "SELECT i FROM Itemorcamento i WHERE i.itemorcamentoPK.orcamentoformaPagamento = :orcamentoformaPagamento"),
    @NamedQuery(name = "Itemorcamento.findByProdutoidProduto", query = "SELECT i FROM Itemorcamento i WHERE i.itemorcamentoPK.produtoidProduto = :produtoidProduto"),
    @NamedQuery(name = "Itemorcamento.findByQuantidade", query = "SELECT i FROM Itemorcamento i WHERE i.quantidade = :quantidade"),
    @NamedQuery(name = "Itemorcamento.findByValor", query = "SELECT i FROM Itemorcamento i WHERE i.valor = :valor"),
    @NamedQuery(name = "Itemorcamento.findByDesconto", query = "SELECT i FROM Itemorcamento i WHERE i.desconto = :desconto")})
public class Itemorcamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ItemorcamentoPK itemorcamentoPK;
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
    @JoinColumns({
        @JoinColumn(name = "Orcamento_idOrcamento", referencedColumnName = "idOrcamento", insertable = false, updatable = false),
        @JoinColumn(name = "Orcamento_formaPagamento", referencedColumnName = "formaPagamento", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Orcamento orcamento;

    public Itemorcamento() {
    }

    public Itemorcamento(ItemorcamentoPK itemorcamentoPK) {
        this.itemorcamentoPK = itemorcamentoPK;
    }

    public Itemorcamento(ItemorcamentoPK itemorcamentoPK, int quantidade, float valor, float desconto) {
        this.itemorcamentoPK = itemorcamentoPK;
        this.quantidade = quantidade;
        this.valor = valor;
        this.desconto = desconto;
    }

    public Itemorcamento(int orcamentoidOrcamento, String orcamentoformaPagamento, int produtoidProduto) {
        this.itemorcamentoPK = new ItemorcamentoPK(orcamentoidOrcamento, orcamentoformaPagamento, produtoidProduto);
    }

    public ItemorcamentoPK getItemorcamentoPK() {
        return itemorcamentoPK;
    }

    public void setItemorcamentoPK(ItemorcamentoPK itemorcamentoPK) {
        this.itemorcamentoPK = itemorcamentoPK;
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

    public Orcamento getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Orcamento orcamento) {
        this.orcamento = orcamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemorcamentoPK != null ? itemorcamentoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Itemorcamento)) {
            return false;
        }
        Itemorcamento other = (Itemorcamento) object;
        if ((this.itemorcamentoPK == null && other.itemorcamentoPK != null) || (this.itemorcamentoPK != null && !this.itemorcamentoPK.equals(other.itemorcamentoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Itemorcamento[ itemorcamentoPK=" + itemorcamentoPK + " ]";
    }
    
}
