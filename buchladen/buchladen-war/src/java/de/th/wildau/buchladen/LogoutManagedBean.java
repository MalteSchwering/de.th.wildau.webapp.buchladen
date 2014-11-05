package de.th.wildau.buchladen;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
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
