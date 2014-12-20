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
public class NameValidator implements Validator {

    /**
     * Maximale Länge von Namen.
     */
    private int maxLength = 255;

    /**
     * Regulärer Ausdruck vom Namen.
     * Er verbietet alles außer Groß-und Kleinbuchstaben bzw. die Sonderzeichen
     * für eine Namenstrennung '&-
     */
    private static final String NAME_REGEX = "[a-zA-Z '&-]*[A-Za-z]{0,255}";

    /**
     * Nachricht die bei einem invaliden Wert angezeigt wird.
     */
    private String message = "";

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
    public NameValidator() {
        pattern = Pattern.compile(NAME_REGEX);
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
