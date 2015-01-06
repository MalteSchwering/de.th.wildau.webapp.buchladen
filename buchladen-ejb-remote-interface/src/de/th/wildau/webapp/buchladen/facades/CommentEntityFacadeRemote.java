package de.th.wildau.webapp.buchladen.facades;

import de.th.wildau.webapp.buchladen.entities.CommentEntity;
import java.util.List;
import javax.ejb.Remote;

/**
 * @author Jan Gabler
 * @author Malte Schwering
 * @version 0.3
 */
@Remote
public interface CommentEntityFacadeRemote {
    
    /**
     * Erstellt eine Kommentar-Entität.
     * @param bookId Buch ID
     * @param comment Kommentartext
     */
    void createBookComment(int bookId, String comment);

    /**
     * Erstellt eine Kommentar-Entität.
     * @param commentEntity Kommentar-Entität
     */
    void create(CommentEntity commentEntity);

    /**
     * Modifiziert eine Kommentar-Entität.
     * @param commentEntity Kommentar-Entität
     */
    void edit(CommentEntity commentEntity);

    /**
     * Löscht eine Kommentar-Entität.
     * @param commentEntity Kommentar-Entität
     */
    void remove(CommentEntity commentEntity);

    /**
     * Liefert eine bestimmte Kommentar-Entität zurück.
     * @param id ID der Kommentar-Entität
     * @return Kommentar-Entität
     */
    CommentEntity find(Object id);

    /**
     * Liefert eine Liste aller Kommentar-Entitäten zurück.
     * @return Liste von Kommentar-Entitäten
     */
    List<CommentEntity> findAll();

    /**
     * Liefert eine Liste von Kommentar-Entitäten aus einem bestimmten Bereich zurück.
     * @param range Bereich
     * @return Liste von Kommentar-Entitäten
     */
    List<CommentEntity> findRange(int[] range);
    
    /**
     * Liefert eine Liste von Kommentar-Entitäten einer bestimmten Buch ID zurück.
     * @param id ID der Buch-Entität
     * @return Liste von Kommentar-Entitäten
     */
    List<CommentEntity> findByBookId(int id);

    /**
     * Liefert die Anzahl an gefundenen Kommentar-Entitäten zurück.
     * @return Anzahl gefundender Kommentar-Entitäten
     */
    int count();
    
}
