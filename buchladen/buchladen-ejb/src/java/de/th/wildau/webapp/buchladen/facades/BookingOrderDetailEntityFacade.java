package de.th.wildau.webapp.buchladen.facades;

import de.th.wildau.webapp.buchladen.entities.BookingOrderDetailEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Jan Gabler
 * @author Malte Schwering
 * @version 0.1
 */
@Stateless
public class BookingOrderDetailEntityFacade extends AbstractFacade<BookingOrderDetailEntity> implements de.th.wildau.webapp.buchladen.facades.BookingOrderDetailEntityFacadeRemote {
    
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
    public BookingOrderDetailEntityFacade() {
        super(BookingOrderDetailEntity.class);
    }
    
}
