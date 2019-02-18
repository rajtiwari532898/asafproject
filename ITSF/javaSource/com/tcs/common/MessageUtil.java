/**
 * MessageUtil.java
 * Created on 27/07/2010
 */
package com.tcs.common;

import java.text.FieldPosition;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;


import com.tcs.dvt.constant.DvtConstants;

import org.apache.log4j.Logger;


/**
 * Used for returning the message string from the resource bundle configured
 * 
 * @author TCS
 * 
 */
public final class MessageUtil {

	private static Logger logger = Logger.getLogger(MessageUtil.class);

	/**
	 * Creating a new instance
	 */
	private MessageUtil() {

	}

	/**
	 * Classloader for an object String
	 * 
	 * @param defaultObject
	 * @return
	 */
	protected static ClassLoader getCurrentClassLoader(Object defaultObject) {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		if (loader == null) {
			loader = defaultObject.getClass().getClassLoader();
		}
		return loader;
	}

	/**
	 * To return Message string from resource bundle
	 * 
	 * @param bundleName
	 * @param key
	 * @param locale
	 * @return
	 */
	public static FacesMessage getMessageResourceString(String bundleName,
			String key, Locale locale) {
		FacesMessage message = new FacesMessage();
		String text = null;
		ResourceBundle bundle = ResourceBundle.getBundle(bundleName, locale);
		try {
			text = bundle.getString(key);
			message = new FacesMessage(text);
		} catch (MissingResourceException e) {
			text = DvtConstants.KEY1 + key + DvtConstants.NOT_FOUND;
			logger.error(e.getMessage() + text);
		}
		message.setSeverity(FacesMessage.SEVERITY_ERROR);
		return message;
	}

	/**
	 * To return string from resource bundle
	 * 
	 * @param bundleName
	 * @param key
	 * @param locale
	 * @return
	 */
	public static String getResourceString(String bundleName, String key,
			Locale locale) {
		String text = null;
		ResourceBundle bundle = ResourceBundle.getBundle(bundleName, locale);
		try {
			text = bundle.getString(key);
		} catch (MissingResourceException e) {
			text = DvtConstants.KEY1 + key + DvtConstants.NOT_FOUND;
			logger.error(e.getMessage() + text);
		}
		return text;
	}

	/**
	 * To return FacesMessage from resource bundle
	 * 
	 * @param facesContext
	 * @param messageId
	 * @param args
	 * @return
	 */
	public static FacesMessage facesMessage(FacesContext facesContext,
			String messageId, Object args) {

		Severity severity = FacesMessage.SEVERITY_ERROR;
		Locale locale = facesContext.getViewRoot().getLocale();
		String bundleName = facesContext.getApplication().getMessageBundle();
		ResourceBundle bundle = ResourceBundle.getBundle(bundleName, locale);
		StringBuffer sb = new StringBuffer();
		MessageFormat mf = new MessageFormat(bundle.getString(messageId),
				locale);
		String summary = mf.format(args, sb, new FieldPosition(0)).toString();
		try {
			return new FacesMessage(FacesMessage.SEVERITY_ERROR, null, summary);
		} catch (MissingResourceException e) {
			FacesMessage msg = new FacesMessage(summary);
			msg.setSeverity(severity);
			return msg;
		}
	}
	

}
