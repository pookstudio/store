/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

public class DeliveryAddress {

    private int ID;
    private int userID;
    private String address;
    private String provinceName;
    private String districtName;
    private String subdistrictName;
    private String subdistrictCode;
    private String zipcode;

    public DeliveryAddress(
            int ID,
            int userID,
            String address,
            String provinceName,
            String districtName,
            String subdistrictName,
            String subdistrictCode,
            String zipcode
    ) {
        this.ID = ID;
        this.userID = userID;
        this.address = address;
        this.provinceName = provinceName;
        this.districtName = districtName;
        this.subdistrictName = subdistrictName;
        this.subdistrictCode = subdistrictCode;
        this.zipcode = zipcode;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getSubdistrictName() {
        return subdistrictName;
    }

    public void setSubdistrictName(String subdistrictName) {
        this.subdistrictName = subdistrictName;
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

}
