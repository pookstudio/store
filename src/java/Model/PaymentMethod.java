/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gail
 */
@Entity
@Table(name = "paymentMethod")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PaymentMethod.findAll", query = "SELECT p FROM PaymentMethod p")
    , @NamedQuery(name = "PaymentMethod.findByPaymentMethodid", query = "SELECT p FROM PaymentMethod p WHERE p.paymentMethodid = :paymentMethodid")
    , @NamedQuery(name = "PaymentMethod.findByPaymentMethodnamebank", query = "SELECT p FROM PaymentMethod p WHERE p.paymentMethodnamebank = :paymentMethodnamebank")
    , @NamedQuery(name = "PaymentMethod.findByPaymentMethodaccount", query = "SELECT p FROM PaymentMethod p WHERE p.paymentMethodaccount = :paymentMethodaccount")
    , @NamedQuery(name = "PaymentMethod.findByPaymentMethodnameaccount", query = "SELECT p FROM PaymentMethod p WHERE p.paymentMethodnameaccount = :paymentMethodnameaccount")})
public class PaymentMethod implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "paymentMethod_id")
    private Integer paymentMethodid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "paymentMethod_name_bank")
    private String paymentMethodnamebank;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "paymentMethod_account")
    private String paymentMethodaccount;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "paymentMethod_name_account")
    private String paymentMethodnameaccount;

    public PaymentMethod() {
    }

    public PaymentMethod(Integer paymentMethodid) {
        this.paymentMethodid = paymentMethodid;
    }

    public PaymentMethod(Integer paymentMethodid, String paymentMethodnamebank, String paymentMethodaccount, String paymentMethodnameaccount) {
        this.paymentMethodid = paymentMethodid;
        this.paymentMethodnamebank = paymentMethodnamebank;
        this.paymentMethodaccount = paymentMethodaccount;
        this.paymentMethodnameaccount = paymentMethodnameaccount;
    }

    public Integer getPaymentMethodid() {
        return paymentMethodid;
    }

    public void setPaymentMethodid(Integer paymentMethodid) {
        this.paymentMethodid = paymentMethodid;
    }

    public String getPaymentMethodnamebank() {
        return paymentMethodnamebank;
    }

    public void setPaymentMethodnamebank(String paymentMethodnamebank) {
        this.paymentMethodnamebank = paymentMethodnamebank;
    }

    public String getPaymentMethodaccount() {
        return paymentMethodaccount;
    }

    public void setPaymentMethodaccount(String paymentMethodaccount) {
        this.paymentMethodaccount = paymentMethodaccount;
    }

    public String getPaymentMethodnameaccount() {
        return paymentMethodnameaccount;
    }

    public void setPaymentMethodnameaccount(String paymentMethodnameaccount) {
        this.paymentMethodnameaccount = paymentMethodnameaccount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentMethodid != null ? paymentMethodid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaymentMethod)) {
            return false;
        }
        PaymentMethod other = (PaymentMethod) object;
        if ((this.paymentMethodid == null && other.paymentMethodid != null) || (this.paymentMethodid != null && !this.paymentMethodid.equals(other.paymentMethodid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.PaymentMethod[ paymentMethodid=" + paymentMethodid + " ]";
    }
    
}
