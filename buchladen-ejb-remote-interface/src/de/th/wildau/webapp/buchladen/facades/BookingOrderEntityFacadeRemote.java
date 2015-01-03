package de.th.wildau.webapp.buchladen.facades;

import de.th.wildau.webapp.buchladen.entities.BookingOrderEntity;
import de.th.wildau.webapp.buchladen.entities.RegisteredUserEntity;
import java.util.List;
import javax.ejb.Remote;

/**
 * @author Jan Gabler
 * @author Malte Schwering
 * @version 0.3
 */
@Remote
public interface BookingOrderEntityFacadeRemote {

    /**
     * Erstellt eine Buchungs-Entität.
     * @param bookingOrderEntity Buchungs-Entität
     */
    void create(BookingOrderEntity bookingOrderEntity);
    
    /**
     * Erstellt eine Buchungs-Entität.
     * @param entity Buchungs-Entität
     * @return Buchungs-Entität mit ID
     */
    BookingOrderEntity createAndReturnEntity(BookingOrderEntity entity);

    /**
     * Modifiziert eine Buchungs-Entität.
     * @param bookingOrderEntity Buchungs-Entität
     */
    void edit(BookingOrderEntity bookingOrderEntity);

    /**
     * Löscht eine Buchungs-Entität.
     * @param bookingOrderEntity Buchungs-Entität
     */
    void remove(BookingOrderEntity bookingOrderEntity);

    /**
     * Liefert eine bestimmte Buchungs-Entität zurück.
     * @param id ID der Buchungs-Entität
     * @return Buchungs-Entität
     */
    BookingOrderEntity find(Object id);

    /**
     * Liefert eine Liste aller Buchungs-Entitäten zurück.
     * @return Liste von Buchungs-Entitäten
     */
    List<BookingOrderEntity> findAll();
    
    /**
     * Liefert eine Liste von Buchungs-Entitäten einer Benutzer-Entität zurück.
     * @param user Benutzer-Entität
     * @return Liste von Buchungs-Entitäten
     */
    List<BookingOrderEntity> findAllByRegisteredUser(RegisteredUserEntity user);

    /**
     * Liefert eine Liste von Buchungs-Entitäten aus einem bestimmten Bereich zurück.
     * @param range Bereich
     * @return Liste von Buchungs-Entitäten
     */
    List<BookingOrderEntity> findRange(int[] range);

    /**
     * Liefert die Anzahl an gefundenen Buchungs-Entitäten zurück.
     * @return Anzahl gefundender Buchungs-Entitäten
     */
    int count();
    
}
