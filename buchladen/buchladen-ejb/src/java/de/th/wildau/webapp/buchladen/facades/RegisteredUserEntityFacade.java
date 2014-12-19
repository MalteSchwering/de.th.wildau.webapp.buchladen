package de.th.wildau.webapp.buchladen.facades;

import de.th.wildau.webapp.buchladen.entities.RegisteredUserEntity;
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
public class RegisteredUserEntityFacade extends AbstractFacade<RegisteredUserEntity> implements de.th.wildau.webapp.buchladen.facades.RegisteredUserEntityFacadeRemote {
    
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
    public RegisteredUserEntityFacade() {
        super(RegisteredUserEntity.class);
    }

    /**
     * Liefert die Entität eines registrierten Benutzer zu einer bestimmten E-Mail Adresse zurück.
     * @param emailAddress E-Mail des Benutzers
     * @return RegisteredUserEntity
     */
    @Override
    public RegisteredUserEntity findByEmailAddress(String emailAddress) {
        try {
            Query query = em.createNamedQuery("RegisteredUserEntity.findByEmailAddress");
            return (RegisteredUserEntity) query.setParameter("emailAddress", emailAddress).getSingleResult();
        } catch(NoResultException e) {
            return null;
        }
    }
    
}
