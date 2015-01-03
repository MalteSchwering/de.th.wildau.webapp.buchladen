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
public class CommentValidator implements Validator {

    /**
     * Regulärer Ausdruck vom Kommentar.
     * Er verbietet alles außer ein Kommentar mit mindestens ein Wort, jedoch
     * lediglich 250 Zeichen. Sonderzeichen die genutzt werden dürfen sind ?!.?-,
     */
    private static final String COMMENT_REGEX = "[\\d\\w\\sßäüöÄÜÖ?!,-.]{1,250}";

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
    public CommentValidator() {
        pattern = Pattern.compile(COMMENT_REGEX);
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
