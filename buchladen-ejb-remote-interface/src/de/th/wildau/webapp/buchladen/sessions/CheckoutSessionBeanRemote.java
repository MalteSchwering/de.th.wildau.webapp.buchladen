package de.th.wildau.webapp.buchladen.sessions;

import de.th.wildau.webapp.buchladen.entities.BookingOrderDetailEntity;
import de.th.wildau.webapp.buchladen.entities.PaymentCreditCardEntity;
import de.th.wildau.webapp.buchladen.entities.PaymentTransferEntity;
import de.th.wildau.webapp.buchladen.entities.RegisteredUserEntity;
import java.util.List;
import javax.ejb.Remote;

/**
 * @author Jan Gabler
 * @author Malte Schwering
 * @version 0.3
 */
@Remote
public interface CheckoutSessionBeanRemote {
    
    /**
     * Kauf der Bücher aus dem Warenkorb wird durchgeführt.
     * @param listBookingOrderDetailEntity Inhalt vom Warenkorb
     * @param paymentVariant Zahlungsvariante
     * @param paymentCreditCardEntity Entität einer Kreditkarten Zahlung
     * @param paymentTransferEntity Entität einer Kontoüberweisung
     */
    void buyBooks(List<BookingOrderDetailEntity> listBookingOrderDetailEntity, int paymentVariant, PaymentCreditCardEntity paymentCreditCardEntity, PaymentTransferEntity paymentTransferEntity);
    
    /**
     * Liefert die Entität des registrierten Benutzers zurück.
     * @return Entität des registrierten Benutzers
     */
    RegisteredUserEntity getRegisteredUserEntity();
    
    /**
     * Setzt die Entität des registrierten Benutzers.
     * @param registeredUserEntity Entität des registrierten Benutzers
     */
    void setRegisteredUserEntity(RegisteredUserEntity registeredUserEntity);
    
}
