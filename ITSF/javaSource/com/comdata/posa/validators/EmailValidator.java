package com.comdata.posa.validators;

/**
 * 
 * @param Validation for valid email address
 * @author averma
 * @throws ValidatorException
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.comdata.posa.util.CommonUtil;
public class EmailValidator implements Validator{

	//private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,4})$";
	private static final String EMAIL_PATTERN ="^[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$";
	public EmailValidator(){
		
	}

	/**
	 * Validation for valid email
	 * @param FacesContext-current instance,UIComponent-component on which the validation is to be checked,Object- value of the
	 * component
	 * @author TCS
	 */
	public void validate(FacesContext context, UIComponent component,Object value){
		String enteredEmail = (String)value;
		/*  
		Email format: A valid email address will have following format:  
		        [\\w\\.-]+: Begins with word characters, (may include periods,%,_ and hyphens).  
		    @: It must have a '@' symbol after initial characters.
		    ([\\w\\-]+\\.)+: '@' must follow by more alphanumeric characters (may include hyphens).  
		This part must also have a "." to separate domain and sub domain names.  
		    [A-Z]{2,4}$ : Must end with two to four alphabets.  
		(This will allow domain names with 2, 3 and 4 characters e.g pa, com, net, wxyz)  
		
		 */   
	
		Pattern p = Pattern.compile(EMAIL_PATTERN,Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(enteredEmail);
		FacesMessage message = new FacesMessage();
		String compName2 = (String) component.getAttributes().get("fieldRef");
		boolean matchFound = m.matches();
		if(enteredEmail==null || enteredEmail.equals("")){			
			//message.setSummary(compName2+": Please enter value.");
			message.setSummary(compName2 +" "+CommonUtil.getProperty(ValidtaorsConstant.EMPTY_FIELD));
			throw new ValidatorException(message);
		}else{
			if (!matchFound){				
				message.setSummary(compName2 +" "+CommonUtil.getProperty(ValidtaorsConstant.INVALID_FIELD));
				throw new ValidatorException(message);
			}
		}
	}

}
