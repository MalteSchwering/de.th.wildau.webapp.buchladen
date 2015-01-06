package de.th.wildau.buchladen;

import de.th.wildau.webapp.buchladen.entities.BookingOrderDetailEntity;
import de.th.wildau.webapp.buchladen.entities.BookingOrderEntity;
import de.th.wildau.webapp.buchladen.entities.RegisteredUserEntity;
import de.th.wildau.webapp.buchladen.facades.BookingOrderDetailEntityFacadeRemote;
import de.th.wildau.webapp.buchladen.facades.BookingOrderEntityFacadeRemote;
import de.th.wildau.webapp.buchladen.facades.RegisteredUserEntityFacadeRemote;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

/**
 * @author Jan Gabler
 * @author Malte Schwering
 * @version 0.3
 */
public class OrdersManagedBean implements Serializable {
    
    /**
     * Enterprise Java Bean registeredUserEntityFacade mit einem Remote Interface.
     */
    @EJB
    private RegisteredUserEntityFacadeRemote registeredUserEntityFacade;
    
    /**
     * Enterprise Java Bean bookingOrderEntityFacade mit einem Remote Interface.
     */
    @EJB
    private BookingOrderEntityFacadeRemote bookingOrderEntityFacade;
    
    /**
     * Enterprise Java Bean bookingOrderDetailEntityFacade mit einem Remote Interface.
     */
    @EJB
    private BookingOrderDetailEntityFacadeRemote bookingOrderDetailEntityFacade;
    
    /**
     * Liefert eine Liste aller Bücher Bestellungen eines Benutzers zurück.
     * @return Liste vom Typ BookingOrderEntity
     */
    public List<BookingOrderEntity> getBookingOrderEntitiesFromUser() {
        String username = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
        RegisteredUserEntity registeredUserEntity = registeredUserEntityFacade.findByEmailAddress(username);
        return bookingOrderEntityFacade.findAllByRegisteredUser(registeredUserEntity);
    }
    
    /**
     * Liefert eine Liste aller Bücher Bestellungensdetails zurück.
     * @param bookOrderEntity Entität der Bücher Bestellung
     * @return Liste vom Typ BookingOrderDetailEntity
     */
    public List<BookingOrderDetailEntity> getBookingOrderDetailFromBookingOrder(BookingOrderEntity bookOrderEntity) {
        return bookingOrderDetailEntityFacade.findByBookingOrder(bookOrderEntity);
    }
    
}
