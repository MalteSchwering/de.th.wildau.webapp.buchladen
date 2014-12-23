/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.th.wildau.webapp.buchladen.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Jan Gabler
 * @author Malte Schwering
 * @version 0.1
 */
public class CreditCardNumberValidator implements Validator{
    
    /**
     * Regulärer Ausdruck der Kreditkartennummer.
     * Er verbietet alles außer eine Kreditkartennummer aus den jeweiligen
     * Unternehmen.
     */
    private static final String CREDITCARDNUMBER_REGEX = "[3-6]{1}\\d{3}[\\s-]?\\d{4}[\\s-]?\\d{4}[\\s-]?\\d{3,4}";

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
    public CreditCardNumberValidator() {
        pattern = Pattern.compile(CREDITCARDNUMBER_REGEX);
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

