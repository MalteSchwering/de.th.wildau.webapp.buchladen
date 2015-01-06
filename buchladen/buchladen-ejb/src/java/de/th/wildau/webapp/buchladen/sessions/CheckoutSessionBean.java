package de.th.wildau.webapp.buchladen.sessions;

import de.th.wildau.webapp.buchladen.entities.BookEntity;
import de.th.wildau.webapp.buchladen.entities.BookingOrderDetailEntity;
import de.th.wildau.webapp.buchladen.entities.BookingOrderEntity;
import de.th.wildau.webapp.buchladen.entities.PaymentCreditCardEntity;
import de.th.wildau.webapp.buchladen.entities.PaymentTransferEntity;
import de.th.wildau.webapp.buchladen.entities.RegisteredUserEntity;
import de.th.wildau.webapp.buchladen.facades.BookEntityFacadeRemote;
import de.th.wildau.webapp.buchladen.facades.BookingOrderDetailEntityFacadeRemote;
import de.th.wildau.webapp.buchladen.facades.BookingOrderEntityFacadeRemote;
import de.th.wildau.webapp.buchladen.facades.PaymentCreditCardEntityFacadeRemote;
import de.th.wildau.webapp.buchladen.facades.PaymentTransferEntityFacadeRemote;
import de.th.wildau.webapp.buchladen.facades.RegisteredUserEntityFacadeRemote;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.PostActivate;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;

/**
 * @author Jan Gabler
 * @author Malte Schwering
 * @version 0.3
 */
@Stateless
@RolesAllowed({"admin", "user"})
public class CheckoutSessionBean implements CheckoutSessionBeanRemote {
    
    /**
     * Enterprise Java Bean bookEntityFacade mit einem Remote Interface.
     */
    @EJB
    private BookEntityFacadeRemote bookEntityFacade;
    
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
    public void initUser() {
        String username = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
        this.registeredUserEntity = this.registeredUserEntityFacade.findByEmailAddress(username);
    }
    
    /**
     * Kauf der Bücher aus dem Warenkorb wird durchgeführt.
     * @param listBookingOrderDetailEntity Inhalt vom Warenkorb
     * @param paymentVariant Zahlungsvariante
     * @param paymentCreditCardEntity Entität einer Kreditkarten Zahlung
     * @param paymentTransferEntity Entität einer Kontoüberweisung
     */
    @Override
    public void buyBooks(List<BookingOrderDetailEntity> listBookingOrderDetailEntity, int paymentVariant, PaymentCreditCardEntity paymentCreditCardEntity, PaymentTransferEntity paymentTransferEntity) {

        PaymentCreditCardEntity createdPaymentCreditCartyEntity = null;
        PaymentTransferEntity createdPaymentTransferEntity = null;
        // Bezahlmethode anlegen
        if(paymentVariant == 1) {
            paymentCreditCardEntity.setFkRegisteredUserId(registeredUserEntity);
            createdPaymentCreditCartyEntity = paymentCreditCardEntityFacade.createAndReturnEntity(paymentCreditCardEntity);
        }
        else if(paymentVariant == 2) {
            paymentTransferEntity.setFkRegisteredUserId(registeredUserEntity);
            createdPaymentTransferEntity = paymentTransferEntityFacade.createAndReturnEntity(paymentTransferEntity);
        }
        
        // Bestellung anlegen
        BookingOrderEntity bookingOrderEntity = new BookingOrderEntity();
        bookingOrderEntity.setFkRegisteredUserId(this.registeredUserEntity);
        if(createdPaymentCreditCartyEntity == null) {
            bookingOrderEntity.setFkPaymentCreditCard(createdPaymentCreditCartyEntity);
        }
        else if(createdPaymentTransferEntity == null) {
            bookingOrderEntity.setFkPaymentTransfer(createdPaymentTransferEntity);
        }
        BookingOrderEntity createdBookingOrderEntity = this.bookingOrderEntityFacade.createAndReturnEntity(bookingOrderEntity);
        
        Iterator<BookingOrderDetailEntity> iteratorBookingOrderDetailEntity = listBookingOrderDetailEntity.iterator();
        while(iteratorBookingOrderDetailEntity.hasNext()) {
            // Bestelldetails anlegen
            BookingOrderDetailEntity bookingOrderDetailEntity = iteratorBookingOrderDetailEntity.next();
            bookingOrderDetailEntity.setFkBookingOrderId(createdBookingOrderEntity);
            this.bookingOrderDetailEntityFacade.create(bookingOrderDetailEntity);
            
            // Bestand ändern
            BookEntity bookEntity = this.bookEntityFacade.find(bookingOrderDetailEntity.getFkBookId().getId());
            int currentQuantity = bookEntity.getQuantity();
            bookEntity.setQuantity(currentQuantity - bookingOrderDetailEntity.getQuantity());
            this.bookEntityFacade.edit(bookEntity);
        }
    }
    
    /**
     * Liefert die Entität des registrierten Benutzers zurück.
     * @return Entität des registrierten Benutzers
     */
    @Override
    public RegisteredUserEntity getRegisteredUserEntity() {
        this.initUser();
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
