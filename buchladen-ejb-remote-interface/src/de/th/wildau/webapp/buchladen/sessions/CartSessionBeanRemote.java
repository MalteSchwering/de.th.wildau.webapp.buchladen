package de.th.wildau.webapp.buchladen.sessions;

import de.th.wildau.webapp.buchladen.entities.BookingOrderDetailEntity;
import java.util.List;
import javax.ejb.Remote;

/**
 * @author Jan Gabler
 * @author Malte Schwering
 * @version 0.3
 */
@Remote
public interface CartSessionBeanRemote {
    
    /**
     * Löscht ein Buch komplett aus dem Warenkorb.
     * @param id ID des Buches
     */
    void removeBook(int id);
    
    /**
     * Liefert den Inhalt vom Warenkorb zurück.
     * @return Liste vom Typ BookingOrderDetailEntity
     */
    List<BookingOrderDetailEntity> getContent();
    
    /**
     * Zählt die Anzahl der Bücher im Warenkorb.
     * @return Anzahl der Bücher
     */
    int count();
    
    /**
     * Liefert den Warenwert vom Warenkorb zurück.
     * @return Warenwert vom Warenkorb
     */
    double getTotal();
    
    /**
     * Leert den Inhalt vom Warenkorb.
     */
    void clearCart();
    
    /**
     * Setzt die Anzahl eines Buches im Warenkorb.
     * @param id ID des Buches
     * @param quantity neue Anzahl des Buches
     */
    void setQuantity(int id, int quantity);
    
    /**
     * Setzt die Anzahl eines Buches im Warenkorb +1.
     * @param id ID des Buches
     */
    void setQuantityPlusOne(int id);
    
    /**
     * Setzt die Anzahl eines Buches im Warenkorb -1.
     * @param id ID des Buches
     */
    void setQuantityMinusOne(int id);
    
    /**
     * Durchsucht den Warenkorb nach einem Buch und liefert den Listen-Index zurück.
     * @param id ID des Buches
     * @return Listen Index
     */
    int getCartIdFromBookId(int id);
    
}
