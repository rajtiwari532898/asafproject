package com.comdata.posa.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.comdata.posa.util.CommonUtil;

public class PhoneValidation implements Validator{
	public PhoneValidation(){

	}
	/**
	 * Validation for valid phone no.
	 * @param FacesContext-current instance,UIComponent-component on which the validation is to be checked,Object- value of the
	 * component
	 * @author TCS
	 */
	public void validate(FacesContext context, UIComponent component,Object value){
		String username = (String) value;
		/*Phone Number formats: (nnn)nnn-nnnn; nnn-nnn-nnnn ;(nnn)-nnn-nnnn 
		 *  e.g.(123)456-7890, 123-456-7890,(123)-456-7890 
		 */		
		//Pattern p = Pattern.compile("\\(?(\\d{3})\\)?[-\\s\\) ]+(\\d{3})[-\\s ](\\d{4})$");
		Pattern p = Pattern.compile("^\\(?(\\d{3})\\)?[-\\s ]?(\\d{3})[-\\s ]?(\\d{4})$");
		Matcher m = p.matcher(username);
		boolean matchFound = m.matches();
		if(matchFound && (username.equalsIgnoreCase("0000000000"))){			
				matchFound=false;			
		}
		FacesMessage message = new FacesMessage();
		String comp = (String) component.getAttributes().get("fieldRef");
		if(username==null || username.equals("")){		
			message.setSummary(comp +" "+CommonUtil.getProperty(ValidtaorsConstant.EMPTY_FIELD));
			throw new ValidatorException(message);			
		}else{
			if (!matchFound){
				message.setSummary(comp +" "+CommonUtil.getProperty(ValidtaorsConstant.INVALID_FIELD));				
				throw new ValidatorException(message);
			}
		}
	}
}
