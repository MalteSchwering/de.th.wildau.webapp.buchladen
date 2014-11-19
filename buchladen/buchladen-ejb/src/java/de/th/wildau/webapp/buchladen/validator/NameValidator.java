package de.th.wildau.webapp.buchladen.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class NameValidator implements Validator {
    
    private int maxLength = 255;
    private static final String NAME_REGEX = "[a-zA-Z '&-]*[A-Za-z]";
    private String message = "";
    private Pattern pattern;
    private Matcher matcher;

    public NameValidator() {
        pattern = Pattern.compile(NAME_REGEX);
    }

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        matcher = pattern.matcher(value.toString());
        if(!matcher.matches()) {
            message += "Wert beinhaltet ungültige Zeichen, es sind nur Groß-/Kleinbuchstaben, Bindestriche und Leerzeichen erlaubt";
        }
        if(value.toString().length() > maxLength) {
            message += ", Wert ist zu lang";
        }
        if(!message.isEmpty()) {
            FacesMessage facesMessage = new FacesMessage(component.getClientId() + ": Überprüfungsfehler: " + message);
            throw new ValidatorException(facesMessage);
        }
    }
    
}
