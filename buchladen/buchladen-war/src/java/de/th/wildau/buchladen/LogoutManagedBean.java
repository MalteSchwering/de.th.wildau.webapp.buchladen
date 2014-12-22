package de.th.wildau.buchladen;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Jan Gabler
 * @author Malte Schwering
 * @version 0.1
 */
public class LogoutManagedBean {
    
    /**
     * Meldet den Benutzer ab.
     */
    public void logout() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        try {
            request.logout();
        } catch (ServletException ex) {
            context.addMessage(null, new FacesMessage("Logout failed."));
        }
    }
    
}
