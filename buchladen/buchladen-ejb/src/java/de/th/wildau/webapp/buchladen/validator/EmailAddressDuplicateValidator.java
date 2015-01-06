package de.th.wildau.webapp.buchladen.validator;

import de.th.wildau.webapp.buchladen.facades.RegisteredUserEntityFacadeRemote;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * @author Jan Gabler
 * @author Malte Schwering
 * @version 0.3
 */
public class EmailAddressDuplicateValidator implements Validator {
    
    /**
     * Enterprise Java Bean registeredUserEntityFacade.
     */
    RegisteredUserEntityFacadeRemote registeredUserEntityFacade = lookupRegisteredUserEntityFacadeRemote();
    
    /**
     * Validiert den Wert des Input Elements auf Duplikate.
     * @param context
     * @param component
     * @param value
     * @throws ValidatorException 
     */
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if(registeredUserEntityFacade.findByEmailAddress(value.toString()) != null) {
            FacesMessage facesMessage = new FacesMessage(component.getClientId());
            throw new ValidatorException(facesMessage);
        }
    }
    
    /**
     * Liefert die Remote registeredUserEntityFacade zurück.
     * @return registeredUserEntityFacade
     */
    private RegisteredUserEntityFacadeRemote lookupRegisteredUserEntityFacadeRemote() {
        try {
            Context c = new InitialContext();
            return (RegisteredUserEntityFacadeRemote) c.lookup("java:global/buchladen/buchladen-ejb/RegisteredUserEntityFacade!de.th.wildau.webapp.buchladen.facades.RegisteredUserEntityFacadeRemote");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
