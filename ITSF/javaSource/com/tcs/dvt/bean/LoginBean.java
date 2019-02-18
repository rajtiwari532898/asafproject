package com.tcs.dvt.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlPanelGroup;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;



import com.comdata.posa.util.CommonUtil;
import com.tcs.dvt.constant.DvtConstants;

public class LoginBean {

	private static final Logger M_LOGGER = Logger.getLogger(LoginBean.class);
	private String screenId = DvtConstants.LOGIN_SCREEN_ID;
	
	private FacesContext context = FacesContext.getCurrentInstance();
	private HttpSession session = (HttpSession) context.getExternalContext().getSession(true);

	
	private String userId;
	private String password;
	
	
	public String getScreenId() {
		return screenId;
	}
	
	//@SuppressWarnings("unchecked")
	public String getHomePage(){
		String 	 screenNav=null;
		M_LOGGER.debug("Validate User credential");
		System.out.println("Validate User credential");
		//TODO Validate user credential
		if(null!=userId && userId.equals("Admin")
				&& null!=password && password.equals("Admin")){
			screenNav=DvtConstants.HOME_NAV;
		}else{
			DvtConstants.showMessages(DvtConstants.LOGIN_SCREEN,CommonUtil.getProperty(DvtConstants.INVALID_LOGIN));
			screenNav=DvtConstants.LOGOUT_NAV;
		}
		
				
		return screenNav;
	}
	
	
	public void setScreenId(String screenId) {
		this.screenId = screenId;
	}
	public FacesContext getContext() {
		return context;
	}
	public void setContext(FacesContext context) {
		this.context = context;
	}
	public HttpSession getSession() {
		return session;
	}
	public void setSession(HttpSession session) {
		this.session = session;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
