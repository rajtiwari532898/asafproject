package com.comdata.posa.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.comdata.posa.util.CommonUtil;

public class NumericValidation implements Validator{
	public NumericValidation(){

	}
	/**
	 * Validation for valid number
	 * @param FacesContext-current instance,UIComponent-component on which the validation is to be checked,Object- value of the
	 * component
	 * @author TCS
	 */
	public void validate(FacesContext context, UIComponent component,Object value){
		String username =  (String) value.toString();
		/*Numeric Validation 
		 */
		Pattern p = Pattern.compile("[0-9]*");
		Matcher m = p.matcher(username);
		boolean matchFound = m.matches();
		if (!matchFound){
			FacesMessage message = new FacesMessage();
			String compName = (String) component.getAttributes().get("fieldRef");
			message.setSummary(compName +" "+CommonUtil.getProperty(ValidtaorsConstant.NUMERIC_FIELD));
			throw new ValidatorException(message);
		}

	}


}
