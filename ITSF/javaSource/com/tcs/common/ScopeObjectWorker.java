package com.tcs.common;

import java.util.Map;

import javax.faces.application.Application;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;


import com.icesoft.faces.context.DisposableBean;

/**
 * Used for fetching/removing Objects from various scopes
 * 
 * @author TCS
 * 
 */
public final class ScopeObjectWorker {

	private static final Logger M_LOGGER = Logger.getLogger(ScopeObjectWorker.class);
	private static ScopeObjectWorker instance = new ScopeObjectWorker();

	/**
	 * Creates a new instance of ScopedObjectWorker
	 */
	private ScopeObjectWorker() {
	}

	public static ScopeObjectWorker getInstance() {
		return instance;
	}

	/**
	 * For removing managed bean from request scope
	 * 
	 * @param managedBeanName
	 */
	public static void removeIceFacesExtendedRequestScopeBean(
			String managedBeanName) {

		Object bean = getBean(managedBeanName);
		
		if (bean instanceof DisposableBean) {

			try {
				((DisposableBean) bean).dispose();
			} catch (Exception e) {
				M_LOGGER.error("*******Error occured in ScopeObjectWorker."
						+ "removeIceFacesExtendedRequestScopeBean()**==>>"
						+ e.getMessage());
			}

		}
		setBean(managedBeanName, null);
		getExternalContext().getRequestMap().remove(managedBeanName);
	}

	/**
	 * For removing managed bean from session scope
	 * 
	 * @param managedBeanName
	 */
	public static void removeIceFacesExtendedSessionScopeBean(
			String managedBeanName) {

		Object bean = getBean(managedBeanName);

		if (bean instanceof DisposableBean) {

			try {
				((DisposableBean) bean).dispose();
			} catch (Exception e) {
				M_LOGGER
						.error("*******Error occured in "
								+ "ScopeObjectWorker.removeIceFacesExtendedSessionScopeBean()**==>>"
								+ e.getMessage());
			}

		}
		setBean(managedBeanName, null);
		getExternalContext().getSessionMap().remove(managedBeanName);
	}

	/**
	 * For retrieving the ELcontext of the managed bean
	 * 
	 * @param name
	 * @return
	 */
	protected static Object getBean(String name) {
		/*
		 * getApplication().getELResolver().setValue(getELContext(), null, name,
		 * value);
		 */
		return getApplication().getVariableResolver().resolveVariable(
				getFacesContext(), name);
	}

	/*
	 * For setting the ELcontext of the managed bean
	 * 
	 * @param name
	 * 
	 * @param value
	 */
	protected static void setBean(String name, Object value) {
		M_LOGGER.info(" SetBean in ScopeObjectWorker ");
	}

	/**
	 * Retrieving the ELContext
	 * 
	 * @return
	 */
	

	/**
	 * For retrieving faces external context
	 * 
	 * @return
	 */
	protected static ExternalContext getExternalContext() {
		return FacesContext.getCurrentInstance().getExternalContext();
	}

	/**
	 * For retrieving application
	 * 
	 * @return
	 */
	protected static Application getApplication() {
		return FacesContext.getCurrentInstance().getApplication();
	}

	/**
	 * For retrieving Current FacesContext instance
	 */
	protected static FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}

	/**
	 * This method is called to remove the beans from request/session scope on
	 * click of a menu or quick link
	 */
	public static void removeBeanFromScope() {
		M_LOGGER.debug("*******in removeBeanFromScope*******");
		
		 
			ScopeObjectWorker
			.removeIceFacesExtendedRequestScopeBean("editProfile");
			ScopeObjectWorker
			.removeIceFacesExtendedRequestScopeBean("mainMenu");
			ScopeObjectWorker
			.removeIceFacesExtendedRequestScopeBean("footer");
			ScopeObjectWorker
			.removeIceFacesExtendedRequestScopeBean("transDet");
			ScopeObjectWorker
			.removeIceFacesExtendedRequestScopeBean("resourceBean");
			ScopeObjectWorker
			.removeIceFacesExtendedRequestScopeBean("contactUsBean");
			ScopeObjectWorker
			.removeIceFacesExtendedRequestScopeBean("cardLogin");
			
			M_LOGGER.debug("*removeIceFacesExtendedSessionScopeBean(<managed-bean-name>)***");
		
	}

	/**
	 * To retrieve object from specified scope
	 * 
	 * @param identifier
	 * @param scopeType
	 * @param facesContext
	 * @return
	 */
	public static Object retrieveObjectFromScope(String identifier,
			ScopeType scopeType, FacesContext facesContext) {
		Object retVal = null;
		if (scopeType != null) {
			switch (scopeType) {
			case REQUEST:

				HttpServletRequest request = (HttpServletRequest) facesContext
						.getExternalContext().getRequest();

				retVal = request.getAttribute(identifier);
				break;

			case SESSION:

				HttpSession session = (HttpSession) facesContext
						.getExternalContext().getSession(false);

				retVal = session.getAttribute(identifier);
				break;

			case APPLICATION:

				ServletContext context = (ServletContext) facesContext
						.getExternalContext().getContext();

				retVal = context.getAttribute(identifier);
				break;

			default:
				break;
			}
		}
		return retVal;
	}

	/**
	 * Retrives and Removes the object from the faces context scopes
	 */

	public static Object retrieveAndRemoveObjectFromScope(String identifier,
			ScopeType scopeType, FacesContext facesContext) {
		Object retVal = null;
		if (scopeType != null) {

			switch (scopeType) {
			case REQUEST:
				HttpServletRequest request = (HttpServletRequest) facesContext
						.getExternalContext().getRequest();
				retVal = request.getAttribute(identifier);
				request.removeAttribute(identifier);
				break;

			case SESSION:
				HttpSession session = (HttpSession) facesContext
						.getExternalContext().getSession(false);
				retVal = session.getAttribute(identifier);
				session.removeAttribute(identifier);
				break;

			case APPLICATION:
				ServletContext context = (ServletContext) facesContext
						.getExternalContext().getContext();
				retVal = context.getAttribute(identifier);
				context.removeAttribute(identifier);
				break;

			default:
				break;
			}
		}
		return retVal;
	}

	/**
	 * Set the object from the faces context scopes
	 */

	public static void setObjectInScope(String name, Object object,
			ScopeType scopeType, FacesContext facesContext) {
		if (scopeType != null) {
			switch (scopeType) {
			case REQUEST:
				Map<String, Object> requestMap = facesContext
						.getExternalContext().getRequestMap();
				requestMap.put(name, object);
				break;

			case SESSION:
				Map<String, Object> sessionMap = facesContext
						.getExternalContext().getSessionMap();
				sessionMap.put(name, object);
				break;

			case APPLICATION:
				Map<String, Object> contextMap = facesContext
						.getExternalContext().getApplicationMap();
				contextMap.put(name, object);
				break;

			default:
				break;
			}
		}

	}

	/**
	 * Remove the object from the faces context scopes
	 */

	public static void removeObjectFromScope(String name, ScopeType scopeType,
			FacesContext facesContext) {
		if (scopeType != null) {
			switch (scopeType) {
			case REQUEST:
				Map<String, Object> requestMap = facesContext
						.getExternalContext().getRequestMap();
				requestMap.remove(name);
				break;

			case SESSION:
				Map<String, Object> sessionMap = facesContext
						.getExternalContext().getSessionMap();
				sessionMap.remove(name);
				break;

			case APPLICATION:
				Map<String, Object> contextMap = facesContext
						.getExternalContext().getApplicationMap();
				contextMap.remove(name);
				break;

			default:
				break;
			}
		}
	}

}
