package de.th.wildau.webapp.buchladen.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import org.apache.commons.validator.EmailValidator;

/**
 *
 * @author Jan
 */
public class EmailAddressValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        EmailValidator validator = EmailValidator.getInstance();
        if (!validator.isValid(value.toString())) {
            FacesMessage facesMessage = new FacesMessage(component.getClientId() + ": Überprüfungsfehler: Wert ist keine E-Mail Adresse");
            throw new ValidatorException(facesMessage);
        }
    }
    
}
