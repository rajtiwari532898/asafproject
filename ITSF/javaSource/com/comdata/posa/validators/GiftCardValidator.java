package com.comdata.posa.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class GiftCardValidator implements Validator{
	public GiftCardValidator(){

	}
	/**
	 * Validation for valid card Number.
	 * @param FacesContext-current instance,UIComponent-component on which the validation is to be checked,Object- value of the
	 * component
	 * @author TCS
	 */
	public void validate(FacesContext context, UIComponent component,Object value){
		String cardnumber = (String) value;
		boolean flag;
		/*
		 * validating Card number for Gift card Number series
		 */

		if(cardnumber==null){
			FacesMessage message = new FacesMessage();
			message.setSummary("Card Number can not be Blank .");
			throw new ValidatorException(message);
		}
		else {
			flag=cardnumber.startsWith(ValidtaorsConstant.GIFT_CARD_NUMBER);
			if(!flag){
				FacesMessage message = new FacesMessage();
				message.setSummary("Please enter Gift Card Number");
				throw new ValidatorException(message);
			}			
		}
	}
}
