package de.th.wildau.buchladen;

import de.th.wildau.webapp.buchladen.entities.PaymentCreditCardEntity;
import de.th.wildau.webapp.buchladen.entities.PaymentTransferEntity;
import de.th.wildau.webapp.buchladen.entities.RegisteredUserEntity;
import de.th.wildau.webapp.buchladen.sessions.CheckoutSessionBeanRemote;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

/**
 * @author Jan Gabler
 * @author Malte Schwering
 * @version 0.1
 */
public class CheckoutManagedBean implements Serializable {
    
    /**
     * Enterprise Java Bean checkoutSessionBean mit einem Remote Interface.
     */
    @EJB
    private CheckoutSessionBeanRemote checkoutSessionBean;
    
    /**
     * Identitfikationsnummer der Zahlungsvariante.
     * 0 = default
     * 1 = Zahlung per Kreditkarte
     * 2 = Zahlung per Kontoüberweisung
     */
    private int paymentVariant = 0;
    
    /**
     * Entität einer Kreditkarten Zahlung.
     */
    private PaymentCreditCardEntity paymentCreditCardEntity = new PaymentCreditCardEntity();
    
    /**
     * Entität einer Kontoüberweisung.
     */
    private PaymentTransferEntity paymentTransferEntity = new PaymentTransferEntity();
    
    /**
     * Kauf der Bücher aus dem Warenkorb wird in der CheckoutSessionBean durchgeführt.
     */
    public void buyBooks() {
        CartManagedBean cartManagedBean = (CartManagedBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("cartManagedBean");
        checkoutSessionBean.buyBooks(cartManagedBean.getContent(), this.paymentVariant, this.paymentCreditCardEntity, this.paymentTransferEntity);
        cartManagedBean.clearCart();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("../../public/index.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(CheckoutManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Liefert die Entität des registrierten Benutzers aus der CheckoutSessionBean zurück.
     * @return Entität des registrierten Benutzers
     */
    public RegisteredUserEntity getRegisteredUserEntity() {
        return checkoutSessionBean.getRegisteredUserEntity();
    }

    /**
     * Setzt die Entität des registrierten Benutzers in der CheckoutSessionBean.
     * @param registeredUserEntity Entität des registrierten Benutzers
     */
    public void setRegisteredUserEntity(RegisteredUserEntity registeredUserEntity) {
        checkoutSessionBean.setRegisteredUserEntity(registeredUserEntity);
    }
    
    /**
     * Liefert die Entität einer Kreditkarten Zahlung zurück.
     * @return Entität einer Kreditkarten Zahlung
     */
    public PaymentCreditCardEntity getPaymentCreditCardEntity() {
        return paymentCreditCardEntity;
    }
    
    /**
     * Setzt die Entität einer Kreditkarten Zahlung.
     * @param paymentCreditCardEntity Entität einer Kreditkarten Zahlung
     */
    public void setPaymentCreditCardEntity(PaymentCreditCardEntity paymentCreditCardEntity) {
        this.paymentCreditCardEntity = paymentCreditCardEntity;
    }
    
    /**
     * Liefert die Entität einer Kontoüberweisung zurück.
     * @return Entität einer Kontoüberweisung
     */
    public PaymentTransferEntity getPaymentTransferEntity() {
        return paymentTransferEntity;
    }
    
    /**
     * Setzt die Entität einer Kontoüberweisung.
     * @param paymentTransferEntity Entität einer Kontoüberweisung
     */
    public void setPaymentTransferEntity(PaymentTransferEntity paymentTransferEntity) {
        this.paymentTransferEntity = paymentTransferEntity;
    }
    
    /**
     * Liefert die Zahlungsvariante zurück.
     * @return Identitfikationsnummer der Zahlungsvariante
     */
    public int getPaymentVariant() {
        return paymentVariant;
    }
    
    /**
     * Setzt die Zahlungsvariante.
     * @param paymentVariant Identitfikationsnummer der Zahlungsvariante
     */
    public void setPaymentVariant(int paymentVariant) {
        this.paymentVariant = paymentVariant;
    }
    
}
