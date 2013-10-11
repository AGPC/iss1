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
@Table(name = "vendedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vendedor.findAll", query = "SELECT v FROM Vendedor v"),
    @NamedQuery(name = "Vendedor.findByIdVendedor", query = "SELECT v FROM Vendedor v WHERE v.idVendedor = :idVendedor"),
    @NamedQuery(name = "Vendedor.findByNome", query = "SELECT v FROM Vendedor v WHERE v.nome = :nome"),
    @NamedQuery(name = "Vendedor.findByTelefone", query = "SELECT v FROM Vendedor v WHERE v.telefone = :telefone"),
    @NamedQuery(name = "Vendedor.findBySenha", query = "SELECT v FROM Vendedor v WHERE v.senha = :senha"),
    @NamedQuery(name = "Vendedor.findByLogin", query = "SELECT v FROM Vendedor v WHERE v.login = :login"),
    @NamedQuery(name = "Vendedor.findByCpf", query = "SELECT v FROM Vendedor v WHERE v.cpf = :cpf")})
public class Vendedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idVendedor")
    private Integer idVendedor;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "telefone")
    private String telefone;
    @Basic(optional = false)
    @Column(name = "senha")
    private String senha;
    @Basic(optional = false)
    @Column(name = "login")
    private String login;
    @Basic(optional = false)
    @Column(name = "cpf")
    private String cpf;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vendedoridVendedor")
    private Collection<Orcamento> orcamentoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vendedoridVendedor")
    private Collection<Venda> vendaCollection;

    public Vendedor() {
    }

    public Vendedor(Integer idVendedor) {
        this.idVendedor = idVendedor;
    }

    public Vendedor(Integer idVendedor, String nome, String telefone, String senha, String login, String cpf) {
        this.idVendedor = idVendedor;
        this.nome = nome;
        this.telefone = telefone;
        this.senha = senha;
        this.login = login;
        this.cpf = cpf;
    }

    public Integer getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Integer idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @XmlTransient
    public Collection<Orcamento> getOrcamentoCollection() {
        return orcamentoCollection;
    }

    public void setOrcamentoCollection(Collection<Orcamento> orcamentoCollection) {
        this.orcamentoCollection = orcamentoCollection;
    }

    @XmlTransient
    public Collection<Venda> getVendaCollection() {
        return vendaCollection;
    }

    public void setVendaCollection(Collection<Venda> vendaCollection) {
        this.vendaCollection = vendaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVendedor != null ? idVendedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendedor)) {
            return false;
        }
        Vendedor other = (Vendedor) object;
        if ((this.idVendedor == null && other.idVendedor != null) || (this.idVendedor != null && !this.idVendedor.equals(other.idVendedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Vendedor[ idVendedor=" + idVendedor + " ]";
    }
    
}
