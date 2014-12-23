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
 * @version 0.1
 */
public class BICValidator implements Validator{
    
/**
     * Regulärer Ausdruck der BIC.
     * Er verbietet alles außer ein regelkonformes BIC.
     */
    private static final String BIC_REGEX = "([a-zA-Z]{4}[a-zA-Z]{2}[a-zA-Z0-9]{2}([a-zA-Z0-9]{3})?)";

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
    public BICValidator() {
        pattern = Pattern.compile(BIC_REGEX);
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

