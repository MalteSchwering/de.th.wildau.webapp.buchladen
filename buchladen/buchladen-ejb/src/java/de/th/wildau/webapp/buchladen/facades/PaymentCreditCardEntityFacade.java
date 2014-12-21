package de.th.wildau.webapp.buchladen.facades;

import de.th.wildau.webapp.buchladen.entities.PaymentCreditCardEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Jan Gabler
 * @author Malte Schwering
 * @version 0.1
 */
@Stateless
public class PaymentCreditCardEntityFacade extends AbstractFacade<PaymentCreditCardEntity> implements de.th.wildau.webapp.buchladen.facades.PaymentCreditCardEntityFacadeRemote {
    
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
    public PaymentCreditCardEntityFacade() {
        super(PaymentCreditCardEntity.class);
    }
    
    /**
     * Erstellt eine Entität vom Typ PaymentCreditCardEntity.
     * @param paymentCreditCardEntity Entität die erstellt werden soll
     * @return PaymentCreditCardEntity
     */
    @Override
    public PaymentCreditCardEntity createAndReturnEntity(PaymentCreditCardEntity paymentCreditCardEntity) {
        super.create(paymentCreditCardEntity);
        getEntityManager().flush();
        return paymentCreditCardEntity;
    }
    
}
