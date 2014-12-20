package de.th.wildau.webapp.buchladen.sessions;

import de.th.wildau.webapp.buchladen.entities.BookingOrderDetailEntity;
import de.th.wildau.webapp.buchladen.entities.BookingOrderEntity;
import de.th.wildau.webapp.buchladen.entities.RegisteredUserEntity;
import de.th.wildau.webapp.buchladen.facades.BookingOrderDetailEntityFacadeRemote;
import de.th.wildau.webapp.buchladen.facades.BookingOrderEntityFacadeRemote;
import de.th.wildau.webapp.buchladen.facades.PaymentCreditCardEntityFacadeRemote;
import de.th.wildau.webapp.buchladen.facades.PaymentTransferEntityFacadeRemote;
import de.th.wildau.webapp.buchladen.facades.RegisteredUserEntityFacadeRemote;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;

/**
 * @author Jan Gabler
 * @author Malte Schwering
 * @version 0.1
 */
@Stateless
public class CheckoutSessionBean implements CheckoutSessionBeanRemote {
        
    /**
     * Enterprise Java Bean registeredUserEntityFacade mit einem Remote Interface.
     */
    @EJB
    private RegisteredUserEntityFacadeRemote registeredUserEntityFacade;
    
    /**
     * Enterprise Java Bean paymentTransferEntityFacade mit einem Remote Interface.
     */
    @EJB
    private PaymentTransferEntityFacadeRemote paymentTransferEntityFacade;
    
    /**
     * Enterprise Java Bean paymentCreditCardEntityFacade mit einem Remote Interface.
     */
    @EJB
    private PaymentCreditCardEntityFacadeRemote paymentCreditCardEntityFacade;
    
    /**
     * Enterprise Java Bean bookingOrderDetailEntityFacade mit einem Remote Interface.
     */
    @EJB
    private BookingOrderDetailEntityFacadeRemote bookingOrderDetailEntityFacade;
    
    /**
     * Enterprise Java Bean bookingOrderEntityFacade mit einem Remote Interface.
     */
    @EJB
    private BookingOrderEntityFacadeRemote bookingOrderEntityFacade;
    
    /**
     * Die Entität des registrierten Benutzers.
     */
    private RegisteredUserEntity registeredUserEntity;
    
    /**
     * Initialisiert die Entität des registrierten Benutzers.
     */
    @PostConstruct
    public void init() {
        String username = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
        this.registeredUserEntity = this.registeredUserEntityFacade.findByEmailAddress(username);
    }
    
    /**
     * Kauf der Bücher aus dem Warenkorb wird durchgeführt.
     * @param listBookingOrderDetailEntity Inhalt vom Warenkorb
     */
    @Override
    public void buyBooks(List<BookingOrderDetailEntity> listBookingOrderDetailEntity) {
        // Bestellung anlegen
        BookingOrderEntity bookingOrderEntity = new BookingOrderEntity();
        bookingOrderEntity.setFkRegisteredUserId(this.registeredUserEntity);
        BookingOrderEntity createdBookingOrderEntity = this.bookingOrderEntityFacade.createAndReturnEntity(bookingOrderEntity);
        
        // Bestelldetails anlegen
        Iterator<BookingOrderDetailEntity> iteratorBookingOrderDetailEntity = listBookingOrderDetailEntity.iterator();
        while(iteratorBookingOrderDetailEntity.hasNext()) {
            BookingOrderDetailEntity bookingOrderDetailEntity = iteratorBookingOrderDetailEntity.next();
            bookingOrderDetailEntity.setFkBookingOrderId(createdBookingOrderEntity);
            this.bookingOrderDetailEntityFacade.create(bookingOrderDetailEntity);
        }
        
        // Bezahlmethode anlegen
        //...
        
        // Warenkorb löschen
        //...
    }
    
    /**
     * Liefert die Entität des registrierten Benutzers zurück.
     * @return Entität des registrierten Benutzers
     */
    @Override
    public RegisteredUserEntity getRegisteredUserEntity() {
        return registeredUserEntity;
    }
    
    /**
     * Setzt die Entität des registrierten Benutzers.
     * @param registeredUserEntity Entität des registrierten Benutzers
     */
    @Override
    public void setRegisteredUserEntity(RegisteredUserEntity registeredUserEntity) {
        this.registeredUserEntity = registeredUserEntity;
    }

}
