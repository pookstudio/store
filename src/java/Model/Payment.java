/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gail
 */
@Entity
@Table(name = "payment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Payment.findAll", query = "SELECT p FROM Payment p")
    , @NamedQuery(name = "Payment.findByPaymentId", query = "SELECT p FROM Payment p WHERE p.paymentId = :paymentId")
    , @NamedQuery(name = "Payment.findByPaymentDatetime", query = "SELECT p FROM Payment p WHERE p.paymentDatetime = :paymentDatetime")
    , @NamedQuery(name = "Payment.findByPaymentAmount", query = "SELECT p FROM Payment p WHERE p.paymentAmount = :paymentAmount")
    , @NamedQuery(name = "Payment.findByOrderId", query = "SELECT p FROM Payment p WHERE p.orderId = :orderId")
    , @NamedQuery(name = "Payment.findByPaymentMethodid", query = "SELECT p FROM Payment p WHERE p.paymentMethodid = :paymentMethodid")
    , @NamedQuery(name = "Payment.findByInformDatetime", query = "SELECT p FROM Payment p WHERE p.informDatetime = :informDatetime")})
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "payment_id")
    private Integer paymentId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "payment_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paymentDatetime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "payment_amount")
    private float paymentAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "order_id")
    private int orderId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "paymentMethod_id")
    private int paymentMethodid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "inform_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date informDatetime;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "payment_image")
    private byte[] paymentImage;

    public Payment() {
    }

    public Payment(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public Payment(Integer paymentId, Date paymentDatetime, float paymentAmount, int orderId, int paymentMethodid, Date informDatetime, byte[] paymentImage) {
        this.paymentId = paymentId;
        this.paymentDatetime = paymentDatetime;
        this.paymentAmount = paymentAmount;
        this.orderId = orderId;
        this.paymentMethodid = paymentMethodid;
        this.informDatetime = informDatetime;
        this.paymentImage = paymentImage;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public Date getPaymentDatetime() {
        return paymentDatetime;
    }

    public void setPaymentDatetime(Date paymentDatetime) {
        this.paymentDatetime = paymentDatetime;
    }

    public float getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(float paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getPaymentMethodid() {
        return paymentMethodid;
    }

    public void setPaymentMethodid(int paymentMethodid) {
        this.paymentMethodid = paymentMethodid;
    }

    public Date getInformDatetime() {
        return informDatetime;
    }

    public void setInformDatetime(Date informDatetime) {
        this.informDatetime = informDatetime;
    }

    public byte[] getPaymentImage() {
        return paymentImage;
    }

    public void setPaymentImage(byte[] paymentImage) {
        this.paymentImage = paymentImage;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentId != null ? paymentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Payment)) {
            return false;
        }
        Payment other = (Payment) object;
        if ((this.paymentId == null && other.paymentId != null) || (this.paymentId != null && !this.paymentId.equals(other.paymentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Payment[ paymentId=" + paymentId + " ]";
    }
    
}
