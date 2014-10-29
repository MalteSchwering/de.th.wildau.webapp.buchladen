/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.th.wildau.webapp.buchladen.facades;

import de.th.wildau.webapp.buchladen.entities.PaymentCreditCardEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jan
 */
@Stateless
public class PaymentCreditCardEntityFacade extends AbstractFacade<PaymentCreditCardEntity> implements de.th.wildau.webapp.buchladen.facades.PaymentCreditCardEntityFacadeRemote {
    @PersistenceContext(unitName = "buchladen-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PaymentCreditCardEntityFacade() {
        super(PaymentCreditCardEntity.class);
    }
    
}
