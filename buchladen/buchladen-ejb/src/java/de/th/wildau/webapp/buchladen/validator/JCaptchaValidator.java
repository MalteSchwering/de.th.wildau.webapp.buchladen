package de.th.wildau.webapp.buchladen.validator;

import de.th.wildau.buchladen.services.CaptchaServiceSingleton;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpSession;

/**
 * @author Jan Gabler
 * @author Malte Schwering
 * @version 0.1
 */
public class JCaptchaValidator implements Validator {

    /**
     * Validiert den Wert des Input Elements.
     * @param context FacesContext
     * @param component User Interface Komponente
     * @param value Wert des Input Elements
     * @throws ValidatorException 
     */
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        String sessionId = session.getId();
        String captcha = value.toString();
        if(!CaptchaServiceSingleton.getInstance().validateResponseForID(sessionId, captcha)) {
            FacesMessage facesMessage = new FacesMessage(component.getClientId() + ": Überprüfungsfehler: Wert des Captchas ist nicht korrekt");
            throw new ValidatorException(facesMessage);
        }
    }

}
