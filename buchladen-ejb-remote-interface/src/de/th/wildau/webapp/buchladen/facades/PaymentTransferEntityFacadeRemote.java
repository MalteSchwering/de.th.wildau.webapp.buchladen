package de.th.wildau.webapp.buchladen.facades;

import de.th.wildau.webapp.buchladen.entities.PaymentTransferEntity;
import java.util.List;
import javax.ejb.Remote;

/**
 * @author Jan Gabler
 * @author Malte Schwering
 * @version 0.3
 */
@Remote
public interface PaymentTransferEntityFacadeRemote {

    /**
     * Erstellt eine Kontoüberweisungs-Entität.
     * @param paymentTransferEntity Kontoüberweisungs-Entität
     */
    void create(PaymentTransferEntity paymentTransferEntity);
    
    /**
     * Erstellt eine Kontoüberweisungs-Entität.
     * @param paymentTransferEntity Kontoüberweisungs-Entität
     * @return Kontoüberweisungs-Entität mit ID
     */
    PaymentTransferEntity createAndReturnEntity(PaymentTransferEntity paymentTransferEntity);

    /**
     * Modifiziert eine Kontoüberweisungs-Entität.
     * @param paymentTransferEntity Kontoüberweisungs-Entität
     */
    void edit(PaymentTransferEntity paymentTransferEntity);

    /**
     * Löscht eine Kontoüberweisungs-Entität.
     * @param paymentTransferEntity Kontoüberweisungs-Entität
     */
    void remove(PaymentTransferEntity paymentTransferEntity);

    /**
     * Liefert eine bestimmte Kontoüberweisungs-Entität zurück.
     * @param id ID der Kontoüberweisungs-Entität
     * @return Kontoüberweisungs-Entität
     */
    PaymentTransferEntity find(Object id);

    /**
     * Liefert eine Liste aller Kontoüberweisungs-Entitäten zurück.
     * @return Liste von Kontoüberweisungs-Entitäten
     */
    List<PaymentTransferEntity> findAll();

    /**
     * Liefert eine Liste von Kontoüberweisungs-Entitäten aus einem bestimmten Bereich zurück.
     * @param range Bereich
     * @return Liste von Kontoüberweisungs-Entitäten
     */
    List<PaymentTransferEntity> findRange(int[] range);

    /**
     * Liefert die Anzahl an gefundenen Kontoüberweisungs-Entitäten zurück.
     * @return Anzahl gefundender Kontoüberweisungs-Entitäten
     */
    int count();
    
}
