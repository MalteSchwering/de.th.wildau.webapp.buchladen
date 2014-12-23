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
    
    /**
     * Der Benutzername des Anwenders.
     */
    private String username;
    
    /**
     * Das Passwort des Anwenders.
     */
    private String password;
    
    /**
     * Meldet den Benutzer an.
     * @return Zielseite nach der Anmeldung
     */
    public String login() {
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
    
    /**
     * Liefert den Benutzernamen zurück.
     * @return Benutzername
     */
    public String getUsername() {
        return username;
    }
    
    /**
     * Setzt den Benutzername.
     * @param username Benutzername
     */
    public void setUsername(String username) {
        this.username = username;
    }
    
    /**
     * Liefert das Passwort zurück.
     * @return Passwort
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * Setzt das Passwort.
     * @param password Passwort
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
}
