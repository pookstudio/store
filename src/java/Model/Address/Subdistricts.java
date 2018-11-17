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
@Table(name = "subdistricts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subdistricts.findAll", query = "SELECT s FROM Subdistricts s")
    , @NamedQuery(name = "Subdistricts.findBySubdistrictId", query = "SELECT s FROM Subdistricts s WHERE s.subdistrictId = :subdistrictId")
    , @NamedQuery(name = "Subdistricts.findBySubdistrictCode", query = "SELECT s FROM Subdistricts s WHERE s.subdistrictCode = :subdistrictCode")
    , @NamedQuery(name = "Subdistricts.findBySubdistrictNameTh", query = "SELECT s FROM Subdistricts s WHERE s.subdistrictNameTh = :subdistrictNameTh")
    , @NamedQuery(name = "Subdistricts.findBySubdistrictNameEn", query = "SELECT s FROM Subdistricts s WHERE s.subdistrictNameEn = :subdistrictNameEn")
    , @NamedQuery(name = "Subdistricts.findByDistrictId", query = "SELECT s FROM Subdistricts s WHERE s.districtId = :districtId")
    , @NamedQuery(name = "Subdistricts.findByProvinceId", query = "SELECT s FROM Subdistricts s WHERE s.provinceId = :provinceId")
    , @NamedQuery(name = "Subdistricts.findByGeoId", query = "SELECT s FROM Subdistricts s WHERE s.geoId = :geoId")})
public class Subdistricts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "subdistrict_id")
    private Integer subdistrictId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "subdistrict_code")
    private String subdistrictCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "subdistrict_name_th")
    private String subdistrictNameTh;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "subdistrict_name_en")
    private String subdistrictNameEn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "district_id")
    private int districtId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "province_id")
    private int provinceId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "geo_id")
    private int geoId;

    public Subdistricts() {
    }

    public Subdistricts(Integer subdistrictId) {
        this.subdistrictId = subdistrictId;
    }

    public Subdistricts(Integer subdistrictId, String subdistrictCode, String subdistrictNameTh, String subdistrictNameEn, int districtId, int provinceId, int geoId) {
        this.subdistrictId = subdistrictId;
        this.subdistrictCode = subdistrictCode;
        this.subdistrictNameTh = subdistrictNameTh;
        this.subdistrictNameEn = subdistrictNameEn;
        this.districtId = districtId;
        this.provinceId = provinceId;
        this.geoId = geoId;
    }

    public Integer getSubdistrictId() {
        return subdistrictId;
    }

    public void setSubdistrictId(Integer subdistrictId) {
        this.subdistrictId = subdistrictId;
    }

    public String getSubdistrictCode() {
        return subdistrictCode;
    }

    public void setSubdistrictCode(String subdistrictCode) {
        this.subdistrictCode = subdistrictCode;
    }

    public String getSubdistrictNameTh() {
        return subdistrictNameTh;
    }

    public void setSubdistrictNameTh(String subdistrictNameTh) {
        this.subdistrictNameTh = subdistrictNameTh;
    }

    public String getSubdistrictNameEn() {
        return subdistrictNameEn;
    }

    public void setSubdistrictNameEn(String subdistrictNameEn) {
        this.subdistrictNameEn = subdistrictNameEn;
    }

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public int getGeoId() {
        return geoId;
    }

    public void setGeoId(int geoId) {
        this.geoId = geoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subdistrictId != null ? subdistrictId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subdistricts)) {
            return false;
        }
        Subdistricts other = (Subdistricts) object;
        if ((this.subdistrictId == null && other.subdistrictId != null) || (this.subdistrictId != null && !this.subdistrictId.equals(other.subdistrictId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Address.Subdistricts[ subdistrictId=" + subdistrictId + " ]";
    }
    
}
