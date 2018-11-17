/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Address;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "geography")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Geography.findAll", query = "SELECT g FROM Geography g")
    , @NamedQuery(name = "Geography.findByGeoId", query = "SELECT g FROM Geography g WHERE g.geoId = :geoId")
    , @NamedQuery(name = "Geography.findByGeoName", query = "SELECT g FROM Geography g WHERE g.geoName = :geoName")})
public class Geography implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "geo_id")
    private Integer geoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "geo_name")
    private String geoName;

    public Geography() {
    }

    public Geography(Integer geoId) {
        this.geoId = geoId;
    }

    public Geography(Integer geoId, String geoName) {
        this.geoId = geoId;
        this.geoName = geoName;
    }

    public Integer getGeoId() {
        return geoId;
    }

    public void setGeoId(Integer geoId) {
        this.geoId = geoId;
    }

    public String getGeoName() {
        return geoName;
    }

    public void setGeoName(String geoName) {
        this.geoName = geoName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (geoId != null ? geoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Geography)) {
            return false;
        }
        Geography other = (Geography) object;
        if ((this.geoId == null && other.geoId != null) || (this.geoId != null && !this.geoId.equals(other.geoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Address.Geography[ geoId=" + geoId + " ]";
    }
    
}
