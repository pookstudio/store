/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PokoSystem;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Gail
 */
public class PokoValidate {

    public static PokoValidate util = new PokoValidate();

    private Pattern pattern;
    private Matcher matcher;

    private PokoValidate() {

    }

    public boolean validateEmail(String email) {
        String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
        pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean validateLength(String str, int begin, int end) {
        String REGEX = ".{" + begin + "," + end + "}";
        pattern = Pattern.compile(REGEX);
        matcher = pattern.matcher(str);
        return matcher.matches();
    }

    public boolean validateTelephone(String tel) {
        String REGEX = "^[0-9-+s()]*$";
        pattern = Pattern.compile(REGEX);
        matcher = pattern.matcher(tel);
        if (validateLength(tel, 9, 14)) {
            return matcher.matches();
        }
        return false;
    }

    public int calculateAge(
            LocalDate birthDate,
            LocalDate currentDate) {
        return Period.between(birthDate, currentDate).getYears();
    }

    public boolean validateAge(java.sql.Date birthday, int begin, int end) {
        LocalDate today = LocalDate.now();
        int age = calculateAge(birthday.toLocalDate(), today);
        return (age > --begin && age < ++end);
    }

    public java.sql.Date toDate(String dateString) {
        try {
            java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("dd-MM-yyyy");
            java.util.Date parsed = format.parse(dateString);
            java.sql.Date date = new java.sql.Date(parsed.getTime());
            return date;
        } catch (ParseException ex) {
            Logger.getLogger(PokoValidate.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public java.sql.Date toDateV2(String dateString) {
        try {
            java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy");
            java.time.LocalDate localDate = java.time.LocalDate.parse(dateString, formatter);
            return java.sql.Date.valueOf(localDate);
        } catch (Exception ex) {
            return null;
        }
    }

}
