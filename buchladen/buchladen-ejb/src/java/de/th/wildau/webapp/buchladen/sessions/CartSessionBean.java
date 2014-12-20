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
     * Fügt ein Buch zum Warenkorb hinzu.
     * @param id ID des Buches
     */
    @Override
    public void addBook(int id) {
        BookEntity bookEntity = this.bookEntityFacade.find(id);
        if(bookEntity != null) {
            Iterator<BookingOrderDetailEntity> iteratorBookingOrderDetailEntity = this.cart.iterator();
            if(this.isBookInTheCart(bookEntity)) {
                while(iteratorBookingOrderDetailEntity.hasNext()) {
                    BookingOrderDetailEntity next = iteratorBookingOrderDetailEntity.next();
                    if(next.getFkBookId().equals(bookEntity)) {
                        next.setQuantity(next.getQuantity() + 1);
                    }
                }
            }
            else {
                BookingOrderDetailEntity bookOrderDetailEntity = new BookingOrderDetailEntity();
                bookOrderDetailEntity.setFkBookId(bookEntity);
                bookOrderDetailEntity.setQuantity(1);
                this.cart.add(bookOrderDetailEntity);
            }
        }
    }

    /**
     * Löscht ein Buch aus dem Warenkorb.
     * @param id ID des Buches
     */
    @Override
    public void removeBook(int id) {
        BookEntity bookEntity = this.bookEntityFacade.find(id);
        if(bookEntity != null) {
            Iterator<BookingOrderDetailEntity> iteratorBookingOrderDetailEntity = this.cart.iterator();
            if(this.isBookInTheCart(bookEntity)) {
                while(iteratorBookingOrderDetailEntity.hasNext()) {
                    BookingOrderDetailEntity next = iteratorBookingOrderDetailEntity.next();
                    if(next.getFkBookId().equals(bookEntity)) {
                        iteratorBookingOrderDetailEntity.remove();
                    }
                }
            }
        }
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
     * Setzt die Anzahl eines Buches im Warenkorb.
     * @param id ID des Buches
     * @param quantity neue Anzahl des Buches
     */
    @Override
    public void setQuantity(int id, int quantity) {
        if(quantity < 1) {
            this.removeBook(id);
        }
        else {
            BookEntity bookEntity = this.bookEntityFacade.find(id);
            if(bookEntity != null) {
                Iterator<BookingOrderDetailEntity> iteratorBookingOrderDetailEntity = this.cart.iterator();
                if(this.isBookInTheCart(bookEntity)) {
                    while(iteratorBookingOrderDetailEntity.hasNext()) {
                        BookingOrderDetailEntity next = iteratorBookingOrderDetailEntity.next();
                        if(next.getFkBookId().equals(bookEntity)) {
                            next.setQuantity(quantity);
                        }
                    }
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
        this.addBook(id);
    }

    /**
     * Setzt die Anzahl eines Buches im Warenkorb -1.
     * @param id ID des Buches
     */
    @Override
    public void setQuantityMinusOne(int id) {
        int cartId = this.getCartIdFromBookId(id);
        if(cartId > -1) {
            int quantityChange = this.cart.get(cartId).getQuantity() - 1;
            if(quantityChange < 1) {
                this.removeBook(id);
            }
            else {
                this.cart.get(cartId).setQuantity(quantityChange);
            }
        }
    }

    /**
     * Durchsucht den Warenkorb nach einem Buch und liefert den Listen-Index zurück.
     * @param id ID des Buches
     * @return Listen Index
     */
    @Override
    public int getCartIdFromBookId(int id) {
        BookEntity bookEntity = this.bookEntityFacade.find(id);
        if(bookEntity == null || !this.isBookInTheCart(bookEntity)) {
            return -1;
        }
        else {
            Iterator<BookingOrderDetailEntity> iteratorBookingOrderDetailEntity = this.cart.iterator();
            while(iteratorBookingOrderDetailEntity.hasNext()) {
                BookingOrderDetailEntity next = iteratorBookingOrderDetailEntity.next();
                return this.cart.indexOf(next);
            }
        }
        return -1; 
    }

}
