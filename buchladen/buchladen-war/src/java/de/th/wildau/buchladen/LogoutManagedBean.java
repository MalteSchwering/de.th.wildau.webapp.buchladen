/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.th.wildau.buchladen;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Jan
 */
@ManagedBean
@SessionScoped
public class LogoutManagedBean {

    /**
     * Creates a new instance of LogoutManagedBean
     */
    public LogoutManagedBean() {
    }
    
    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "logout";
    }
    
}
