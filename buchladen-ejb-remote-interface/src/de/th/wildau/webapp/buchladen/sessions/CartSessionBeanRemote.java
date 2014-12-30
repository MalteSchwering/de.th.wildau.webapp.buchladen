/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.th.wildau.webapp.buchladen.sessions;

import de.th.wildau.webapp.buchladen.entities.BookingOrderDetailEntity;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Jan
 */
@Remote
public interface CartSessionBeanRemote {
    
    void removeBook(int id);
        
    List<BookingOrderDetailEntity> getContent();
    
    int count();
    
    double getTotal();
    
    void clearCart();
    
    void setQuantity(int id, int quantity);
    
    void setQuantityPlusOne(int id);
    
    void setQuantityMinusOne(int id);
    
    int getCartIdFromBookId(int id);
}
