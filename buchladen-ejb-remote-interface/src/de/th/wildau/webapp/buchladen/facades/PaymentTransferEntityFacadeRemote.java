/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.th.wildau.webapp.buchladen.facades;

import de.th.wildau.webapp.buchladen.entities.PaymentTransferEntity;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Jan
 */
@Remote
public interface PaymentTransferEntityFacadeRemote {

    void create(PaymentTransferEntity paymentTransferEntity);
    
    PaymentTransferEntity createAndReturnEntity(PaymentTransferEntity paymentTransferEntity);

    void edit(PaymentTransferEntity paymentTransferEntity);

    void remove(PaymentTransferEntity paymentTransferEntity);

    PaymentTransferEntity find(Object id);

    List<PaymentTransferEntity> findAll();

    List<PaymentTransferEntity> findRange(int[] range);

    int count();
    
}
