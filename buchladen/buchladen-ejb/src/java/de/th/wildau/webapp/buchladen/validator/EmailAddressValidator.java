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
import org.apache.commons.validator.EmailValidator;

/**
 * @author Jan Gabler
 * @author Malte Schwering
 * @version 0.1
 */
public class EmailAddressValidator implements Validator {
    RegisteredUserEntityFacadeRemote registeredUserEntityFacade = lookupRegisteredUserEntityFacadeRemote();

    /**
     * Validiert den Wert des Input Elements.
     * @param context FacesContext
     * @param component User Interface Komponente
     * @param value Wert des Input Elements
     * @throws ValidatorException 
     */
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        EmailValidator validator = EmailValidator.getInstance();
        if (!validator.isValid(value.toString())) {
            FacesMessage facesMessage = new FacesMessage(component.getClientId() + ": Überprüfungsfehler: Wert ist keine E-Mail Adresse");
            throw new ValidatorException(facesMessage);
        }
        if(this.registeredUserEntityFacade.findByEmailAddress(value.toString()) != null) {
            FacesMessage facesMessage = new FacesMessage(component.getClientId() + ": Überprüfungsfehler: Wert ist keine E-Mail Adresse");
            throw new ValidatorException(facesMessage);
        }
    }

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
