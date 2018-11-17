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
@Table(name = "productsType")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductsType.findAll", query = "SELECT p FROM ProductsType p")
    , @NamedQuery(name = "ProductsType.findByProductTypeid", query = "SELECT p FROM ProductsType p WHERE p.productTypeid = :productTypeid")
    , @NamedQuery(name = "ProductsType.findByProductTypename", query = "SELECT p FROM ProductsType p WHERE p.productTypename = :productTypename")
    , @NamedQuery(name = "ProductsType.findByProductTypeSubset", query = "SELECT p FROM ProductsType p WHERE p.productTypeSubset = :productTypeSubset")})
public class ProductsType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "productType_id")
    private Integer productTypeid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "productType_name")
    private String productTypename;
    @Column(name = "productType_Subset")
    private Integer productTypeSubset;

    public ProductsType() {
    }

    public ProductsType(Integer productTypeid) {
        this.productTypeid = productTypeid;
    }

    public ProductsType(Integer productTypeid, String productTypename) {
        this.productTypeid = productTypeid;
        this.productTypename = productTypename;
    }

    public Integer getProductTypeid() {
        return productTypeid;
    }

    public void setProductTypeid(Integer productTypeid) {
        this.productTypeid = productTypeid;
    }

    public String getProductTypename() {
        return productTypename;
    }

    public void setProductTypename(String productTypename) {
        this.productTypename = productTypename;
    }

    public Integer getProductTypeSubset() {
        return productTypeSubset;
    }

    public void setProductTypeSubset(Integer productTypeSubset) {
        this.productTypeSubset = productTypeSubset;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productTypeid != null ? productTypeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductsType)) {
            return false;
        }
        ProductsType other = (ProductsType) object;
        if ((this.productTypeid == null && other.productTypeid != null) || (this.productTypeid != null && !this.productTypeid.equals(other.productTypeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.ProductsType[ productTypeid=" + productTypeid + " ]";
    }
    
}
