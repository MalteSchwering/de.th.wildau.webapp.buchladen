package de.th.wildau.webapp.buchladen.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import org.apache.commons.validator.EmailValidator;

/**
 * @author Jan Gabler
 * @author Malte Schwering
 * @version 0.1
 */
public class EmailAddressValidator implements Validator {

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
    }
    
}
