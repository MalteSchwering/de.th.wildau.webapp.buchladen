package de.th.wildau.buchladen;

import de.th.wildau.webapp.buchladen.entities.RegisteredUserEntity;
import de.th.wildau.webapp.buchladen.facades.RegisteredUserEntityFacadeRemote;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author Jan Gabler
 * @author Malte Schwering
 * @version 0.1
 */
public class LoginManagedBean implements Serializable {
    
    /**
     * Enterprise Java Bean registeredUserEntityFacade mit einem Remote Interface.
     */
    @EJB
    private RegisteredUserEntityFacadeRemote registeredUserEntityFacade;
    
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
            return "login";
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
        RegisteredUserEntity registeredUserEntity = registeredUserEntityFacade.findByEmailAddress(this.username);
        if(registeredUserEntity != null) {
            String salt = registeredUserEntity.getSalt();
            String pepper = "DeR$uLtImAtIvE%pEpPeR";
            String part1 = password.substring(0, 4);
            String part2 = password.substring(4);
            String passwordWithSaltAndPepper = part1.concat(pepper).concat(part2).concat(salt);
            this.password = passwordWithSaltAndPepper;
        }
        else {
            this.password = password;
        }
    }
    
}
