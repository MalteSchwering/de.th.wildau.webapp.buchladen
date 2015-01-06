package de.th.wildau.webapp.buchladen.facades;

import de.th.wildau.webapp.buchladen.entities.RegisteredUserEntity;
import java.util.List;
import javax.ejb.Remote;

/**
 * @author Jan Gabler
 * @author Malte Schwering
 * @version 0.3
 */
@Remote
public interface RegisteredUserEntityFacadeRemote {

    /**
     * Erstellt eine Benutzer-Entität.
     * @param registeredUserEntity Benutzer-Entität
     */
    void create(RegisteredUserEntity registeredUserEntity);

    /**
     * Modifiziert eine Benutzer-Entität.
     * @param registeredUserEntity Benutzer-Entität
     */
    void edit(RegisteredUserEntity registeredUserEntity);

    /**
     * Löscht eine Benutzer-Entität.
     * @param registeredUserEntity Benutzer-Entität
     */
    void remove(RegisteredUserEntity registeredUserEntity);

    /**
     * Liefert eine bestimmte Benutzer-Entität zurück.
     * @param id ID der Benutzer-Entität
     * @return Benutzer-Entität
     */
    RegisteredUserEntity find(Object id);

    /**
     * Liefert eine Liste aller Benutzer-Entitäten zurück.
     * @return Liste von Benutzer-Entitäten
     */
    List<RegisteredUserEntity> findAll();

    /**
     * Liefert eine Liste von Benutzer-Entitäten aus einem bestimmten Bereich zurück.
     * @param range Bereich
     * @return Liste von Benutzer-Entitäten
     */
    List<RegisteredUserEntity> findRange(int[] range);
    
    /**
     * Liefert eine bestimmte Benutzer-Entität zurück.
     * @param emailAddress E-Mail Adresse/Username des Benutzers
     * @return Benutzer-Entität
     */
    RegisteredUserEntity findByEmailAddress(String emailAddress);

    /**
     * Liefert die Anzahl an gefundenen Benutzer-Entitäten zurück.
     * @return Anzahl gefundender Benutzer-Entitäten
     */
    int count();
    
}
