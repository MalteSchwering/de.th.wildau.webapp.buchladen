package de.th.wildau.webapp.buchladen.sessions;

import de.th.wildau.webapp.buchladen.entities.BookEntity;
import de.th.wildau.webapp.buchladen.entities.BookingOrderDetailEntity;
import de.th.wildau.webapp.buchladen.facades.BookEntityFacadeRemote;
import de.th.wildau.webapp.buchladen.facades.BookingOrderDetailEntityFacadeRemote;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateful;

/**
 * @author Jan Gabler
 * @author Malte Schwering
 * @version 0.1
 */
@Stateful
public class CartSessionBean implements CartSessionBeanRemote {

    /**
     * Enterprise Java Bean bookEntityFacade mit einem Remote Interface.
     */
    @EJB
    private BookEntityFacadeRemote bookEntityFacade;

    /**
     * Enterprise Java Bean bookingOrderDetailEntityFacade mit einem Remote Interface.
     */
    @EJB
    private BookingOrderDetailEntityFacadeRemote bookingOrderDetailEntityFacade;

    /**
     * Liste vom Typ BookingOrderDetailEntity die den Warenkorb repräsentiert.
     */
    private List<BookingOrderDetailEntity> cart;

    /**
     * Konstruktor der den Warenkorb initialisiert.
     */
    public CartSessionBean() {
        this.cart = new ArrayList<>();
    }

    /**
     * Prüft nach ob sich ein Buch im Warenkorb befindet.
     * @param bookEntity Buch Entität
     * @return Wahrheitswert
     */
    private boolean isBookInTheCart(BookEntity bookEntity) {
        Iterator<BookingOrderDetailEntity> iteratorBookingOrderDetailEntity = this.cart.iterator();
        while(iteratorBookingOrderDetailEntity.hasNext()) {
            if(iteratorBookingOrderDetailEntity.next().getFkBookId().equals(bookEntity)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Liefert den Inhalt vom Warenkorb zurück.
     * @return Liste vom Typ BookingOrderDetailEntity
     */
    @Override
    public List<BookingOrderDetailEntity> getContent() {
        return this.cart;
    }
    
    /**
     * Leert den Inhalt vom Warenkorb.
     */
    @Override
    public void clearCart() {
        this.cart.clear();
    }

    /**
     * Zählt die Anzahl der Bücher im Warenkorb.
     * @return Anzahl der Bücher
     */
    @Override
    public int count() {
        if(this.cart.isEmpty()) {
            return 0;
        }
        else {
            int total = 0;
            Iterator<BookingOrderDetailEntity> iteratorBookingOrderDetailEntity = this.cart.iterator();
            while(iteratorBookingOrderDetailEntity.hasNext()) {
                total += iteratorBookingOrderDetailEntity.next().getQuantity();
            }
            return total;
        }
    }

    /**
     * Liefert den Warenwert vom Warenkorb zurück.
     * @return Warenwert vom Warenkorb
     */
    @Override
    public double getTotal() {
        Iterator<BookingOrderDetailEntity> iteratorBookingOrderDetailEntity = this.cart.iterator();
        double total = 0.0;
        while(iteratorBookingOrderDetailEntity.hasNext()) {
            BookingOrderDetailEntity next = iteratorBookingOrderDetailEntity.next();
            total += next.getFkBookId().getPrice() * next.getQuantity();
        }
        return total;
    }
    
    /**
     * Löscht ein Buch komplett aus dem Warenkorb.
     * @param id ID des Buches
     */
    @Override
    public void removeBook(int id) {
        if(this.isBookInTheCart(new BookEntity(id))) {
            int index = this.getCartIdFromBookId(id);
            this.cart.remove(index);
        }
    }

    /**
     * Setzt die Anzahl eines Buches im Warenkorb.
     * @param id ID des Buches
     * @param quantity neue Anzahl des Buches
     */
    @Override
    public void setQuantity(int id, int quantity) {
        BookEntity bookEntity = this.bookEntityFacade.find(id);
        // Buch existiert
        if(bookEntity != null) {
            // Buch ist im Warenkorb
            if(this.isBookInTheCart(bookEntity)) {
                int cartId = this.getCartIdFromBookId(id);
                // Buch im Warenkorb gefunden
                if(cartId >= 0) {
                    BookingOrderDetailEntity bookingOrdnerDetailEntity = this.cart.get(cartId);
                    // nur 1 Exemplar des Buches im Warenkorb und die Anzahl soll verringert werden
                    if(bookingOrdnerDetailEntity.getQuantity() <= 1 && quantity < 0) {
                        this.removeBook(id);
                    }
                    // es sind mehr als 1 Exemplar des Buches im Warenkorb
                    else {
                        BookingOrderDetailEntity bookingOrderDetailEntity = this.cart.get(cartId);
                        int currentQuantity = bookingOrderDetailEntity.getQuantity();
                        bookingOrderDetailEntity.setQuantity(currentQuantity + quantity);
                    }
                }
            }
            // Buch ist nicht im Warenkorb
            else {
                // Anzahl ist nicht negativ
                if(quantity > 0) {
                    BookingOrderDetailEntity bookingOrderDetailEntity = new BookingOrderDetailEntity();
                    bookingOrderDetailEntity.setFkBookId(bookEntity);
                    bookingOrderDetailEntity.setQuantity(quantity);
                    this.cart.add(bookingOrderDetailEntity);
                }
            }
        }
    }

    /**
     * Setzt die Anzahl eines Buches im Warenkorb +1.
     * @param id ID des Buches
     */
    @Override
    public void setQuantityPlusOne(int id) {
        this.setQuantity(id, 1);
    }

    /**
     * Setzt die Anzahl eines Buches im Warenkorb -1.
     * @param id ID des Buches
     */
    @Override
    public void setQuantityMinusOne(int id) {
        this.setQuantity(id, -1);
    }

    /**
     * Durchsucht den Warenkorb nach einem Buch und liefert den Listen-Index zurück.
     * @param id ID des Buches
     * @return Listen Index
     */
    @Override
    public int getCartIdFromBookId(int id) {
        Iterator<BookingOrderDetailEntity> iteratorBookingOrderDetailEntity = this.cart.iterator();
        int index = 0;
        while(iteratorBookingOrderDetailEntity.hasNext()) {
            BookingOrderDetailEntity next = iteratorBookingOrderDetailEntity.next();
            if(next.getFkBookId().getId() == id) {
                return index;
            }
            index++;
        }
        return -1; 
    }

}
