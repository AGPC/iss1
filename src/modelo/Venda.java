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
@Table(name = "venda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Venda.findAll", query = "SELECT v FROM Venda v"),
    @NamedQuery(name = "Venda.findByIdVenda", query = "SELECT v FROM Venda v WHERE v.idVenda = :idVenda"),
    @NamedQuery(name = "Venda.findByPago", query = "SELECT v FROM Venda v WHERE v.pago = :pago"),
    @NamedQuery(name = "Venda.findByData", query = "SELECT v FROM Venda v WHERE v.data = :data"),
    @NamedQuery(name = "Venda.findByValorTotal", query = "SELECT v FROM Venda v WHERE v.valorTotal = :valorTotal"),
    @NamedQuery(name = "Venda.findByDesconto", query = "SELECT v FROM Venda v WHERE v.desconto = :desconto"),
    @NamedQuery(name = "Venda.findByEntregue", query = "SELECT v FROM Venda v WHERE v.entregue = :entregue"),
    @NamedQuery(name = "Venda.findByAguardandoAutorizacao", query = "SELECT v FROM Venda v WHERE v.aguardandoAutorizacao = :aguardandoAutorizacao"),
    @NamedQuery(name = "Venda.findByFormaPagamento", query = "SELECT v FROM Venda v WHERE v.formaPagamento = :formaPagamento")})
public class Venda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idVenda")
    private Integer idVenda;
    @Basic(optional = false)
    @Column(name = "pago")
    private boolean pago;
    @Basic(optional = false)
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Basic(optional = false)
    @Column(name = "valorTotal")
    private float valorTotal;
    @Basic(optional = false)
    @Column(name = "desconto")
    private float desconto;
    @Basic(optional = false)
    @Column(name = "entregue")
    private boolean entregue;
    @Basic(optional = false)
    @Column(name = "aguardandoAutorizacao")
    private boolean aguardandoAutorizacao;
    @Basic(optional = false)
    @Column(name = "formaPagamento")
    private String formaPagamento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venda")
    private Collection<Itemvenda> itemvendaCollection;
    @JoinColumn(name = "Vendedor_idVendedor", referencedColumnName = "idVendedor")
    @ManyToOne(optional = false)
    private Vendedor vendedoridVendedor;
    @JoinColumn(name = "Cliente_idCliente", referencedColumnName = "idCliente")
    @ManyToOne(optional = false)
    private Cliente clienteidCliente;

    public Venda() {
    }

    public Venda(Integer idVenda) {
        this.idVenda = idVenda;
    }

    public Venda(Integer idVenda, boolean pago, Date data, float valorTotal, float desconto, boolean entregue, boolean aguardandoAutorizacao, String formaPagamento) {
        this.idVenda = idVenda;
        this.pago = pago;
        this.data = data;
        this.valorTotal = valorTotal;
        this.desconto = desconto;
        this.entregue = entregue;
        this.aguardandoAutorizacao = aguardandoAutorizacao;
        this.formaPagamento = formaPagamento;
    }

    public Integer getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Integer idVenda) {
        this.idVenda = idVenda;
    }

    public boolean getPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
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

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    public boolean getEntregue() {
        return entregue;
    }

    public void setEntregue(boolean entregue) {
        this.entregue = entregue;
    }

    public boolean getAguardandoAutorizacao() {
        return aguardandoAutorizacao;
    }

    public void setAguardandoAutorizacao(boolean aguardandoAutorizacao) {
        this.aguardandoAutorizacao = aguardandoAutorizacao;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    @XmlTransient
    public Collection<Itemvenda> getItemvendaCollection() {
        return itemvendaCollection;
    }

    public void setItemvendaCollection(Collection<Itemvenda> itemvendaCollection) {
        this.itemvendaCollection = itemvendaCollection;
    }

    public Vendedor getVendedoridVendedor() {
        return vendedoridVendedor;
    }

    public void setVendedoridVendedor(Vendedor vendedoridVendedor) {
        this.vendedoridVendedor = vendedoridVendedor;
    }

    public Cliente getClienteidCliente() {
        return clienteidCliente;
    }

    public void setClienteidCliente(Cliente clienteidCliente) {
        this.clienteidCliente = clienteidCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVenda != null ? idVenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venda)) {
            return false;
        }
        Venda other = (Venda) object;
        if ((this.idVenda == null && other.idVenda != null) || (this.idVenda != null && !this.idVenda.equals(other.idVenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Venda[ idVenda=" + idVenda + " ]";
    }
    
}
