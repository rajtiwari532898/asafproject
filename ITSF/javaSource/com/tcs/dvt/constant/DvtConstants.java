package com.tcs.dvt.constant;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public final class DvtConstants {
	
	private DvtConstants(){
		//do nothing
	}
	public static final String COLON = ":";
	public static final String SINGLE_SPACE = " ";
	public static final String HYPHEN = "-";
	public static final String NOT_FOUND = " not found ??";
	public static final String KEY1 = "?? key ";
	public static final String LOGIN_SCREEN_ID = "cardLogin:msg";
	public static final String LOGIN_SCREEN_NAV = "fail";
	public static final int LOGIN_COUNT = 5;
	public static final String LOGOUT_NAV = "logout";
	public static final String CONTACT_ADMINISTRATOR = "Contact to your system administrator.";
	public static final String INVALID_DATE_FORMAT = ": Please enter a valid Date (MMM DD, YYYY).";
	public static final String CARD_AUTH_FAIL="Invalid Card Number";
	//public static final String CAPTCH_MISMATCH="Please Enter the correct Captcha Code";
	
	public static final String HOME_NAV="WelcomePage";
	public static final String PORTFOLIO_NAV="portfolio";
	public static final String PORTFOLIO_RES_NAV="portfolioResult";
	
	public static final String BG_SCORE="BGScore";
	
	
	public static final String VALID_CARD="validCard";
	public static final String CAPTCHA_CODE="CAPTCHA_STRING";
	public static final String EDIT_PROFILE = "editProfile";
	public static final String CONFIRM_PROFILE = "confirmProfile";
	public static final String CONTACT_US = "contactUs";
	public static final String POLICY_TERMS = "policy";
	public static final String TERMS_CONDN = "termsCondn";
	public static final String TRANS_DET = "transDet";
	public static final String DISPUTE_FWD = "disputetran";
	public static final String LOST_FWD = "lostcard";
	public static final String COMMA = ",";
	//EDIT_PROFILE_FORM
	public static final String EDIT_PROFILE_FORM="editProfile:msg";
	public static final String EMAIL_MISMATCH="EmailMismatch";
	public static final String INVALID_LOGIN="InvalidUserCredentials";
	public static final String ERROR_LOAN_SUBMIT="loanSubmitError";
	
	public static final String ERROR_PORTFOLIO_SUBMIT="portfolioSubmitError";
	
		
	// Constants
	public static final java.lang.String MM_DD_YYYY_DATE_FORMAT = "MM/dd/yyyy";
	public static final String MMM_DD_YYYY_DATE_FORMAT = "MMM dd yyyy";
	//MM/dd/yy
	public static final String MMM_DD_YY_DATE_FORMAT = "MM/dd/yy";
	public static final String SIMPLE_DATE_FORMAT = "yyyy-MM-dd hh:mm:ss.0";
	public static final String VALUE = "value";
	public static final String ACCESSKEY_ATTRIBUTE = "accesskey";
	public static final String CARD_INACTIVE = "Not Active";
	public static final String CARD_LOST = "Card Lost";
	public static final String LOGIN_SCREEN = "login";
	public static final String USER_REGISTRATION = "userRegistration";
	public static final String LOAN_REQUEST_LIST = "loanRequestList";
	
	public static final String DB_CONFIG_SCREEN = "dbConfig";
	// To read the Properties file - Posa.Properties
	public static final String GIFT_CARD_NUMBER ="GIFT_CARD_BIN";
	public static final String PHONE_NO ="phoneno";
	public static final String ADD_LINE1 ="addLine1";
	public static final String ADD_LINE2 ="addLine2";
	public static final String ADD_LINE3 ="addLine3";
	public static final String FAQ_FILE_NAME ="Faq";
	//Posa Links 
	public static final String PRIVACY_FILE_NAME ="Privacy";
	public static final String TERMS_FILE_NAME ="TermCond";
	public static final String CONTACT_US_FILE = "ContactUs";
	public static final String LOST_CARD = "LostCard";
	public static final String DISPUTE_TRAN = "DisputeTrans";
	public static final String OPEN_WAY_URL ="way4u.url";
	// For the error messages in Validator
	public static final String EMPTY_FIELD="EmptyFields";
	public static final String INVALID_FIELD="InvalidField";
	public static final String NUMERIC_FIELD="NumericField";
	public static final String STATE_LENGTH="StateLength";
	public static final String CARD_LENGTH="CardLength";
	public static final String INVALID_CARD="InvalidCard";
	public static final String POSTAL_LENGTH="PostalLength";
	public static final String CAPTCH_MISMATCH="InvalidCaptcha";
	// For dates
	
	public static final String NO_OF_DAYS="NoOfDays";
	public static final String NO_OF_MONTHS="NoOfMonths";
	public static final String OPENWAY="Not able to Connect Open Way";
	public static final String EMAIL_NOT_FOUND = "Email id is not existing";
	public static final String CONNECTION_REFUSED = "Connection refused";
	
	public static final String UPDATE_FAIL = "Could not update profile";
	public static final String UPDATION_FAILED = "Updation failed.";
	
	public static final String USR_PROFILE_ASS = "insertUserPrfAsso";
	public static final String PERIOD = ".";
	public static final String AFTER_DECIMAL = ".00";
	public static final String ZERO = "0";
	public static final String DOLLAR_SIGN = "$";
	public static final String PLUS_SIGN = "+";
	//EMPTY_STRING
	public static final String EMPTY_STRING = "";
	// Transaction Type
	
	public static final String TRANSACTION_TYPE_PENDING = "PENDING";
	public static final String TRANSACTION_TYPE_POSTED = "POSTED";
	public static final String TRANSACTION_TYPE_DISPLAY = "Pending";
	
	public static void showMessages(String screenId, String summary) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		message.setSeverity(FacesMessage.SEVERITY_ERROR);
		message.setSummary(summary);
		context.addMessage(screenId, message);
	}

	public static int compareDates(boolean ascending, Date str1, Date str2) {
		int i = 0;
		if (str1 != null && str2 != null) {
			// try{
			i = ascending ? str1.compareTo(str2) : str2.compareTo(str1);
			/*
			 * }catch(Exception e){ e.printStackTrace(); }
			 */} else if (str1 == null && str2 != null) {
			if (ascending)
				i = 1;
			else
				i = -1;
		} else if (str1 != null && str2 == null) {
			if (ascending)
				i = -1;
			else
				i = 1;
		} else {
			i = 0;
		}
		return i;
	}

}