/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Luiz
 */
@Entity
@Table(name = "produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p"),
    @NamedQuery(name = "Produto.findByIdProduto", query = "SELECT p FROM Produto p WHERE p.idProduto = :idProduto"),
    @NamedQuery(name = "Produto.findByDecricao", query = "SELECT p FROM Produto p WHERE p.decricao = :decricao"),
    @NamedQuery(name = "Produto.findByMarca", query = "SELECT p FROM Produto p WHERE p.marca = :marca"),
    @NamedQuery(name = "Produto.findByPreco", query = "SELECT p FROM Produto p WHERE p.preco = :preco"),
    @NamedQuery(name = "Produto.findByQuantidade", query = "SELECT p FROM Produto p WHERE p.quantidade = :quantidade")})
public class Produto implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produto")
    private Collection<Itemvenda> itemvendaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produto")
    private Collection<Itemorcamento> itemorcamentoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produto")
    private Collection<Itemcompra> itemcompraCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idProduto")
    private Integer idProduto;
    @Basic(optional = false)
    @Column(name = "decricao")
    private String decricao;
    @Basic(optional = false)
    @Column(name = "marca")
    private String marca;
    @Basic(optional = false)
    @Column(name = "preco")
    private float preco;
    @Basic(optional = false)
    @Column(name = "quantidade")
    private int quantidade;
    private String Descricao;

    public Produto() {
    }

    public Produto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public Produto(Integer idProduto, String Descricao, String marca, float preco, int quantidade) {
        this.idProduto = idProduto;
        this.Descricao = Descricao;
        this.marca = marca;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String decricao) {
        this.Descricao = Descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduto != null ? idProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.idProduto == null && other.idProduto != null) || (this.idProduto != null && !this.idProduto.equals(other.idProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Produto[ idProduto=" + idProduto + " ]";
    }

    @XmlTransient
    public Collection<Itemvenda> getItemvendaCollection() {
        return itemvendaCollection;
    }

    public void setItemvendaCollection(Collection<Itemvenda> itemvendaCollection) {
        this.itemvendaCollection = itemvendaCollection;
    }

    @XmlTransient
    public Collection<Itemorcamento> getItemorcamentoCollection() {
        return itemorcamentoCollection;
    }

    public void setItemorcamentoCollection(Collection<Itemorcamento> itemorcamentoCollection) {
        this.itemorcamentoCollection = itemorcamentoCollection;
    }

    @XmlTransient
    public Collection<Itemcompra> getItemcompraCollection() {
        return itemcompraCollection;
    }

    public void setItemcompraCollection(Collection<Itemcompra> itemcompraCollection) {
        this.itemcompraCollection = itemcompraCollection;
    }

    public void setPreco(String text) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void setQuantidade(String text) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
}
