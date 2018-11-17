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
@Table(name = "productsDetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductsDetail.findAll", query = "SELECT p FROM ProductsDetail p")
    , @NamedQuery(name = "ProductsDetail.findByProductsDetailid", query = "SELECT p FROM ProductsDetail p WHERE p.productsDetailid = :productsDetailid")
    , @NamedQuery(name = "ProductsDetail.findByProductsDetaildate", query = "SELECT p FROM ProductsDetail p WHERE p.productsDetaildate = :productsDetaildate")
    , @NamedQuery(name = "ProductsDetail.findByProductId", query = "SELECT p FROM ProductsDetail p WHERE p.productId = :productId")})
public class ProductsDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "productsDetail_id")
    private Integer productsDetailid;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "productsDetail_image")
    private byte[] productsDetailimage;
    @Basic(optional = false)
    @NotNull
    @Column(name = "productsDetail_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date productsDetaildate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "product_id")
    private int productId;

    public ProductsDetail() {
    }

    public ProductsDetail(Integer productsDetailid) {
        this.productsDetailid = productsDetailid;
    }

    public ProductsDetail(Integer productsDetailid, byte[] productsDetailimage, Date productsDetaildate, int productId) {
        this.productsDetailid = productsDetailid;
        this.productsDetailimage = productsDetailimage;
        this.productsDetaildate = productsDetaildate;
        this.productId = productId;
    }

    public Integer getProductsDetailid() {
        return productsDetailid;
    }

    public void setProductsDetailid(Integer productsDetailid) {
        this.productsDetailid = productsDetailid;
    }

    public byte[] getProductsDetailimage() {
        return productsDetailimage;
    }

    public void setProductsDetailimage(byte[] productsDetailimage) {
        this.productsDetailimage = productsDetailimage;
    }

    public Date getProductsDetaildate() {
        return productsDetaildate;
    }

    public void setProductsDetaildate(Date productsDetaildate) {
        this.productsDetaildate = productsDetaildate;
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
        hash += (productsDetailid != null ? productsDetailid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductsDetail)) {
            return false;
        }
        ProductsDetail other = (ProductsDetail) object;
        if ((this.productsDetailid == null && other.productsDetailid != null) || (this.productsDetailid != null && !this.productsDetailid.equals(other.productsDetailid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.ProductsDetail[ productsDetailid=" + productsDetailid + " ]";
    }
    
}
