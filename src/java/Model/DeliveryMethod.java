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
import javax.persistence.Lob;
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
@Table(name = "deliveryMethod")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DeliveryMethod.findAll", query = "SELECT d FROM DeliveryMethod d")
    , @NamedQuery(name = "DeliveryMethod.findByDeliveryMethodid", query = "SELECT d FROM DeliveryMethod d WHERE d.deliveryMethodid = :deliveryMethodid")
    , @NamedQuery(name = "DeliveryMethod.findByDeliveryMethodname", query = "SELECT d FROM DeliveryMethod d WHERE d.deliveryMethodname = :deliveryMethodname")
    , @NamedQuery(name = "DeliveryMethod.findByDeliveryMethodprice", query = "SELECT d FROM DeliveryMethod d WHERE d.deliveryMethodprice = :deliveryMethodprice")})
public class DeliveryMethod implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "deliveryMethod_id")
    private Integer deliveryMethodid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "deliveryMethod_name")
    private String deliveryMethodname;
    @Basic(optional = false)
    @NotNull
    @Column(name = "deliveryMethod_price")
    private int deliveryMethodprice;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "deliveryMethod_image")
    private byte[] deliveryMethodimage;

    public DeliveryMethod() {
    }

    public DeliveryMethod(Integer deliveryMethodid) {
        this.deliveryMethodid = deliveryMethodid;
    }

    public DeliveryMethod(Integer deliveryMethodid, String deliveryMethodname, int deliveryMethodprice, byte[] deliveryMethodimage) {
        this.deliveryMethodid = deliveryMethodid;
        this.deliveryMethodname = deliveryMethodname;
        this.deliveryMethodprice = deliveryMethodprice;
        this.deliveryMethodimage = deliveryMethodimage;
    }

    public Integer getDeliveryMethodid() {
        return deliveryMethodid;
    }

    public void setDeliveryMethodid(Integer deliveryMethodid) {
        this.deliveryMethodid = deliveryMethodid;
    }

    public String getDeliveryMethodname() {
        return deliveryMethodname;
    }

    public void setDeliveryMethodname(String deliveryMethodname) {
        this.deliveryMethodname = deliveryMethodname;
    }

    public int getDeliveryMethodprice() {
        return deliveryMethodprice;
    }

    public void setDeliveryMethodprice(int deliveryMethodprice) {
        this.deliveryMethodprice = deliveryMethodprice;
    }

    public byte[] getDeliveryMethodimage() {
        return deliveryMethodimage;
    }

    public void setDeliveryMethodimage(byte[] deliveryMethodimage) {
        this.deliveryMethodimage = deliveryMethodimage;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deliveryMethodid != null ? deliveryMethodid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DeliveryMethod)) {
            return false;
        }
        DeliveryMethod other = (DeliveryMethod) object;
        if ((this.deliveryMethodid == null && other.deliveryMethodid != null) || (this.deliveryMethodid != null && !this.deliveryMethodid.equals(other.deliveryMethodid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.DeliveryMethod[ deliveryMethodid=" + deliveryMethodid + " ]";
    }
    
}
