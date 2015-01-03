package de.th.wildau.webapp.buchladen.facades;

import de.th.wildau.webapp.buchladen.entities.RegisteredUserGroupMappingEntity;
import java.util.List;
import javax.ejb.Remote;

/**
 * @author Jan Gabler
 * @author Malte Schwering
 * @version 0.3
 */
@Remote
public interface RegisteredUserGroupMappingEntityFacadeRemote {

    /**
     * Erstellt eine Benutzer/Benutzer-Gruppen Zuordnungs-Entität.
     * @param registeredUserGroupMappingEntity Benutzer/Benutzer-Gruppen Zuordnungs-Entität
     */
    void create(RegisteredUserGroupMappingEntity registeredUserGroupMappingEntity);

    /**
     * Modifiziert eine Benutzer/Benutzer-Gruppen Zuordnungs-Entität.
     * @param registeredUserGroupMappingEntity Benutzer/Benutzer-Gruppen Zuordnungs-Entität
     */
    void edit(RegisteredUserGroupMappingEntity registeredUserGroupMappingEntity);

    /**
     * Löscht eine Benutzer/Benutzer-Gruppen Zuordnungs-Entität.
     * @param registeredUserGroupMappingEntity Benutzer/Benutzer-Gruppen Zuordnungs-Entität
     */
    void remove(RegisteredUserGroupMappingEntity registeredUserGroupMappingEntity);

    /**
     * Liefert eine bestimmte Benutzer/Benutzer-Gruppen Zuordnungs-Entität zurück.
     * @param id ID der Benutzer/Benutzer-Gruppen Zuordnungs-Entität
     * @return Benutzer/Benutzer-Gruppen Zuordnungs-Entität
     */
    RegisteredUserGroupMappingEntity find(Object id);

    /**
     * Liefert eine Liste aller Benutzer/Benutzer-Gruppen Zuordnungs-Entitäten zurück.
     * @return Liste von Benutzer/Benutzer-Gruppen Zuordnungs-Entitäten
     */
    List<RegisteredUserGroupMappingEntity> findAll();

    /**
     * Liefert eine Liste von Benutzer/Benutzer-Gruppen Zuordnungs-Entitäten aus einem bestimmten Bereich zurück.
     * @param range Bereich
     * @return Liste von Benutzer/Benutzer-Gruppen Zuordnungs-Entitäten
     */
    List<RegisteredUserGroupMappingEntity> findRange(int[] range);

    /**
     * Liefert die Anzahl an gefundenen Benutzer/Benutzer-Gruppen Zuordnungs-Entitäten zurück.
     * @return Anzahl gefundender Benutzer/Benutzer-Gruppen Zuordnungs-Entitäten
     */
    int count();
    
}
