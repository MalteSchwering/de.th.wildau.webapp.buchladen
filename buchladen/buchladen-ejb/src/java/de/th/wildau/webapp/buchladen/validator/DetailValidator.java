package de.th.wildau.webapp.buchladen.validator;

import de.th.wildau.webapp.buchladen.entities.BookEntity;
import de.th.wildau.webapp.buchladen.facades.BookEntityFacadeRemote;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * @author Jan Gabler
 * @author Malte Schwering
 * @version 0.3
 */
public class DetailValidator implements Validator {
    
    /**
     * Enterprise Java Bean bookEntityFacade.
     */
    BookEntityFacadeRemote bookEntityFacade = lookupBookEntityFacadeRemote();

    /**
     * Validiert den Wert des Input Elements.
     * @param context FacesContext
     * @param component User Interface Komponente
     * @param value Wert des Input Elements
     * @throws ValidatorException 
     */
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        //int bookEntityId = (int) component.getAttributes().get("bookEntityId");
        int bookEntityId = (int) value;
        BookEntity bookEntity = this.bookEntityFacade.find(bookEntityId);
                
        if(bookEntity == null) {
            FacesMessage facesMessage = new FacesMessage(component.getClientId() + ": Überprüfungsfehler: Buch existiert nicht");
            throw new ValidatorException(facesMessage);
        }
    }

    /**
     * Liefert die Remote bookEntityFacade zurück.
     * @return Remote bookEntityFacade
     */
    private BookEntityFacadeRemote lookupBookEntityFacadeRemote() {
        try {
            Context c = new InitialContext();
            return (BookEntityFacadeRemote) c.lookup("java:global/buchladen/buchladen-ejb/BookEntityFacade!de.th.wildau.webapp.buchladen.facades.BookEntityFacadeRemote");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
