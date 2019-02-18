package com.comdata.posa.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.comdata.posa.util.CommonUtil;


public class StateValidation implements Validator{
	public StateValidation(){

	}
	/**
	 * Validation for valid name
	 * @param FacesContext-current instance,UIComponent-component on which the validation is to be checked,Object- value of the
	 * component
	 * @author TCS
	 */
	public void validate(FacesContext context, UIComponent component,Object value){
		String stateInp = (String) value;
		
		/*string only with multiple values with space
		 * e.g nameA AB,name
		 */
		Pattern p = Pattern.compile("[a-zA-Z]*");
		Matcher m = p.matcher(stateInp);
		boolean matchFound = m.matches();
		FacesMessage message = new FacesMessage();
		String compName6 = (String) component.getAttributes().get("fieldRef");
		
		if(stateInp==null || stateInp.equals("")){			
			message.setSummary(compName6 +" "+CommonUtil.getProperty(ValidtaorsConstant.EMPTY_FIELD));
			throw new ValidatorException(message);
		}
		else{
			if (!matchFound){
				/*FacesMessage message = new FacesMessage();
				String compName6 = (String) component.getAttributes().get("fieldRef");*/
				message.setSummary(compName6 +" "+CommonUtil.getProperty(ValidtaorsConstant.INVALID_FIELD));
				throw new ValidatorException(message);
			}else{
				// Check the length of state
				if(((stateInp.trim()).length()<2)||((stateInp.trim()).length()>2)){
					/*FacesMessage message = new FacesMessage();
					String compName = (String) component.getAttributes().get("fieldRef");*/
					message.setSummary(compName6 +" "+CommonUtil.getProperty(ValidtaorsConstant.STATE_LENGTH));
					throw new ValidatorException(message);
				}
			}
		}
	}


}
