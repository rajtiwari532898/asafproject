package com.comdata.posa.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.comdata.posa.util.CommonUtil;

public class PostcodeValidation implements Validator{
	public PostcodeValidation(){

	}
	/**
	 * Validation for valid number
	 * @param FacesContext-current instance,UIComponent-component on which the validation is to be checked,Object- value of the
	 * component
	 * @author TCS
	 */
	public void validate(FacesContext context, UIComponent component,Object value){
		String useInp =  (String) value.toString();
		/*Post code Validation 
		 */
		FacesMessage message = new FacesMessage();
		String compName = (String) component.getAttributes().get("fieldRef");
		// Check the empty and null value
		if(useInp==null || useInp.equals("")){			
			message.setSummary(compName +" "+CommonUtil.getProperty(ValidtaorsConstant.EMPTY_FIELD));
			throw new ValidatorException(message);
		}
		else{
			// Match the pattern
			Pattern p = Pattern.compile("[0-9]*");
			Matcher m = p.matcher(useInp);
			boolean matchFound = m.matches();
			if (!matchFound){
				message.setSummary(compName +" "+CommonUtil.getProperty(ValidtaorsConstant.INVALID_FIELD));
				throw new ValidatorException(message);
			}
			else{
				// Check the length of Post code
				if(((useInp.trim()).length()<5)||((useInp.trim()).length()>5)){					
					message.setSummary(compName +" "+CommonUtil.getProperty(ValidtaorsConstant.POSTAL_LENGTH));
					throw new ValidatorException(message);
				}
			}
		}

	}


}
