/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Address;

/**
 *
 * @author Gail
 */
public class SubdistrictsAndZipcodes {

    private Subdistricts subdistricts;
    private Zipcodes zipcodes;

    public SubdistrictsAndZipcodes(Subdistricts subdistricts, Zipcodes zipcodes) {
        this.subdistricts = subdistricts;
        this.zipcodes = zipcodes;
    }

    public SubdistrictsAndZipcodes() {
        this.subdistricts = null;
        this.zipcodes = null;
    }

    public Subdistricts getSubdistricts() {
        return subdistricts;
    }

    public void setSubdistricts(Subdistricts subdistricts) {
        this.subdistricts = subdistricts;
    }

    public Zipcodes getZipcodes() {
        return zipcodes;
    }

    public void setZipcodes(Zipcodes zipcodes) {
        this.zipcodes = zipcodes;
    }

    public Integer getSubdistrictId() {
        return subdistricts.getSubdistrictId();
    }

    public void setSubdistrictId(Integer subdistrictId) {
        subdistricts.setSubdistrictId(subdistrictId);
    }

    public String getSubdistrictCode() {
        return subdistricts.getSubdistrictCode();
    }

    public void setSubdistrictCode(String subdistrictCode) {
        subdistricts.setSubdistrictCode(subdistrictCode);
    }

    public String getSubdistrictNameTh() {
        return subdistricts.getSubdistrictNameTh();
    }

    public void setSubdistrictNameTh(String subdistrictNameTh) {
        subdistricts.setSubdistrictNameTh(subdistrictNameTh);
    }

    public String getSubdistrictNameEn() {
        return subdistricts.getSubdistrictNameEn();
    }

    public void setSubdistrictNameEn(String subdistrictNameEn) {
        subdistricts.setSubdistrictNameEn(subdistrictNameEn);
    }

    public int getDistrictId() {
        return subdistricts.getDistrictId();
    }

    public void setDistrictId(int districtId) {
        subdistricts.setDistrictId(districtId);
    }

    public int getProvinceId() {
        return subdistricts.getProvinceId();
    }

    public void setProvinceId(int provinceId) {
        subdistricts.setProvinceId(provinceId);
    }

    public int getGeoId() {
        return subdistricts.getGeoId();
    }

    public void setGeoId(int geoId) {
        subdistricts.setGeoId(geoId);
    }

    public Integer getZipcodeId() {
        return zipcodes.getZipcodeId();
    }

    public void setZipcodeId(Integer zipcodeId) {
        zipcodes.setZipcodeId(zipcodeId);
    }

    public String getZipcode() {
        return zipcodes.getZipcode();
    }

    public void setZipcode(String zipcode) {
        zipcodes.setZipcode(zipcode);
    }

    

}
