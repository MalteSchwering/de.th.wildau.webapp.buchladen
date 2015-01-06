package de.th.wildau.webapp.buchladen.facades;

import de.th.wildau.webapp.buchladen.entities.PaymentCreditCardEntity;
import java.util.List;
import javax.ejb.Remote;

/**
 * @author Jan Gabler
 * @author Malte Schwering
 * @version 0.3
 */
@Remote
public interface PaymentCreditCardEntityFacadeRemote {

    /**
     * Erstellt eine Kreditkarten-Entität.
     * @param paymentCreditCardEntity Kreditkarten-Entität
     */
    void create(PaymentCreditCardEntity paymentCreditCardEntity);
    
    /**
     * Erstellt eine Kreditkarten-Entität.
     * @param paymentCreditCardEntity Kreditkarten-Entität
     * @return Kreditkarten-Entität mit ID
     */
    PaymentCreditCardEntity createAndReturnEntity(PaymentCreditCardEntity paymentCreditCardEntity);

    /**
     * Modifiziert eine Kreditkarten-Entität.
     * @param paymentCreditCardEntity Kreditkarten-Entität
     */
    void edit(PaymentCreditCardEntity paymentCreditCardEntity);

    /**
     * Löscht eine Kreditkarten-Entität.
     * @param paymentCreditCardEntity Kreditkarten-Entität
     */
    void remove(PaymentCreditCardEntity paymentCreditCardEntity);

    /**
     * Liefert eine bestimmte Kreditkarten-Entität zurück.
     * @param id ID der Kreditkarten-Entität
     * @return Kreditkarten-Entität
     */
    PaymentCreditCardEntity find(Object id);

    /**
     * Liefert eine Liste aller Kreditkarten-Entitäten zurück.
     * @return Liste von Kreditkarten-Entitäten
     */
    List<PaymentCreditCardEntity> findAll();

    /**
     * Liefert eine Liste von Kreditkarten-Entitäten aus einem bestimmten Bereich zurück.
     * @param range bereich
     * @return Liste von Kreditkarten-Entitäten
     */
    List<PaymentCreditCardEntity> findRange(int[] range);

    /**
     * Liefert die Anzahl an gefundenen Kreditkarten-Entitäten zurück.
     * @return Anzahl gefundender Kreditkarten-Entitäten
     */
    int count();
    
}
