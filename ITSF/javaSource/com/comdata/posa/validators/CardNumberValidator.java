package com.comdata.posa.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.comdata.posa.util.CommonUtil;

public class CardNumberValidator implements Validator{
	public CardNumberValidator(){

	}
	/**
	 * Validation for valid card Number.
	 * @param FacesContext-current instance,UIComponent-component on which the validation is to be checked,Object- value of the
	 * component
	 * @author TCS
	 */
	public void validate(FacesContext context, UIComponent component,Object value){
		String cardnumber = (String) value;
		boolean flag=false;
		/*
		 * validating Card number for blank  or number
		 */
		String compName = (String) component.getAttributes().get("fieldRef");
		if(cardnumber==null){
			FacesMessage message = new FacesMessage();
			message.setSummary(compName +" "+CommonUtil.getProperty(ValidtaorsConstant.EMPTY_FIELD));
			throw new ValidatorException(message);
		}
		else {
			Matcher m = Pattern.compile("[^\\d\\s.-]").matcher(cardnumber);		
			if (m.find()){
				FacesMessage message = new FacesMessage();
				message.setSummary(compName +" "+CommonUtil.getProperty(ValidtaorsConstant.NUMERIC_FIELD));
				throw new ValidatorException(message);
			}
			else{
				if(((cardnumber.trim()).length()<16) ||((cardnumber.trim()).length()>16) ){
					FacesMessage message = new FacesMessage();
					message.setSummary(compName +" "+CommonUtil.getProperty(ValidtaorsConstant.CARD_LENGTH));
					throw new ValidatorException(message);
				}
				else{
					//flag=cardnumber.startsWith(Resources.GIFT_CARD_NUMBER);
					/**
					 *  checking  multiple Series for gift Card Number from Properties file
					 */
					String []gcard=null;
					String cardSeries=CommonUtil.getProperty(ValidtaorsConstant.GIFT_CARD_NUMBER);
					if(cardSeries!=null){
						if(cardSeries.contains(ValidtaorsConstant.COMMA)){
							gcard=cardSeries.split(ValidtaorsConstant.COMMA);
						 int length=gcard.length;
						 for( int cnt=0;cnt<length;cnt++){
							 flag=cardnumber.startsWith(gcard[cnt]);
							 if(flag)
								 break;
						 }
						}else{
							flag=cardnumber.startsWith(cardSeries);
						}
					}
					//flag=cardnumber.startsWith(CommonUtil.getProperty(Resources.GIFT_CARD_NUMBER));
					if(!flag){
						FacesMessage message = new FacesMessage();
						message.setSummary(compName +" "+CommonUtil.getProperty(ValidtaorsConstant.INVALID_CARD));
						throw new ValidatorException(message);
					}
				}
			}
		}
	}
}
