package de.th.wildau.webapp.buchladen.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * @author Jan Gabler
 * @author Malte Schwering
 * @version 0.3
 */
public class UsernameValidator implements Validator {
    
    /**
     * Regulärer Ausdruck vom Username.
     * Er verbietet alles außer einer normalen E-Mail-Adresse.
     */
    private static final String USERNAME_REGEX = "[\\w|.|-]*@\\w*\\.[\\w|.]*";

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
    public UsernameValidator() {
        pattern = Pattern.compile(USERNAME_REGEX);
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
    }
    
}
