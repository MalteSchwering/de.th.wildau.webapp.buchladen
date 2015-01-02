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
    public static final String CREDITCARDNUMBER_REGEX = "[3-6]{1}\\d{3}[\\s-]?\\d{4}[\\s-]?\\d{4}[\\s-]?\\d{3,4}";

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
        if(!matcher.matches()||!isLuhnValid(value.toString())) {
            FacesMessage facesMessage = new FacesMessage(component.getClientId());
            throw new ValidatorException(facesMessage);
        }
    }
    
    /**
     * Wandelt Kreditkartennummer von Strin in Int-Array und ruft die luhnAlgorithm
     * Funktion auf, liefert true, wenn Luhn-Algorithmus erfolgreich, false sonst.
     * @param String creditCardNumber
     * @return boolean isLuhnValid
     */
    private boolean isLuhnValid(String creditCardNumber){
        boolean isValid = false;
        int[] creditCardDigits = new int[(creditCardNumber.length())];
        for(int i=0;i<creditCardDigits.length;i++){
            creditCardDigits[i] = Character.getNumericValue(creditCardNumber.charAt(i));           
        }
        isValid = this.luhnAlgorithm(creditCardDigits);
        return isValid;
    }
    
    /**
     * Implementierung des Luhn-Algorithmus. Liefert true, wenn letzte Zahl
     * (Prüfzahl) mit restlicher Zahlenkombination übereinstimmt.
     * @param int[] digits
     * @return boolean true or false
     */
    private boolean luhnAlgorithm(int[] digits) {
       int sum = 0;
       int length = digits.length;
       for (int i = 0; i < length; i++) {
 
           // get digits in reverse order
           int digit = digits[length - i - 1];
 
           // every 2nd number multiply with 2
           if (i % 2 == 1) {
               digit *= 2;
           }
           sum += digit > 9 ? digit - 9 : digit;
       }
       return sum % 10 == 0;
   }
    
}

