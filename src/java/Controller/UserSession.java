/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.User;
import Model.UserLogin;
import Service.UserService;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Gail
 */
public class UserSession {

    public User user;
    protected HttpSession session;
    protected HttpServletRequest request;
    protected HttpServletResponse response;

    public UserSession() {
        this.user = null;
        this.session = null;
        this.request = null;
    }

    public UserSession(HttpServletRequest request, HttpServletResponse response) {
        this.user = null;
        this.request = request;
        this.response = response;
        isCookie();
        session = request.getSession(false);
        if (session != null && user == null) {
            user = (User) session.getAttribute("user");
        }
    }

    public boolean isMember() {
        return user != null;
    }

    public void setUser(User user) {
        this.user = user;
        if (this.user != null) {
            setSession("user", this.user);
        }
    }

    public User getUser() {
        return user;
    }

    public void setSession(String nameSession, Object value) {
        session = request.getSession();
        session.setAttribute(nameSession, value);
    }

    public Object getSession(String nameSession) {
        return session.getAttribute(nameSession);
    }

    public void clear() {
        if (session != null) {
            session.invalidate();
        }
        if (user != null) {
            user = null;
        }
    }

    public void isCookie() {
        Cookie[] cookies = request.getCookies();
        UserLogin userLogin = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("codetomEmail")) {
                    if (userLogin == null) {
                        userLogin = new UserLogin();
                    }
                    userLogin.setEmail(cookie.getValue());
                    userLogin.setSigned(true);
                } else if (cookie.getName().equals("codetomPassword")) {
                    if (userLogin == null) {
                        userLogin = new UserLogin();
                    }
                    userLogin.setPwd(cookie.getValue());
                }
            }
        }
        if (userLogin != null) {
                UserService userService = new UserService();
                setUser(userService.validateUser(userLogin.getEmail(), userLogin.getPwd()));
                if (isMember()) {
                    if (userLogin.getSigned()) {
                        Cookie cEmail = new Cookie("codetomEmail", userLogin.getEmail());
                        Cookie cPassword = new Cookie("codetomPassword", userLogin.getPwd());
                        cEmail.setPath("/");
                        cPassword.setPath("/");
                        cEmail.setMaxAge(60 * 60 * 24 * Config.COOKIE_DAYS);
                        cPassword.setMaxAge(60 * 60 * 24 * Config.COOKIE_DAYS);
                        response.addCookie(cEmail);
                        response.addCookie(cPassword);
                    }
                }
            }
    }

    public String getFirstname() {
        return user.getFirstname();
    }

    public void setFirstname(String firstname) {
        user.setFirstname(firstname);
    }

    public Integer getID() {
        return user.getID();
    }

    public void setID(Integer ID) {
        user.setID(ID);
    }

    public String getEmail() {
        return user.getEmail();
    }

    public void setEmail(String email) {
        user.setEmail(email);
    }

    public int getLevel() {
        return user.getLevel();
    }

}
