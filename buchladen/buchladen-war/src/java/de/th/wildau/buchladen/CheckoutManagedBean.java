package de.th.wildau.buchladen;

import de.th.wildau.webapp.buchladen.entities.RegisteredUserEntity;
import de.th.wildau.webapp.buchladen.sessions.CheckoutSessionBeanRemote;
import java.io.Serializable;
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
     * Kauf der Bücher aus dem Warenkorb wird in der CheckoutSessionBean durchgeführt.
     */
    public void buyBooks() {
        CartManagedBean cartManagedBean = (CartManagedBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("cartManagedBean");
        checkoutSessionBean.buyBooks(cartManagedBean.getContent());
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
    
}
