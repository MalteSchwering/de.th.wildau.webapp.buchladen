package de.th.wildau.webapp.buchladen.facades;

import de.th.wildau.webapp.buchladen.entities.UserGroupEntity;
import java.util.List;
import javax.ejb.Remote;

/**
 * @author Jan Gabler
 * @author Malte Schwering
 * @version 0.3
 */
@Remote
public interface UserGroupEntityFacadeRemote {

    /**
     * Erstellt eine Benutzer-Gruppen-Entität.
     * @param userGroupEntity Benutzer-Gruppen-Entität
     */
    void create(UserGroupEntity userGroupEntity);

    /**
     * Modifiziert eine Benutzer-Gruppen-Entität.
     * @param userGroupEntity Benutzer-Gruppen-Entität
     */
    void edit(UserGroupEntity userGroupEntity);

    /**
     * Löscht eine Benutzer-Gruppen-Entität.
     * @param userGroupEntity Benutzer-Gruppen-Entität
     */
    void remove(UserGroupEntity userGroupEntity);

    /**
     * Liefert eine bestimmte Benutzer-Gruppen-Entität zurück.
     * @param id ID der Benutzer-Gruppen-Entität
     * @return Benutzer-Gruppen-Entität
     */
    UserGroupEntity find(Object id);

    /**
     * Liefert eine Liste aller Benutzer-Gruppen-Entitäten zurück.
     * @return Liste von Benutzer-Gruppen-Entitäten
     */
    List<UserGroupEntity> findAll();

    /**
     * Liefert eine Liste von Benutzer-Gruppen-Entitäten aus einem bestimmten Bereich zurück.
     * @param range Bereich
     * @return Liste von Benutzer-Gruppen-Entitäten
     */
    List<UserGroupEntity> findRange(int[] range);

    /**
     * Liefert eine bestimmte Benutzer-Gruppen-Entität eines Gruppennamens zurück.
     * @param groupName Gruppenname
     * @return Benutzer-Gruppen-Entität
     */
    UserGroupEntity findByGroupName(String groupName);

    /**
     * Liefert die Anzahl an gefundenen Benutzer-Gruppen-Entitäten zurück.
     * @return Anzahl gefundender Benutzer-Gruppen-Entitäten
     */
    int count();
    
}
