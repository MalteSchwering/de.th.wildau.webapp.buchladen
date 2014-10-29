/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.th.wildau.buchladen;

import de.th.wildau.webapp.buchladen.entities.BookEntity;
import de.th.wildau.webapp.buchladen.facades.BookEntityFacadeRemote;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author Jan
 */
public class BookManagedBean implements Serializable {
    @EJB
    private BookEntityFacadeRemote bookEntityFacade;
    

    /**
     * Creates a new instance of BookManagedBean
     */
    public BookManagedBean() {
    }
    
    public List<BookEntity> getBookEntities() {
        return bookEntityFacade.findAll();
    }
    
    public BookEntity getBookEntity() {
        return bookEntityFacade.find(this.getId());
    }
    
    public int getId() {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext extContext = context.getExternalContext();
        Map<String, String> params = extContext.getRequestParameterMap();
        return Integer.parseInt(params.get("id"));
    }
    
}
