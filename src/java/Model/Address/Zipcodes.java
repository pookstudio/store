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
@Table(name = "zipcodes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zipcodes.findAll", query = "SELECT z FROM Zipcodes z")
    , @NamedQuery(name = "Zipcodes.findByZipcodeId", query = "SELECT z FROM Zipcodes z WHERE z.zipcodeId = :zipcodeId")
    , @NamedQuery(name = "Zipcodes.findBySubdistrictCode", query = "SELECT z FROM Zipcodes z WHERE z.subdistrictCode = :subdistrictCode")
    , @NamedQuery(name = "Zipcodes.findByZipcode", query = "SELECT z FROM Zipcodes z WHERE z.zipcode = :zipcode")})
public class Zipcodes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "zipcode_id")
    private Integer zipcodeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "subdistrict_code")
    private String subdistrictCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "zipcode")
    private String zipcode;

    public Zipcodes() {
    }

    public Zipcodes(Integer zipcodeId) {
        this.zipcodeId = zipcodeId;
    }

    public Zipcodes(Integer zipcodeId, String subdistrictCode, String zipcode) {
        this.zipcodeId = zipcodeId;
        this.subdistrictCode = subdistrictCode;
        this.zipcode = zipcode;
    }

    public Integer getZipcodeId() {
        return zipcodeId;
    }

    public void setZipcodeId(Integer zipcodeId) {
        this.zipcodeId = zipcodeId;
    }

    public String getSubdistrictCode() {
        return subdistrictCode;
    }

    public void setSubdistrictCode(String subdistrictCode) {
        this.subdistrictCode = subdistrictCode;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (zipcodeId != null ? zipcodeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zipcodes)) {
            return false;
        }
        Zipcodes other = (Zipcodes) object;
        if ((this.zipcodeId == null && other.zipcodeId != null) || (this.zipcodeId != null && !this.zipcodeId.equals(other.zipcodeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Address.Zipcodes[ zipcodeId=" + zipcodeId + " ]";
    }
    
}
