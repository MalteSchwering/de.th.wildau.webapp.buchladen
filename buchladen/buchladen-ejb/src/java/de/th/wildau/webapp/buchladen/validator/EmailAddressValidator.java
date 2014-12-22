package de.th.wildau.webapp.buchladen.validator;

import de.th.wildau.webapp.buchladen.facades.RegisteredUserEntityFacadeRemote;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
 * @version 0.1
 */
public class EmailAddressValidator implements Validator {
    
    /**
     * Enterprise Java Bean registeredUserEntityFacade.
     */
    RegisteredUserEntityFacadeRemote registeredUserEntityFacade = lookupRegisteredUserEntityFacadeRemote();
    
    /**
     * Regulärer Ausdruck der E-Mail Adresse.
     * Er verbietet alles außer einer normalen E-Mail-Adresse.
     */
    private static final String EMAIL_ADDRESS_REGEX = "[\\w|.|-]*@\\w*\\.[\\w|.]*";

    /**
     * Kompilierte Repräsentation des regulären Ausdrucks.
     */
    private final Pattern pattern;

    /**
     * Match Engine.
     */
    private Matcher matcher;

    /**
     * Konstruktor der den regulären Ausdruck kompiliert.
     */
    public EmailAddressValidator() {
        pattern = Pattern.compile(EMAIL_ADDRESS_REGEX);
    }

    /**
     * Validiert den Wert des Input Elements.
     * @param context FacesContext
     * @param component User Interface Komponente
     * @param value Wert des Input Elements
     * @throws ValidatorException 
     */
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        matcher = pattern.matcher(value.toString());
        if(!matcher.matches()) {
            FacesMessage facesMessage = new FacesMessage(component.getClientId());
            throw new ValidatorException(facesMessage);
        }
        
        if(value.toString().length() > 250) {
            FacesMessage facesMessage = new FacesMessage(component.getClientId());
            throw new ValidatorException(facesMessage);
        }
        
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
