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
public class CreditCardMonthValidator implements Validator{
    
    /**
     * Regulärer Ausdruck vom Kreditkarten Ablauf-Monat.
     * Er verbietet alles außer einen Monat.
     */
    public static final String MONTH_REGEX = "^([1-9]|[0-1][0-2])$";

    /**
     * Kompilierte Repräsentation des regulären Ausdrucks.
     */
    private final Pattern pattern;

    /**
     * Konstruktor der den regulären Ausdruck kompiliert.
     */
    public CreditCardMonthValidator() {
        pattern = Pattern.compile(MONTH_REGEX);
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
        Matcher matcher = pattern.matcher(value.toString());
        if(!matcher.matches()) {
            FacesMessage facesMessage = new FacesMessage(component.getClientId());
            throw new ValidatorException(facesMessage);
        }
    }
    
}

