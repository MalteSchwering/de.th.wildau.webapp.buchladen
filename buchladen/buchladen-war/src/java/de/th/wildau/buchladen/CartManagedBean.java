/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.th.wildau.buchladen;

import de.th.wildau.webapp.buchladen.entities.BookEntity;
import de.th.wildau.webapp.buchladen.sessions.CartSessionBeanRemote;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author Jan
 */
//@ManagedBean
//@SessionScoped
public class CartManagedBean implements Serializable {
    @EJB
    private CartSessionBeanRemote cartSessionBean;
    
    /**
     * Creates a new instance of CartManagedBean
     */
    public CartManagedBean() {
    }
    
    public void addBook(int id) {
        this.cartSessionBean.addBook(id);
    }
    
    public void removeBook(int id) {
        this.cartSessionBean.removeBook(id);
    }
    
    public List<BookEntity> getContent() {
        return this.cartSessionBean.getContent();
    }
    
    public int count() {
        return this.cartSessionBean.count();
    }
}
