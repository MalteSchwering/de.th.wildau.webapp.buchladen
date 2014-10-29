/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.th.wildau.buchladen;

import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author Jan
 */
@ManagedBean
@SessionScoped
public class CartManagedBean {
    
    /**
     * Creates a new instance of CartManagedBean
     */
    public CartManagedBean() {
    }
    
    public void add() {
        //...
    }
    
    public int getId() {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext extContext = context.getExternalContext();
        Map<String, String> params = extContext.getRequestParameterMap();
        return Integer.parseInt(params.get("id"));
    }
}
