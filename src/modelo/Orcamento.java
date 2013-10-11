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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "orcamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orcamento.findAll", query = "SELECT o FROM Orcamento o"),
    @NamedQuery(name = "Orcamento.findByIdOrcamento", query = "SELECT o FROM Orcamento o WHERE o.orcamentoPK.idOrcamento = :idOrcamento"),
    @NamedQuery(name = "Orcamento.findByData", query = "SELECT o FROM Orcamento o WHERE o.data = :data"),
    @NamedQuery(name = "Orcamento.findByValorTotal", query = "SELECT o FROM Orcamento o WHERE o.valorTotal = :valorTotal"),
    @NamedQuery(name = "Orcamento.findByDesconto", query = "SELECT o FROM Orcamento o WHERE o.desconto = :desconto"),
    @NamedQuery(name = "Orcamento.findByAguardandoAutorizacao", query = "SELECT o FROM Orcamento o WHERE o.aguardandoAutorizacao = :aguardandoAutorizacao"),
    @NamedQuery(name = "Orcamento.findByDataValidade", query = "SELECT o FROM Orcamento o WHERE o.dataValidade = :dataValidade"),
    @NamedQuery(name = "Orcamento.findByFormaPagamento", query = "SELECT o FROM Orcamento o WHERE o.orcamentoPK.formaPagamento = :formaPagamento")})
public class Orcamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrcamentoPK orcamentoPK;
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
    @Column(name = "aguardandoAutorizacao")
    private boolean aguardandoAutorizacao;
    @Basic(optional = false)
    @Column(name = "dataValidade")
    @Temporal(TemporalType.DATE)
    private Date dataValidade;
    @JoinColumn(name = "Cliente_idCliente", referencedColumnName = "idCliente")
    @ManyToOne(optional = false)
    private Cliente clienteidCliente;
    @JoinColumn(name = "Vendedor_idVendedor", referencedColumnName = "idVendedor")
    @ManyToOne(optional = false)
    private Vendedor vendedoridVendedor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orcamento")
    private Collection<Itemorcamento> itemorcamentoCollection;

    public Orcamento() {
    }

    public Orcamento(OrcamentoPK orcamentoPK) {
        this.orcamentoPK = orcamentoPK;
    }

    public Orcamento(OrcamentoPK orcamentoPK, Date data, float valorTotal, float desconto, boolean aguardandoAutorizacao, Date dataValidade) {
        this.orcamentoPK = orcamentoPK;
        this.data = data;
        this.valorTotal = valorTotal;
        this.desconto = desconto;
        this.aguardandoAutorizacao = aguardandoAutorizacao;
        this.dataValidade = dataValidade;
    }

    public Orcamento(int idOrcamento, String formaPagamento) {
        this.orcamentoPK = new OrcamentoPK(idOrcamento, formaPagamento);
    }

    public OrcamentoPK getOrcamentoPK() {
        return orcamentoPK;
    }

    public void setOrcamentoPK(OrcamentoPK orcamentoPK) {
        this.orcamentoPK = orcamentoPK;
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

    public boolean getAguardandoAutorizacao() {
        return aguardandoAutorizacao;
    }

    public void setAguardandoAutorizacao(boolean aguardandoAutorizacao) {
        this.aguardandoAutorizacao = aguardandoAutorizacao;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    public Cliente getClienteidCliente() {
        return clienteidCliente;
    }

    public void setClienteidCliente(Cliente clienteidCliente) {
        this.clienteidCliente = clienteidCliente;
    }

    public Vendedor getVendedoridVendedor() {
        return vendedoridVendedor;
    }

    public void setVendedoridVendedor(Vendedor vendedoridVendedor) {
        this.vendedoridVendedor = vendedoridVendedor;
    }

    @XmlTransient
    public Collection<Itemorcamento> getItemorcamentoCollection() {
        return itemorcamentoCollection;
    }

    public void setItemorcamentoCollection(Collection<Itemorcamento> itemorcamentoCollection) {
        this.itemorcamentoCollection = itemorcamentoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orcamentoPK != null ? orcamentoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orcamento)) {
            return false;
        }
        Orcamento other = (Orcamento) object;
        if ((this.orcamentoPK == null && other.orcamentoPK != null) || (this.orcamentoPK != null && !this.orcamentoPK.equals(other.orcamentoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Orcamento[ orcamentoPK=" + orcamentoPK + " ]";
    }
    
}
