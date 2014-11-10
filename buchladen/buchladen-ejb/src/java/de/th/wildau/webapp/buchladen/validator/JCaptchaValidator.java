package de.th.wildau.webapp.buchladen.validator;

import de.th.wildau.buchladen.services.CaptchaServiceSingleton;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpSession;


public class JCaptchaValidator implements Validator {

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
