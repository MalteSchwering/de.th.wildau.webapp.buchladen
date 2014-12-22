package de.th.wildau.buchladen;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Jan Gabler
 * @author Malte Schwering
 * @version 0.1
 */
public class LoginManagedBean implements Serializable {
    
    private String username;
    private String password;
    
    public String login() {
        System.out.println("--->"+username+" "+password);
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        try {
            request.login(username, password);
        } catch (ServletException ex) {
            context.addMessage(null, new FacesMessage("Login failed."));
            return "error";
        }
        return "index";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
