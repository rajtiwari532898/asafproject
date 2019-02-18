package com.tcs.dvt.bean;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.jms.JMSException;
import javax.naming.NamingException;

import org.jboss.mq.il.uil2.msgs.GetIDMsg;

import com.comdata.posa.util.CommonUtil;
import com.gov.bgc.bean.BGCResponse;
import com.gov.bgc.bean.xsd.RegistrationResponse;
import com.gov.bgc.service.WSClient;
import com.tcs.common.UserRegistraionJMS;
import com.tcs.dvt.constant.DvtConstants;

public class UserRegistrationBean {
	
	
	  
	private String firstName;
	private String middleName;
	private String lastName;
	private String gender="1";
	private String jobType="1";
	private String age;
	private BigDecimal annualIncome;
	private BigDecimal annualExpence;
	private BigDecimal loanAmount;
	private String loanTenure;
	private String status ;
	private String remarks;
	
	
	
	private String line1;
	private String line2;
	private String city;
	private String state;
	private String country;
	private String mobileNo;
	private String pinCode;
	private String bankName;
	private String branch;
	private String accountNo;
	private String passportNo;
	private String passportCountry;
	private String ssn;
	private String dlNo;
	private String loanType="3";
	private BigDecimal approvedLoan;
	private String approvedLoanTenure;
	private String approvedMessage;
	private BigDecimal creditScore;
	private String email;
	private String userId;
	private String fullName;
	
	
	
	
	
	public String getFullName() 
	{
		fullName=""; 
		if(getFirstName()!=null && !getFirstName().equals(""))
		{
			fullName=getFirstName();
		}
		
		if(getMiddleName()!=null && !getMiddleName().equals(""))
		{
			fullName=fullName+" "+getMiddleName();
		}
		if(getLastName()!=null && !getLastName().equals(""))
		{
			fullName=fullName+" "+getLastName();
		}
		return fullName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public BigDecimal getApprovedLoan() {
		return approvedLoan;
	}
	public void setApprovedLoan(BigDecimal approvedLoan) {
		this.approvedLoan = approvedLoan;
	}
	public String getApprovedLoanTenure() {
		return approvedLoanTenure;
	}
	public void setApprovedLoanTenure(String approvedLoanTenure) {
		this.approvedLoanTenure = approvedLoanTenure;
	}
	public String getApprovedMessage() {
		return approvedMessage;
	}
	public void setApprovedMessage(String approvedMessage) {
		this.approvedMessage = approvedMessage;
	}
	public BigDecimal getCreditScore() {
		return creditScore;
	}
	public void setCreditScore(BigDecimal creditScore) {
		this.creditScore = creditScore;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public BigDecimal getAnnualIncome() {
		return annualIncome;
	}
	public void setAnnualIncome(BigDecimal annualIncome) {
		this.annualIncome = annualIncome;
	}
	public BigDecimal getAnnualExpence() {
		return annualExpence;
	}
	public void setAnnualExpence(BigDecimal annualExpence) {
		this.annualExpence = annualExpence;
	}
	public BigDecimal getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(BigDecimal loanAmount) {
		this.loanAmount = loanAmount;
	}
	public String getLoanTenure() {
		return loanTenure;
	}
	public void setLoanTenure(String loanTenure) {
		this.loanTenure = loanTenure;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getLine1() {
		return line1;
	}
	public void setLine1(String line1) {
		this.line1 = line1;
	}
	public String getLine2() {
		return line2;
	}
	public void setLine2(String line2) {
		this.line2 = line2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getPassportNo() {
		return passportNo;
	}
	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}
	public String getPassportCountry() {
		return passportCountry;
	}
	public void setPassportCountry(String passportCountry) {
		this.passportCountry = passportCountry;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getDlNo() {
		return dlNo;
	}
	public void setDlNo(String dlNo) {
		this.dlNo = dlNo;
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	
	public  String submitDetails()
	{
		try {
		//Web Service call Start
		System.out.println("WS Call started");
		WSClient client = new WSClient();
		RegistrationResponse rsp = client.registerCustomer(this);
		System.out.println("WS Call done");
		setUserId(rsp.getId().toString().trim());
		if(rsp.getId().intValue()==0){
			System.out.println("Unable to submit request");
			String screenNav=DvtConstants.USER_REGISTRATION;
			DvtConstants.showMessages(DvtConstants.USER_REGISTRATION,CommonUtil.getProperty(DvtConstants.ERROR_LOAN_SUBMIT));
			return screenNav;
		}
		//Web Service call End
		
		//BGC call Start
		System.out.println("BGC Call started");
		doProcessing(this);
		System.out.println("BGC Call done");
		
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
		String screenNav=DvtConstants.BG_SCORE;
		
		return screenNav;
		
	}
	public void  doProcessing(UserRegistrationBean userRegistrationBean) throws Exception
	{
		UserRegistraionJMS.sendJmsRequest(userRegistrationBean);
		BGCResponse bGCResponse=UserRegistraionJMS.receiveJmsResponse();
		
		//Post Processing
		int index=bGCResponse.getBgcIndex();
		if(index==1)
		{
			userRegistrationBean.setStatus("3");
			userRegistrationBean.setApprovedLoan(new BigDecimal(0));
			userRegistrationBean.setApprovedMessage("Loan Application Rejected due to poor BGC  report.\n Please contact Admin for Inquiry");
		}
		else if(index==2){
			userRegistrationBean.setStatus("2");
		
			userRegistrationBean.setApprovedLoan(new BigDecimal(userRegistrationBean.getLoanAmount().intValue()/2));
			userRegistrationBean.setApprovedMessage("In Process");
			
		}
		else if(index==3){
			
			userRegistrationBean.setApprovedLoan(userRegistrationBean.getLoanAmount());
			userRegistrationBean.setApprovedMessage("Loan Application Approved");
			
			
			userRegistrationBean.setStatus("2");
		}
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		System.out.println("in submit");
		Connection con=	null;
		
			
		con=getConnection();
		String sqlUpdate="update applicant_details set approved_loan="+userRegistrationBean.getApprovedLoan()+" ,approved_message ='"+userRegistrationBean.getApprovedMessage()+"'" +
				" ,status="+userRegistrationBean.getStatus()+" where id="+getUserId()+" ";
		pstmt=con.prepareStatement(sqlUpdate);
		pstmt.executeUpdate();
		System.out.println("in update done-->");
		
		
	}
	public static Connection getConnection()throws Exception
	{
		 Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://01hw462749:3306/its_f" ,"root","root");
		return con;
             
	}
	
//	public  String validateFirstName()
//	{
//		
//			 
//			  FacesContext fc = FacesContext.getCurrentInstance();
//			  
//		 
//			  UIComponent components = event.getComponent();
//		 
//			  // get password//			  UIInput uiInputPassword = (UIInput) components.findComponent("password");
//	}

}
