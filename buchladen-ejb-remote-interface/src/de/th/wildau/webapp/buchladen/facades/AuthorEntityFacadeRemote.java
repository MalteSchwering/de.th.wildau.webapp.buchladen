package de.th.wildau.webapp.buchladen.facades;

import de.th.wildau.webapp.buchladen.entities.AuthorEntity;
import java.util.List;
import javax.ejb.Remote;

/**
 * @author Jan Gabler
 * @author Malte Schwering
 * @version 0.3
 */
@Remote
public interface AuthorEntityFacadeRemote {

    /**
     * Erstellt eine Autor-Entität.
     * @param authorEntity Autor-Entität
     */
    void create(AuthorEntity authorEntity);

    /**
     * Modifiziert eine Autor-Entität.
     * @param authorEntity Autor-Entität
     */
    void edit(AuthorEntity authorEntity);

    /**
     * Löscht eine Autor-Entität.
     * @param authorEntity Autor-Entität
     */
    void remove(AuthorEntity authorEntity);

    /**
     * Liefert eine bestimmte Autor-Entität zurück.
     * @param id ID der Autor-Entität
     * @return Autor-Entität
     */
    AuthorEntity find(Object id);

    /**
     * Liefert eine Liste aller Autor-Entitäten zurück.
     * @return Liste von Autor-Entitäten
     */
    List<AuthorEntity> findAll();

    /**
     * Liefert eine Liste von Autor-Entitäten aus einem bestimmten Bereich zurück.
     * @param range Bereich
     * @return Liste von Autor-Entitäten
     */
    List<AuthorEntity> findRange(int[] range);

    /**
     * Liefert die Anzahl an gefundenen Autor-Entitäten zurück.
     * @return Anzahl gefundender Autor-Entitäten
     */
    int count();
    
}
