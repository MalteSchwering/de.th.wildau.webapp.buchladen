/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.th.wildau.webapp.buchladen.facades;

import de.th.wildau.webapp.buchladen.entities.PaymentCreditCardEntity;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Jan
 */
@Remote
public interface PaymentCreditCardEntityFacadeRemote {

    void create(PaymentCreditCardEntity paymentCreditCardEntity);

    void edit(PaymentCreditCardEntity paymentCreditCardEntity);

    void remove(PaymentCreditCardEntity paymentCreditCardEntity);

    PaymentCreditCardEntity find(Object id);

    List<PaymentCreditCardEntity> findAll();

    List<PaymentCreditCardEntity> findRange(int[] range);

    int count();
    
}
