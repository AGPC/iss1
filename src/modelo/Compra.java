/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Luiz
 */
@Entity
@Table(name = "compra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Compra.findAll", query = "SELECT c FROM Compra c"),
    @NamedQuery(name = "Compra.findByIdCompra", query = "SELECT c FROM Compra c WHERE c.idCompra = :idCompra"),
    @NamedQuery(name = "Compra.findByData", query = "SELECT c FROM Compra c WHERE c.data = :data"),
    @NamedQuery(name = "Compra.findByValorToral", query = "SELECT c FROM Compra c WHERE c.valorToral = :valorToral")})
public class Compra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idCompra")
    private Integer idCompra;
    @Basic(optional = false)
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Basic(optional = false)
    @Column(name = "valorToral")
    private float valorTotal;
    @JoinColumn(name = "Fornecedor_idFornecedor", referencedColumnName = "idFornecedor")
    @ManyToOne(optional = false)
    private Fornecedor fornecedoridFornecedor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compra")
    private Collection<Itemcompra> itemcompraCollection;

    public Compra() {
    }

    public Compra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Compra(Integer idCompra, Date data, float valorTotal) {
        this.idCompra = idCompra;
        this.data = data;
        this.valorTotal = valorTotal;
    }

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Fornecedor getFornecedoridFornecedor() {
        return fornecedoridFornecedor;
    }

    public void setFornecedoridFornecedor(Fornecedor fornecedoridFornecedor) {
        this.fornecedoridFornecedor = fornecedoridFornecedor;
    }

    @XmlTransient
    public Collection<Itemcompra> getItemcompraCollection() {
        return itemcompraCollection;
    }

    public void setItemcompraCollection(Collection<Itemcompra> itemcompraCollection) {
        this.itemcompraCollection = itemcompraCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCompra != null ? idCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compra)) {
            return false;
        }
        Compra other = (Compra) object;
        if ((this.idCompra == null && other.idCompra != null) || (this.idCompra != null && !this.idCompra.equals(other.idCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Compra[ idCompra=" + idCompra + " ]";
    }
    
}
