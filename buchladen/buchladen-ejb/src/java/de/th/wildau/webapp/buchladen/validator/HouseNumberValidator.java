package de.th.wildau.webapp.buchladen.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class HouseNumberValidator implements Validator {

    private static final String HOUSENUMBER_REGEX = "\\d{1,4}[a-zA-Z]{0,1}";
    private Pattern pattern;
    private Matcher matcher;

    public HouseNumberValidator() {
        pattern = Pattern.compile(HOUSENUMBER_REGEX);
    }

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        matcher = pattern.matcher(value.toString());
        if(!matcher.matches()) {
            FacesMessage facesMessage = new FacesMessage(component.getClientId());
            throw new ValidatorException(facesMessage);
        }
    }
    
}