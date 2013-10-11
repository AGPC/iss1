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
public class OrcamentoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idOrcamento")
    private int idOrcamento;
    @Basic(optional = false)
    @Column(name = "formaPagamento")
    private String formaPagamento;

    public OrcamentoPK() {
    }

    public OrcamentoPK(int idOrcamento, String formaPagamento) {
        this.idOrcamento = idOrcamento;
        this.formaPagamento = formaPagamento;
    }

    public int getIdOrcamento() {
        return idOrcamento;
    }

    public void setIdOrcamento(int idOrcamento) {
        this.idOrcamento = idOrcamento;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idOrcamento;
        hash += (formaPagamento != null ? formaPagamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrcamentoPK)) {
            return false;
        }
        OrcamentoPK other = (OrcamentoPK) object;
        if (this.idOrcamento != other.idOrcamento) {
            return false;
        }
        if ((this.formaPagamento == null && other.formaPagamento != null) || (this.formaPagamento != null && !this.formaPagamento.equals(other.formaPagamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.OrcamentoPK[ idOrcamento=" + idOrcamento + ", formaPagamento=" + formaPagamento + " ]";
    }
    
}
