package de.th.wildau.webapp.buchladen.facades;

import de.th.wildau.webapp.buchladen.entities.UserGroupEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * @author Jan Gabler
 * @author Malte Schwering
 * @version 0.1
 */
@Stateless
public class UserGroupEntityFacade extends AbstractFacade<UserGroupEntity> implements de.th.wildau.webapp.buchladen.facades.UserGroupEntityFacadeRemote {

    /**
     * Der Entitäten-Manager.
     */
    @PersistenceContext(unitName = "buchladen-ejbPU")
    private EntityManager em;

    /**
     * Liefert den Entitäten-Manager zurück.
     * @return Entitäten-Manager
     */
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     * Konstruktor der den Konstruktor der abstrakten Klasse aufruft.
     */
    public UserGroupEntityFacade() {
        super(UserGroupEntity.class);
    }

    /**
     * Liefert die Entität einer Benutzergruppe zu einem bestimmten Gruppennamen zurück.
     * @param groupName Name der Benutzergruppe
     * @return UserGroupEntity
     */
    @Override
    public UserGroupEntity findByGroupName(String groupName) {
        try {
            Query query = em.createNamedQuery("UserGroupEntity.findByGroupName");
            return (UserGroupEntity) query.setParameter("groupName", groupName).getSingleResult();
        } catch(NoResultException e) {
            return null;
        }
    }
    
}
