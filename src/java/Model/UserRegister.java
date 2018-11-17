/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import PokoSystem.PokoModel;
import java.lang.reflect.Field;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gail
 */
public class UserRegister extends PokoModel {

    private String firstname;
    private String lastlame;
    private String email;
    private String password;
    private Integer gender;
    private Date birthday;
    private String telephone;

    public UserRegister() {
        this.firstname = null;
        this.lastlame = null;
        this.email = null;
        this.password = null;
        this.gender = 0;
        this.birthday = null;
        this.telephone = null;
    }

    public boolean isEmpty() throws IllegalAccessException {
        for (Field f : this.getClass().getDeclaredFields()) {
            if (f.get(this) != null) {
                if (f.get(this).equals("")) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isNull() throws IllegalAccessException {
        for (Field f : this.getClass().getDeclaredFields()) {
            if (f.get(this) == null) {
                return true;
            }
        }
        return false;
    }

    public boolean isNullEmpty() {
        try {
            return isNull() || isEmpty();
        } catch (IllegalAccessException ex) {
            Logger.getLogger(UserRegister.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastlame() {
        return lastlame;
    }

    public void setLastlame(String lastlame) {
        this.lastlame = lastlame;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

}
