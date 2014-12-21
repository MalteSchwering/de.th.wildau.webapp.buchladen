package de.th.wildau.webapp.buchladen.facades;

import de.th.wildau.webapp.buchladen.entities.PaymentTransferEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Jan Gabler
 * @author Malte Schwering
 * @version 0.1
 */
@Stateless
public class PaymentTransferEntityFacade extends AbstractFacade<PaymentTransferEntity> implements de.th.wildau.webapp.buchladen.facades.PaymentTransferEntityFacadeRemote {
    
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
    public PaymentTransferEntityFacade() {
        super(PaymentTransferEntity.class);
    }
    
    /**
     * Erstellt eine Entität vom Typ PaymentTransferEntity.
     * @param paymentTransferEntity Entität die erstellt werden soll
     * @return PaymentTransferEntity
     */
    @Override
    public PaymentTransferEntity createAndReturnEntity(PaymentTransferEntity paymentTransferEntity) {
        super.create(paymentTransferEntity);
        getEntityManager().flush();
        return paymentTransferEntity;
    }
    
}
