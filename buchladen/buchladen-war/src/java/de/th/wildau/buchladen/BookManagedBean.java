package de.th.wildau.buchladen;

import de.th.wildau.webapp.buchladen.entities.BookEntity;
import de.th.wildau.webapp.buchladen.facades.BookEntityFacadeRemote;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

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
     * Liefert eine Bücker Entität zurück, die über eine ID gesucht wird.
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

}