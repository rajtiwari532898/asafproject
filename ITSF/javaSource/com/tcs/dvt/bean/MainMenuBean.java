/**
 * 
 */
package com.tcs.dvt.bean;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;


import com.tcs.dvt.constant.DvtConstants;

/**
 * @author 195964
 *
 */
public class MainMenuBean {
		private static Logger logger = Logger.getLogger(MainMenuBean.class);
		private String screenNav;
		private FacesContext context = FacesContext.getCurrentInstance();
		private HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
	/**
	 * Constructor 
	 */
	public MainMenuBean() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @function for logout from application
	 */	
public String logout(){		
		try{			
			session.removeAttribute(DvtConstants.VALID_CARD);
			session.invalidate();
			screenNav=DvtConstants.LOGOUT_NAV;
		}catch(Exception ex){
			logger.debug(ex.getMessage());
		}
		return screenNav;
	}
/**
  *  @ function to navigate to homepage
  */
public String homePage(){
	screenNav=DvtConstants.HOME_NAV;
	return screenNav;	
}

/**
 *  @ function to navigate to portfolio Management
 */
public String portfolioMgm(){
	screenNav=DvtConstants.PORTFOLIO_NAV;
	return screenNav;	
}


/**
 * @function for MyProfile
 */	
/*public String editProfile(){	
	
	try{
		Cardholder cardHolder=(Cardholder)session.getAttribute("cardHolderDet");
		if(cardHolder==null){
			screenNav=DvtConstants.LOGIN_SCREEN_ID;
		}
		else
			screenNav=DvtConstants.EDIT_PROFILE;
	}catch(Exception ex){
		logger.debug(ex.getMessage());
	}
	return screenNav;
}*/
/**
 * @function for navigating to login page 
 */	
public String loginPage(){		
	screenNav=DvtConstants.LOGIN_SCREEN;
	return screenNav;
}
public String userRegistration(){		
	screenNav=DvtConstants.USER_REGISTRATION;
	return screenNav;
}

public String dbConfig(){		
	screenNav=DvtConstants.DB_CONFIG_SCREEN;
	return screenNav;
}
public String getRequestList(){		
	screenNav=DvtConstants.LOAN_REQUEST_LIST;
	return screenNav;
}




}
