package de.th.wildau.webapp.buchladen.facades;

import de.th.wildau.webapp.buchladen.entities.AuthorEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Jan Gabler
 * @author Malte Schwering
 * @version 0.1
 */
@Stateless
public class AuthorEntityFacade extends AbstractFacade<AuthorEntity> implements AuthorEntityFacadeRemote {
    
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
    public AuthorEntityFacade() {
        super(AuthorEntity.class);
    }
    
}
