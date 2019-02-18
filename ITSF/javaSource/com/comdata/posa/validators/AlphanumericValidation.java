package com.comdata.posa.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.comdata.posa.util.CommonUtil;


public class AlphanumericValidation implements Validator{
	
	public AlphanumericValidation(){
		
	}
	/**
	 * Validation for valid alphanumeric
	 * @param FacesContext-current instance,UIComponent-component on which the validation is to be checked,Object- value of the
	 * component
	 * @author TCS
	 */
	public void validate(FacesContext context, UIComponent component,Object value){
	String username = (String) value;
	/*alphanumeric multiple values with space
	 * e.g nameA AB,name
	 */
	System.out.println("in Alphanumeric validation-->"+username);
	Pattern p = Pattern.compile("[a-zA-Z0-9\\s]*");
	Matcher m = p.matcher(username);
	boolean matchFound = m.matches();
	 FacesMessage message = new FacesMessage();
	 String compName = (String) component.getAttributes().get("fieldRef");
	if(username==null || username.equals("")){		
		message.setSummary(compName +" "+CommonUtil.getProperty(ValidtaorsConstant.EMPTY_FIELD));
		throw new ValidatorException(message);
	}
	else{
		if (!matchFound){		  
			message.setSummary(compName +" "+CommonUtil.getProperty(ValidtaorsConstant.INVALID_FIELD));
			throw new ValidatorException(message);
		   }	
	}
    }
}

