package Model;

import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UserLogin {
    
    private String email;
    private String pwd;
    private Boolean signed;

    public UserLogin() {
        this.email = null;
        this.pwd = null;
        this.signed = null;
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
            Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public String getEmail() {
        return email;
    }

    public Boolean getSigned() {
        return signed;
    }

    public void setSigned(Boolean signed) {
        this.signed = signed;
    }
    
}
