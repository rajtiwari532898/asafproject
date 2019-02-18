package com.tcs.dvt.bean;



import com.comdata.posa.util.CommonUtil;
import com.tcs.dvt.constant.DvtConstants;




/**
 * @author 195964
 *
 */
public class FooterBean {	
	private String screenNav;
	private String privacyPolicy;
	private String termsCond;
	private String contactUs;
	private String disputeTran;
	private String lostCard;
	

	/**
	 * 
	 */
	public FooterBean() {		
		// TODO Auto-generated constructor stub
	}
	/**
	  *  @ function to navigate to Contact Us web page
	  */
	public String contactUsPage(){
		screenNav=DvtConstants.CONTACT_US;
		this.setContactUs(CommonUtil.getProperty(DvtConstants.CONTACT_US_FILE));		
		return screenNav;	
	}
	/**
	  *  @ function to navigate to Terms & Condition
	  */
	public String termsCondn(){
		screenNav=DvtConstants.TERMS_CONDN;
		this.setTermsCond(CommonUtil.getProperty(DvtConstants.TERMS_FILE_NAME));		
		return screenNav;	
	}
	/**
	  *  @ function to navigate to Dispute Transaction
	  */
	public String disputeTrans(){
		screenNav=DvtConstants.DISPUTE_FWD;
		this.setDisputeTran(CommonUtil.getProperty(DvtConstants.DISPUTE_TRAN));		
		return screenNav;
	}
	/**
	  *  @ function to navigate to Terms & Condition
	  */
	public String lostCardPage(){
		screenNav=DvtConstants.LOST_FWD;
		this.setLostCard(CommonUtil.getProperty(DvtConstants.LOST_CARD));		
		return screenNav;
	}
	/**
	  *  @ function to navigate to Policy
	  */
	public String policy(){

		screenNav=DvtConstants.POLICY_TERMS;
		this.setPrivacyPolicy(CommonUtil.getProperty(DvtConstants.PRIVACY_FILE_NAME));		
		return screenNav;	
	}
	/**
	  *  @ function to navigate to Contact Us web page
	  *  from log in page
	  */
	public String contactUsLogin(){
		screenNav=DvtConstants.CONTACT_US;
		this.setContactUs(CommonUtil.getProperty(DvtConstants.CONTACT_US_FILE));		
		return screenNav;	
	}
	/**
	  *  @ function to navigate to Terms & Condition
	  *  from Login Page
	  */
	public String termsCondLogin(){
		screenNav=DvtConstants.TERMS_CONDN;
		this.setTermsCond(CommonUtil.getProperty(DvtConstants.TERMS_FILE_NAME));	
		return screenNav;	
	}
	/**
	  *  @ function to navigate to Policy screen 
	  */
	public String policyLogin(){
		screenNav=DvtConstants.POLICY_TERMS;		
		this.setPrivacyPolicy(CommonUtil.getProperty(DvtConstants.PRIVACY_FILE_NAME));		
		return screenNav;	
	}
	/**
	  *  @ function to navigate to Dispute Transaction
	  */
	public String disputeTransLogin(){
		screenNav=DvtConstants.DISPUTE_FWD;
		this.setDisputeTran(CommonUtil.getProperty(DvtConstants.DISPUTE_TRAN));		
		return screenNav;
	}
	/**
	  *  @ function to navigate to Terms & Condition
	  */
	public String lostCardLogin(){
		screenNav=DvtConstants.LOST_FWD;
		this.setLostCard(CommonUtil.getProperty(DvtConstants.LOST_CARD));		
		return screenNav;
	}
	/**
	 * @return the privacyPolicy
	 */
	public String getPrivacyPolicy() {
			return privacyPolicy;
	}
	/**
	 * @param privacyPolicy the privacyPolicy to set
	 */
	public void setPrivacyPolicy(String privacyPolicy) {
		this.privacyPolicy = privacyPolicy;
	}
	/**
	 * @return the termsCond
	 */
	public String getTermsCond() {
		return termsCond;
	}
	/**
	 * @param termsCond the termsCond to set
	 */
	public void setTermsCond(String termsCond) {
		this.termsCond = termsCond;
	}
	/**
	 * @return the contactUs
	 */
	public String getContactUs() {
		return contactUs;
	}
	/**
	 * @param contactUs the contactUs to set
	 */
	public void setContactUs(String contactUs) {
		this.contactUs = contactUs;
	}
	/**
	 * @return the disputeTran
	 */
	public String getDisputeTran() {
		return disputeTran;
	}
	/**
	 * @param disputeTran the disputeTran to set
	 */
	public void setDisputeTran(String disputeTran) {
		this.disputeTran = disputeTran;
	}
	/**
	 * @return the lostCard
	 */
	public String getLostCard() {
		return lostCard;
	}
	/**
	 * @param lostCard the lostCard to set
	 */
	public void setLostCard(String lostCard) {
		this.lostCard = lostCard;
	}
	
}
