package de.th.wildau.webapp.buchladen.sessions;

import de.th.wildau.webapp.buchladen.entities.BookingOrderDetailEntity;
import de.th.wildau.webapp.buchladen.entities.PaymentCreditCardEntity;
import de.th.wildau.webapp.buchladen.entities.PaymentTransferEntity;
import de.th.wildau.webapp.buchladen.entities.RegisteredUserEntity;
import java.util.List;
import javax.ejb.Remote;


@Remote
public interface CheckoutSessionBeanRemote {
    
    void buyBooks(List<BookingOrderDetailEntity> listBookingOrderDetailEntity, int paymentVariant, PaymentCreditCardEntity paymentCreditCardEntity, PaymentTransferEntity paymentTransferEntity);
    
    RegisteredUserEntity getRegisteredUserEntity();
    
    void setRegisteredUserEntity(RegisteredUserEntity registeredUserEntity);
}
