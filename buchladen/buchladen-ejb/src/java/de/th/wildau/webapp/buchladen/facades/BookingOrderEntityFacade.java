package de.th.wildau.webapp.buchladen.facades;

import de.th.wildau.webapp.buchladen.entities.BookingOrderEntity;
import de.th.wildau.webapp.buchladen.entities.RegisteredUserEntity;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Jan Gabler
 * @author Malte Schwering
 * @version 0.3
 */
@Stateless
@RolesAllowed({"admin", "user"})
public class BookingOrderEntityFacade extends AbstractFacade<BookingOrderEntity> implements de.th.wildau.webapp.buchladen.facades.BookingOrderEntityFacadeRemote {
    
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
    public BookingOrderEntityFacade() {
        super(BookingOrderEntity.class);
    }
    
    /**
     * Erstellt eine Entität vom Typ BookingOrderEntity.
     * @param entity Entität die erstellt werden soll
     * @return BookingOrderEntity
     */
    @Override
    public BookingOrderEntity createAndReturnEntity(BookingOrderEntity entity) {
        super.create(entity);
        getEntityManager().flush();
        return entity;
    }
    
    /**
     * Liefert eine Liste aller Bücher Bestellungen eines Benutzers zurück.
     * @param user Entität des registrierten Benutzers
     * @return Liste vom Typ BookingOrderEntity
     */
    @Override
    public List<BookingOrderEntity> findAllByRegisteredUser(RegisteredUserEntity user) {
        return em.createNamedQuery("BookingOrderEntity.findAllByRegisteredUserId").setParameter("registeredUserId", user.getId()).getResultList();
    }
    
}
