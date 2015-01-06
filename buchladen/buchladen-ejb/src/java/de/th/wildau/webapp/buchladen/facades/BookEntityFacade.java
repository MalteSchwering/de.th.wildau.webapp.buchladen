package de.th.wildau.webapp.buchladen.facades;

import de.th.wildau.webapp.buchladen.entities.BookEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Jan Gabler
 * @author Malte Schwering
 * @version 0.3
 */
@Stateless
public class BookEntityFacade extends AbstractFacade<BookEntity> implements de.th.wildau.webapp.buchladen.facades.BookEntityFacadeRemote {
    
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
    public BookEntityFacade() {
        super(BookEntity.class);
    }
    
}
