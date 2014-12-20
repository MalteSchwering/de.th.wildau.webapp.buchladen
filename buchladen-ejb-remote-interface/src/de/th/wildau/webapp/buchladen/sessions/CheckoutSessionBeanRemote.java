package de.th.wildau.webapp.buchladen.sessions;

import de.th.wildau.webapp.buchladen.entities.BookingOrderDetailEntity;
import de.th.wildau.webapp.buchladen.entities.RegisteredUserEntity;
import java.util.List;
import javax.ejb.Remote;


@Remote
public interface CheckoutSessionBeanRemote {
    
    void buyBooks(List<BookingOrderDetailEntity> listBookingOrderDetailEntity);
    
    RegisteredUserEntity getRegisteredUserEntity();
    
    void setRegisteredUserEntity(RegisteredUserEntity registeredUserEntity);
}
