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
import javax.ejb.EJB;

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
    
}
