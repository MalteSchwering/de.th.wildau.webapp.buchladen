package de.th.wildau.buchladen;

import de.th.wildau.webapp.buchladen.entities.BookEntity;
import de.th.wildau.webapp.buchladen.facades.BookEntityFacadeRemote;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

/**
 * @author Jan Gabler
 * @author Malte Schwering
 * @version 0.3
 */
public class BookManagedBean implements Serializable {
    
    /**
     * ID des Buches
     */
    private int id;
    
    /**
     * Setzt die ID.
     * @param idValue ID des Buches
     */
    public void setId(int idValue){
        this.id = idValue;
    }
    
    /**
     * Liefert die ID zurück.
     * @return ID des Buches
     */
    public int getId(){
        return this.id;
    }

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
        return bookEntityFacade.find(this.id);
    }
    
    /**
     * Ruft die Detailseite auf
     * @param id des Buch Objekts
     */
    public void showDetail(int id){    
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("detail.xhtml?id="+id);
            
        } catch (IOException ex) {
            Logger.getLogger(BookManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Überprüft ob ein Objekt mit der angegebenen ID existiert
     * @return true wenn Objekt existiert, false sonst
     */
    public boolean isValid(){
        try{
            BookEntity bookEntity= this.getBookEntity();
            return bookEntity != null;    
        }catch (Exception ex){
            return false;
        }
        
    }
    
    /**
     *  Wird beim öffnen der Detail-Page aufgerufen
     */
    public void initDetailPage(){
        System.out.println("BookManagedBean id is: "+this.id);
        
    }
}