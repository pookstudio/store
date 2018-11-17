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
@Table(name = "ordersDetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdersDetail.findAll", query = "SELECT o FROM OrdersDetail o")
    , @NamedQuery(name = "OrdersDetail.findByOrderDetailid", query = "SELECT o FROM OrdersDetail o WHERE o.orderDetailid = :orderDetailid")
    , @NamedQuery(name = "OrdersDetail.findByOrderDetailaddress", query = "SELECT o FROM OrdersDetail o WHERE o.orderDetailaddress = :orderDetailaddress")
    , @NamedQuery(name = "OrdersDetail.findByDeliveryAddressid", query = "SELECT o FROM OrdersDetail o WHERE o.deliveryAddressid = :deliveryAddressid")
    , @NamedQuery(name = "OrdersDetail.findByDeliveryMethodid", query = "SELECT o FROM OrdersDetail o WHERE o.deliveryMethodid = :deliveryMethodid")
    , @NamedQuery(name = "OrdersDetail.findByOrderId", query = "SELECT o FROM OrdersDetail o WHERE o.orderId = :orderId")})
public class OrdersDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "orderDetail_id")
    private Integer orderDetailid;
    @Size(max = 255)
    @Column(name = "orderDetail_address")
    private String orderDetailaddress;
    @Basic(optional = false)
    @NotNull
    @Column(name = "deliveryAddress_id")
    private int deliveryAddressid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "deliveryMethod_id")
    private int deliveryMethodid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "order_id")
    private int orderId;

    public OrdersDetail() {
    }

    public OrdersDetail(Integer orderDetailid) {
        this.orderDetailid = orderDetailid;
    }

    public OrdersDetail(Integer orderDetailid, int deliveryAddressid, int deliveryMethodid, int orderId) {
        this.orderDetailid = orderDetailid;
        this.deliveryAddressid = deliveryAddressid;
        this.deliveryMethodid = deliveryMethodid;
        this.orderId = orderId;
    }

    public Integer getOrderDetailid() {
        return orderDetailid;
    }

    public void setOrderDetailid(Integer orderDetailid) {
        this.orderDetailid = orderDetailid;
    }

    public String getOrderDetailaddress() {
        return orderDetailaddress;
    }

    public void setOrderDetailaddress(String orderDetailaddress) {
        this.orderDetailaddress = orderDetailaddress;
    }

    public int getDeliveryAddressid() {
        return deliveryAddressid;
    }

    public void setDeliveryAddressid(int deliveryAddressid) {
        this.deliveryAddressid = deliveryAddressid;
    }

    public int getDeliveryMethodid() {
        return deliveryMethodid;
    }

    public void setDeliveryMethodid(int deliveryMethodid) {
        this.deliveryMethodid = deliveryMethodid;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderDetailid != null ? orderDetailid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdersDetail)) {
            return false;
        }
        OrdersDetail other = (OrdersDetail) object;
        if ((this.orderDetailid == null && other.orderDetailid != null) || (this.orderDetailid != null && !this.orderDetailid.equals(other.orderDetailid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.OrdersDetail[ orderDetailid=" + orderDetailid + " ]";
    }
    
}
