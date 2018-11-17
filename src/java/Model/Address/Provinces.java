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
@Table(name = "provinces")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Provinces.findAll", query = "SELECT p FROM Provinces p")
    , @NamedQuery(name = "Provinces.findByProvinceId", query = "SELECT p FROM Provinces p WHERE p.provinceId = :provinceId")
    , @NamedQuery(name = "Provinces.findByProvinceCode", query = "SELECT p FROM Provinces p WHERE p.provinceCode = :provinceCode")
    , @NamedQuery(name = "Provinces.findByProvinceNameTh", query = "SELECT p FROM Provinces p WHERE p.provinceNameTh = :provinceNameTh")
    , @NamedQuery(name = "Provinces.findByProvinceNameEn", query = "SELECT p FROM Provinces p WHERE p.provinceNameEn = :provinceNameEn")
    , @NamedQuery(name = "Provinces.findByGeoId", query = "SELECT p FROM Provinces p WHERE p.geoId = :geoId")})
public class Provinces implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "province_id")
    private Integer provinceId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "province_code")
    private String provinceCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "province_name_th")
    private String provinceNameTh;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "province_name_en")
    private String provinceNameEn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "geo_id")
    private int geoId;

    public Provinces() {
    }

    public Provinces(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Provinces(Integer provinceId, String provinceCode, String provinceNameTh, String provinceNameEn, int geoId) {
        this.provinceId = provinceId;
        this.provinceCode = provinceCode;
        this.provinceNameTh = provinceNameTh;
        this.provinceNameEn = provinceNameEn;
        this.geoId = geoId;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getProvinceNameTh() {
        return provinceNameTh;
    }

    public void setProvinceNameTh(String provinceNameTh) {
        this.provinceNameTh = provinceNameTh;
    }

    public String getProvinceNameEn() {
        return provinceNameEn;
    }

    public void setProvinceNameEn(String provinceNameEn) {
        this.provinceNameEn = provinceNameEn;
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
        hash += (provinceId != null ? provinceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Provinces)) {
            return false;
        }
        Provinces other = (Provinces) object;
        if ((this.provinceId == null && other.provinceId != null) || (this.provinceId != null && !this.provinceId.equals(other.provinceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Address.Provinces[ provinceId=" + provinceId + " ]";
    }
    
}
