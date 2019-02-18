/**
 * 
 */
package com.tcs.common;

import java.text.MessageFormat;
import java.util.Iterator;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.component.EditableValueHolder;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tcs.dvt.constant.DvtConstants;



/**
 * Used for overriding default messages thrown by ICEfaces
 * @author TCS
 * @version
 */
public class MessageListener implements PhaseListener {

	/**
	 * Class Variable declarations
	 */
	//private static Logger logger = Logger.getLogger(MessageListener.class);
	private static final long serialVersionUID = 1L;

	public MessageListener() {

	}

	/**
	 * Called after every JSF phase
	 */
	public void afterPhase(PhaseEvent arg0) {		
		
	}

	/**
	 * Called before every JSF phase
	 */
	@SuppressWarnings("unchecked")
	public void beforePhase(PhaseEvent e) {
		FacesContext fc = e.getFacesContext();
		
		UIViewRoot root = fc.getViewRoot();
		String mbName = fc.getApplication().getMessageBundle();
		Locale locale = null;
		if (null != root) {
			locale = root.getLocale();
		}
		ResourceBundle rb = ResourceBundle.getBundle(mbName, locale);
		Object[] params = null;
		Object[] params1 = null;
		String custMsg1 = null,fieldRef = null,custMsg = null,detail = null,custMsgPattern = null,clientId = null;
		Iterator<FacesMessage> j = null;
		Iterator<String> i = fc.getClientIdsWithMessages();
		
		UIComponent c = null;
			while (i.hasNext()) {
				clientId = i.next();
				if (root != null && clientId != null) {
					c = root.findComponent(clientId);
					
					if(null!=c){
					fieldRef = (String) c.getAttributes().get("fieldRef");
					if (fieldRef != null) {
						j = fc.getMessages(clientId);
						
						while (j.hasNext()) {
							FacesMessage fm = j.next();
							detail = fm.getDetail();
							params1 = new Object[1];
							params1[0] = ((EditableValueHolder) c).getSubmittedValue();
							custMsg1 = MessageFormat.format(detail, params1);
							fm.setDetail(custMsg1);
							if ("CONV_ERR_MSG".equals(detail)) {
								custMsgPattern = rb.getString("CUST_CONV_ERR_MSG_detail");
								params = new Object[1];
								params[0] = ((EditableValueHolder) c).getSubmittedValue();
								custMsg = MessageFormat.format(custMsgPattern,params);
								fm.setDetail(custMsg);
							} else if ("VALUE_REQ_MSG".equals(detail)) {
								custMsg = (String) c.getAttributes().get(
								"custMsg");
								fm.setDetail(custMsg);
							}
							params1[0] = fieldRef;
							custMsg1 = MessageFormat.format(detail, params1);
							fm.setDetail(custMsg1);
							fm.setDetail(fm.getDetail());
						}
					}else{
						setMsg(fc, clientId);
					}
				}else{
					setMsg(fc, clientId);
				}
			}
			}// end of While
			



	}

	@SuppressWarnings("unchecked")
	private void setMsg(FacesContext fc, String clientId) {
		Object[] params1;
		String custMsg1;
		String detail;
		Iterator<FacesMessage> j;
		String[] clientIds=clientId.split(DvtConstants.COLON);
		if(clientIds!=null && clientIds.length!=0){
			params1 = new Object[1];
			params1[0] = clientIds[clientIds.length-1].replace(
					DvtConstants.HYPHEN, DvtConstants.SINGLE_SPACE);
		}else{
			params1 = new Object[1];
			params1[0] =clientId.replace(DvtConstants.HYPHEN, DvtConstants.SINGLE_SPACE);
		}
		j = fc.getMessages(clientId);
		while (j.hasNext()) {
			FacesMessage fm = j.next();
			detail = fm.getDetail();
			custMsg1 = MessageFormat.format(detail, params1);
			fm.setDetail(custMsg1);
		}
	}

	/**
	 * Gets the Phase Id of the current JSF phase
	 */
	public PhaseId getPhaseId() {
		return PhaseId.RENDER_RESPONSE;
	}

}
