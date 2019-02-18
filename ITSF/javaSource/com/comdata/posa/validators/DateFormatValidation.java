package com.comdata.posa.validators;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.comdata.posa.util.CommonUtil;

public class DateFormatValidation implements Validator{

public DateFormatValidation(){
		
	}

/**
 * Validation for valid Date format
 * @param FacesContext-current instance,UIComponent-component on which the validation is to be checked,
 * Object- value of the component
 * @author TCS
 */
public void validate(FacesContext context, UIComponent component,Object value){
	Date dateInp = (Date) value;
	DateFormat dateFormat = new SimpleDateFormat(ValidtaorsConstant.MM_DD_YYYY_DATE_FORMAT,Locale.getDefault());
	String dateFormatted=dateFormat.format(dateInp);
	
	if(dateFormatted!= null && dateFormatted.length()>10){
	   FacesMessage message = new FacesMessage();
	   String compName = (String) component.getAttributes().get("fieldRef");
	   message.setSummary(compName +" "+CommonUtil.getProperty(ValidtaorsConstant.INVALID_FIELD));
	   throw new ValidatorException(message);
	}
}
}


