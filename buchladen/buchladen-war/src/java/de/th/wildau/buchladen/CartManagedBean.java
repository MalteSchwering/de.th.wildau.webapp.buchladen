package de.th.wildau.buchladen;

import de.th.wildau.webapp.buchladen.entities.BookEntity;
import de.th.wildau.webapp.buchladen.sessions.CartSessionBeanRemote;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

public class CartManagedBean implements Serializable {
    
    /**
     * Enterprise Java Bean cartSessionBean mit einem Remote Interface.
     */
    @EJB
    private CartSessionBeanRemote cartSessionBean;
    
    /**
     * Fügt ein Buch zum Warenkorb hinzu.
     * @param id ID des Buchs
     */
    public void addBook(int id) {
        this.cartSessionBean.addBook(id);
    }
    
    /**
     * Löscht ein Buch aus dem Warenkorb.
     * @param id ID des Buchs
     */
    public void removeBook(int id) {
        this.cartSessionBean.removeBook(id);
    }
    
    /**
     * Liefert den Inhalt des Warenkorbs zurück in Form einer Liste.
     * @return Liste vom Typ BookEntity
     */
    public List<BookEntity> getContent() {
        return this.cartSessionBean.getContent();
    }
    
    /**
     * Liefert die Anzahl von Büchern die im Warenkorb enthalten sind zurück.
     * @return Anzahl der Bücher im Warenkorb
     */
    public int count() {
        return this.cartSessionBean.count();
    }
    
    /**
     * Liefert die Summe aller Bücher zurück, die im Warenkorb enthalten sind.
     * @return Summe des Warenkorbs
     */
    public double getTotal() {
        return this.cartSessionBean.getTotal();
    }
}