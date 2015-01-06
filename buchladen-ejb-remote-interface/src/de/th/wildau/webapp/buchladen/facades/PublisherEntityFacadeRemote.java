package de.th.wildau.webapp.buchladen.facades;

import de.th.wildau.webapp.buchladen.entities.PublisherEntity;
import java.util.List;
import javax.ejb.Remote;

/**
 * @author Jan Gabler
 * @author Malte Schwering
 * @version 0.3
 */
@Remote
public interface PublisherEntityFacadeRemote {

    /**
     * Erstellt eine Verlags-Entität.
     * @param publisherEntity Verlags-Entität
     */
    void create(PublisherEntity publisherEntity);

    /**
     * Modifiziert eine Verlags-Entität.
     * @param publisherEntity Verlags-Entität
     */
    void edit(PublisherEntity publisherEntity);

    /**
     * Löscht eine Verlags-Entität.
     * @param publisherEntity Verlags-Entität
     */
    void remove(PublisherEntity publisherEntity);

    /**
     * Liefert eine bestimmte Verlags-Entität zurück.
     * @param id ID der Verlags-Entität
     * @return Verlags-Entität
     */
    PublisherEntity find(Object id);

    /**
     * Liefert eine Liste aller Verlags-Entitäten zurück.
     * @return Liste von Verlags-Entitäten
     */
    List<PublisherEntity> findAll();

    /**
     * Liefert eine Liste von Verlags-Entitäten aus einem bestimmten Bereich zurück.
     * @param range Bereich
     * @return Liste von Verlags-Entitäten
     */
    List<PublisherEntity> findRange(int[] range);

    /**
     * Liefert die Anzahl an gefundenen Verlags-Entitäten zurück.
     * @return Anzahl gefundender Verlags-Entitäten
     */
    int count();
    
}
