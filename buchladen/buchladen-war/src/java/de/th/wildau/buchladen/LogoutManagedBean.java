package de.th.wildau.buchladen;

import javax.faces.context.FacesContext;

/**
 * @author Jan Gabler
 * @author Malte Schwering
 * @version 0.1
 */
public class LogoutManagedBean {
    
    /**
     * Setzt die Session des Benutzers ungültig und navigiert anschließend zurück Logout Seite.
     * @return Seite zu der anschließend navigiert werden soll
     */
    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "logout";
    }
    
}
