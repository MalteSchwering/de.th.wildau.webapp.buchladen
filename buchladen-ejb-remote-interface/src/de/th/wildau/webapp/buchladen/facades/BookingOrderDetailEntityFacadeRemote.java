package de.th.wildau.webapp.buchladen.facades;

import de.th.wildau.webapp.buchladen.entities.BookingOrderDetailEntity;
import de.th.wildau.webapp.buchladen.entities.BookingOrderEntity;
import java.util.List;
import javax.ejb.Remote;

/**
 * @author Jan Gabler
 * @author Malte Schwering
 * @version 0.3
 */
@Remote
public interface BookingOrderDetailEntityFacadeRemote {

    /**
     * Erstellt eine Buchungsdetail-Entität.
     * @param bookingOrderDetailEntity Buchungsdetail-Entität
     */
    void create(BookingOrderDetailEntity bookingOrderDetailEntity);

    /**
     * Modifiziert eine Buchungsdetail-Entität.
     * @param bookingOrderDetailEntity Buchungsdetail-Entität
     */
    void edit(BookingOrderDetailEntity bookingOrderDetailEntity);

    /**
     * Löscht eine Buchungsdetail-Entität.
     * @param bookingOrderDetailEntity Buchungsdetail-Entität
     */
    void remove(BookingOrderDetailEntity bookingOrderDetailEntity);

    /**
     * Liefert eine bestimmte Buchungsdetail-Entität zurück.
     * @param id ID der Buchungsdetail-Entität
     * @return Buchungsdetail-Entität
     */
    BookingOrderDetailEntity find(Object id);

    /**
     * Liefert eine Liste aller Buchungsdetail-Entitäten zurück.
     * @return Liste von Buchungsdetail-Entitäten
     */
    List<BookingOrderDetailEntity> findAll();

    /**
     * Liefert eine Liste von Buchungsdetail-Entitäten aus einem bestimmten Bereich zurück.
     * @param range Bereich
     * @return Liste von Buchungsdetail-Entitäten
     */
    List<BookingOrderDetailEntity> findRange(int[] range);
    
    /**
     * Liefert eine Liste von Buchungsdetail-Entitäten einer bestimmten Buchungs-Entität zurück.
     * @param bookingOrderEntity Buchungs-Entität
     * @return Liste von Buchungsdetail-Entitäten
     */
    List<BookingOrderDetailEntity> findByBookingOrder(BookingOrderEntity bookingOrderEntity);

    /**
     * Liefert die Anzahl an gefundenen Buchungsdetail-Entitäten zurück.
     * @return Anzahl gefundender Buchungsdetail-Entitäten
     */
    int count();
    
}
