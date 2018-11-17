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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gail
 */
@Entity
@Table(name = "ordersItem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdersItem.findAll", query = "SELECT o FROM OrdersItem o")
    , @NamedQuery(name = "OrdersItem.findByOrderItemid", query = "SELECT o FROM OrdersItem o WHERE o.orderItemid = :orderItemid")
    , @NamedQuery(name = "OrdersItem.findByQuantity", query = "SELECT o FROM OrdersItem o WHERE o.quantity = :quantity")
    , @NamedQuery(name = "OrdersItem.findByOrderId", query = "SELECT o FROM OrdersItem o WHERE o.orderId = :orderId")
    , @NamedQuery(name = "OrdersItem.findByProductId", query = "SELECT o FROM OrdersItem o WHERE o.productId = :productId")})
public class OrdersItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "orderItem_id")
    private Integer orderItemid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private int quantity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "order_id")
    private int orderId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "product_id")
    private int productId;

    public OrdersItem() {
    }

    public OrdersItem(Integer orderItemid) {
        this.orderItemid = orderItemid;
    }

    public OrdersItem(Integer orderItemid, int quantity, int orderId, int productId) {
        this.orderItemid = orderItemid;
        this.quantity = quantity;
        this.orderId = orderId;
        this.productId = productId;
    }

    public Integer getOrderItemid() {
        return orderItemid;
    }

    public void setOrderItemid(Integer orderItemid) {
        this.orderItemid = orderItemid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderItemid != null ? orderItemid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdersItem)) {
            return false;
        }
        OrdersItem other = (OrdersItem) object;
        if ((this.orderItemid == null && other.orderItemid != null) || (this.orderItemid != null && !this.orderItemid.equals(other.orderItemid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.OrdersItem[ orderItemid=" + orderItemid + " ]";
    }
    
}
