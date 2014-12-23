package de.th.wildau.buchladen;

import de.th.wildau.webapp.buchladen.entities.BookEntity;
import de.th.wildau.webapp.buchladen.facades.BookEntityFacadeRemote;
import java.io.IOException;
import java.io.Serializable;
import java.lang.ProcessBuilder.Redirect;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 * @author Jan Gabler
 * @author Malte Schwering
 * @version 0.1
 */
public class BookManagedBean implements Serializable {

    /**
     * Enterprise Java Bean bookEntityFacade mit einem Remote Interface.
     */
    @EJB
    private BookEntityFacadeRemote bookEntityFacade;

    /**
     * Liefert eine Liste aller Bücher Entitäten zurück.
     * @return Liste vom Typ BookEntity
     */
    public List<BookEntity> getBookEntities() {
        return bookEntityFacade.findAll();
    }

    /**
     * Liefert eine Bücher Entität zurück, die über eine ID gesucht wird.
     * @return BookEntity
     */
    public BookEntity getBookEntity() {
        return bookEntityFacade.find(this.getId());
    }

    /**
     * Liefert den Parameter 'id' des GET-Request zurück.
     * @return GET-Request Parameter 'id'
     */
    public int getId() {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext extContext = context.getExternalContext();
        Map<String, String> params = extContext.getRequestParameterMap();
        return Integer.parseInt(params.get("id"));
    }
    
    
    int bookDetailId;
    public void showDetail(){
               
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("detail.xhtml");
            
            ExternalContext redirect= FacesContext.getCurrentInstance().getExternalContext();
        } catch (IOException ex) {
            Logger.getLogger(BookManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
