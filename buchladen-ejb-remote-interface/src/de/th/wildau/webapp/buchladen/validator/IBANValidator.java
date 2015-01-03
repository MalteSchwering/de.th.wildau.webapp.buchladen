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
public class IBANValidator implements Validator{

    /**
     * Regulärer Ausdruck des IBAN.
     * Er verbietet alles außer eine IBAN-Nummer aus Deutschland und ohne
     * Leerzeichen. 
     */
    public static final String IBAN_REGEX = "\\w{2}\\d{2} ?\\d{4} ?\\d{4} ?\\d{4} ?\\d{4} ?\\d{2}";

    /**
     * Kompilierte Repräsentation des regulären Ausdrucks.
     */
    private Pattern pattern;

    /**
     * Match Engine.
     */
    private Matcher matcher;

    /**
     * Konstruktor der den regulären Ausdruck kompiliert.
     */
    public IBANValidator() {
        pattern = Pattern.compile(IBAN_REGEX);
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
    }
    
}

