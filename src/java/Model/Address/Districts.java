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
@Table(name = "districts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Districts.findAll", query = "SELECT d FROM Districts d")
    , @NamedQuery(name = "Districts.findByDistrictId", query = "SELECT d FROM Districts d WHERE d.districtId = :districtId")
    , @NamedQuery(name = "Districts.findByDistrictCode", query = "SELECT d FROM Districts d WHERE d.districtCode = :districtCode")
    , @NamedQuery(name = "Districts.findByDistrictNameTh", query = "SELECT d FROM Districts d WHERE d.districtNameTh = :districtNameTh")
    , @NamedQuery(name = "Districts.findByDistrictNameEn", query = "SELECT d FROM Districts d WHERE d.districtNameEn = :districtNameEn")
    , @NamedQuery(name = "Districts.findByGeoId", query = "SELECT d FROM Districts d WHERE d.geoId = :geoId")
    , @NamedQuery(name = "Districts.findByProvinceId", query = "SELECT d FROM Districts d WHERE d.provinceId = :provinceId")})
public class Districts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "district_id")
    private Integer districtId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "district_code")
    private String districtCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "district_name_th")
    private String districtNameTh;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "district_name_en")
    private String districtNameEn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "geo_id")
    private int geoId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "province_id")
    private int provinceId;

    public Districts() {
    }

    public Districts(Integer districtId) {
        this.districtId = districtId;
    }

    public Districts(Integer districtId, String districtCode, String districtNameTh, String districtNameEn, int geoId, int provinceId) {
        this.districtId = districtId;
        this.districtCode = districtCode;
        this.districtNameTh = districtNameTh;
        this.districtNameEn = districtNameEn;
        this.geoId = geoId;
        this.provinceId = provinceId;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getDistrictNameTh() {
        return districtNameTh;
    }

    public void setDistrictNameTh(String districtNameTh) {
        this.districtNameTh = districtNameTh;
    }

    public String getDistrictNameEn() {
        return districtNameEn;
    }

    public void setDistrictNameEn(String districtNameEn) {
        this.districtNameEn = districtNameEn;
    }

    public int getGeoId() {
        return geoId;
    }

    public void setGeoId(int geoId) {
        this.geoId = geoId;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (districtId != null ? districtId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Districts)) {
            return false;
        }
        Districts other = (Districts) object;
        if ((this.districtId == null && other.districtId != null) || (this.districtId != null && !this.districtId.equals(other.districtId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Address.Districts[ districtId=" + districtId + " ]";
    }
    
}
