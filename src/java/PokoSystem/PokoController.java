/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PokoSystem;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gail
 */
public class PokoController extends HttpServlet {

    protected HttpServletRequest request;
    protected HttpServletResponse response;
    private PrintWriter out;
    protected PokoError error;

    public PokoController() {
        this.request = null;
        this.response = null;
        this.out = null;
        this.error = new PokoError();
    }

    protected void setController(HttpServletRequest req, HttpServletResponse resp) {
        try {
            this.request = req;
            this.response = resp;
            this.request.setCharacterEncoding("utf-8");
            this.response.setCharacterEncoding("utf-8");
            this.out = response.getWriter();
        } catch (IOException ex) {
            Logger.getLogger(PokoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            setController(req, resp);
            route();
        } catch (ServletException | IOException ex) {
            Logger.getLogger(PokoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void main() {

    }

    protected void view(String page) {
        try {
            request.getRequestDispatcher("/view/" + page + ".jsp").include(request, response);
        } catch (IOException | ServletException ex) {
            forward("/error?errorID=" + error.ErrorView);
        }
    }

    protected void print(Object obj) {
        out.print(obj);
    }

    protected void println(Object obj) {
        out.println(obj);
    }

    protected void forward(String url) {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(PokoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void redirect(String url) {
        try {
            response.sendRedirect(url);
        } catch (IOException ex) {
            Logger.getLogger(PokoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void route() throws ServletException, IOException {
        if (request.getPathInfo() != null) {
            String path = request.getPathInfo();
            String[] parts = path.split("/");
            try {
                if (parts.length > 0) {
                    if (parts.length > 2) {
                        int parameterValue = parts.length - 2;
                        Class[] parameterTypes = new Class[parameterValue];
                        Object[] parameter = new Object[parameterValue];
                        for (int i = 0; i < parameterValue; i++) {
                            parameter[i] = formatType(parts[i + 2]);
                            parameterTypes[i] = parameter[i].getClass();
                        }
                        getClass().getMethod(parts[1], parameterTypes)
                                .invoke(this, (Object[]) parameter);
                    } else {
                        getClass().getMethod(parts[1]).invoke(this);
                    }
                } else {
                    main();
                }
            } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | SecurityException | InvocationTargetException ex) {
                forward("/404");
            }
        } else {
            main();
        }
    }

    private Object formatType(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException ex) {
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException ex) {
        }
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException ex) {
        }
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException ex) {
        }
        return str;
    }

    protected boolean isNull(String str) {
        return str == null;
    }

    protected boolean isEmpty(String str) {
        return str.equals("");
    }

    protected boolean existParameter(String nameOfParameter) {
        return request.getParameterMap().containsKey(nameOfParameter);
    }

    protected Object getParameter(String nameOfParameter) {
        if (existParameter(nameOfParameter) && !"".equals(request.getParameter(nameOfParameter))) {
            return formatType(request.getParameter(nameOfParameter).trim());
        }
        return null;
    }

    protected String getParameterString(String nameOfParameter) {
        if (existParameter(nameOfParameter)) {
            if (formatType(nameOfParameter).getClass() == String.class) {
                return request.getParameter(nameOfParameter).trim();
            }
        }
        return null;
    }

    protected Integer getParameterInteger(String nameOfParameter) {
        if (getParameter(nameOfParameter) != null) {
            return (Integer) getParameter(nameOfParameter);
        }
        return null;
    }

    protected Long getParameterLong(String nameOfParameter) {
        if (getParameter(nameOfParameter) != null) {
            return (Long) getParameter(nameOfParameter);
        }
        return null;
    }

    protected Float getParameterFloat(String nameOfParameter) {
        if (getParameter(nameOfParameter) != null) {
            return (Float) getParameter(nameOfParameter);
        }
        return null;
    }

    protected Double getParameterDouble(String nameOfParameter) {
        if (getParameter(nameOfParameter) != null) {
            return (Double) getParameter(nameOfParameter);
        }
        return null;
    }
    
    protected String getParameterCustomer(String nameOfParameter) {
        if (existParameter(nameOfParameter) && !"".equals(request.getParameter(nameOfParameter))) {
            return request.getParameter(nameOfParameter).trim();
        }
        return null;
    }

    @Override
    public void destroy() {
        super.destroy();
        out.close();
    }

}
