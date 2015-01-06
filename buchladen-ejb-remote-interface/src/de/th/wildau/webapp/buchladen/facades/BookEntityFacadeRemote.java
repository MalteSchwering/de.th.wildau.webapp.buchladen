package de.th.wildau.webapp.buchladen.facades;

import de.th.wildau.webapp.buchladen.entities.BookEntity;
import java.util.List;
import javax.ejb.Remote;

/**
 * @author Jan Gabler
 * @author Malte Schwering
 * @version 0.3
 */
@Remote
public interface BookEntityFacadeRemote {

    /**
     * Erstellt eine Buch-Entität.
     * @param bookEntity Buch-Entität
     */
    void create(BookEntity bookEntity);

    /**
     * Modifiziert eine Buch-Entität.
     * @param bookEntity Buch-Entität
     */
    void edit(BookEntity bookEntity);

    /**
     * Löscht eine Buch-Entität.
     * @param bookEntity Buch-Entität
     */
    void remove(BookEntity bookEntity);

    /**
     * Liefert eine bestimmte Buch-Entität zurück.
     * @param id ID der Buch-Entität
     * @return Buch-Entität
     */
    BookEntity find(Object id);

    /**
     * Liefert eine Liste aller Buch-Entitäten zurück.
     * @return Liste von Buch-Entitäten
     */
    List<BookEntity> findAll();

    /**
     * Liefert eine Liste von Buch-Entitäten aus einem bestimmten Bereich zurück.
     * @param range Bereich
     * @return Liste von Buch-Entitäten
     */
    List<BookEntity> findRange(int[] range);

    /**
     * Liefert die Anzahl an gefundenen Buch-Entitäten zurück.
     * @return Anzahl gefundender Buch-Entitäten
     */
    int count();
    
}
