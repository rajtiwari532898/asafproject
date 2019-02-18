/**
 * 
 */
package com.comdata.posa.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * For validating double values at screen level
 * 
 * @author TCS
 * 
 */
public class DoubleValidator implements Validator {

	/**
	 * Creating a class instance
	 */
	public DoubleValidator() {

	}

	/**
	 * Validation for valid double number
	 * 
	 * @param FacesContext
	 *            -current instance,UIComponent-component on which the
	 *            validation is to be checked,Object- value of the component
	 * @author TCS
	 */
	public void validate(FacesContext context, UIComponent component,
			Object value) {
		String username = (String) value.toString();
		/*
		 * Double Validation
		 */
		Pattern p = Pattern.compile("^(\\d|)*\\.?\\d*$");
		Matcher m = p.matcher(username);
		boolean matchFound = m.matches();

		if (!matchFound) {
			FacesMessage message = new FacesMessage();
			String compName7 = (String) component.getAttributes().get(
					"fieldRef");
			String compName3 = (String) component.getAttributes().get("msgRef");
			message.setSummary(compName7 + ": " + compName3);
			throw new ValidatorException(message);
		}

	}

}
