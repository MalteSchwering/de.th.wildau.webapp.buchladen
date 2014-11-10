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
    private static final String NAME_REGEX = "[\\w\\s-]{0,255}";
    private Pattern pattern;
    private Matcher matcher;

    public NameValidator() {
        pattern = Pattern.compile(NAME_REGEX);
    }

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        matcher = pattern.matcher(value.toString());
        if(!matcher.matches()) {
            FacesMessage facesMessage = new FacesMessage(component.getClientId() 
                    + ": Überprüfungsfehler: Wert beinhaltet ungültige Zeichen, es sind nur Groß-/Kleinbuchstaben, Bindestriche und Leerzeichen erlaubt");
            throw new ValidatorException(facesMessage);
        }
        if(value.toString().length() > maxLength) {
            FacesMessage facesMessage = new FacesMessage(component.getClientId() 
                    + ": Überprüfungsfehler: Wert ist zu lang");
            throw new ValidatorException(facesMessage);
        }
    }
    
}
