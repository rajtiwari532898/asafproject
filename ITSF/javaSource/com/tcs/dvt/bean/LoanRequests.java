package com.tcs.dvt.bean;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.component.UIData;

public class LoanRequests {
	//add email add message add status a
	private ArrayList<UserRegistrationBean>customerRequests=new ArrayList<UserRegistrationBean>();
	
	public ArrayList<UserRegistrationBean> getCustomerRequests() {
		return customerRequests;
	}

	public void setCustomerRequests(ArrayList<UserRegistrationBean> customerRequests) {
		this.customerRequests = customerRequests;
	}
	private UIData dataTableBinding;
	 
	public UIData getDataTableBinding() {
		return dataTableBinding;
	}

	public void setDataTableBinding(UIData dataTableBinding) {
		this.dataTableBinding = dataTableBinding;
	}

	public  ArrayList<UserRegistrationBean> getLoanRequestList()
	{
		
		Connection conn=null;
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		  ArrayList<UserRegistrationBean>loanRequestList=new ArrayList<UserRegistrationBean>();
		try 
		{
			 conn=UserRegistrationBean.getConnection();
			
			  
				String applicantDetailsQry="select a.*,b.mobile_no from applicant_details a ,address b,applicant_additional_details c where  c.app_id=a.id and c.address_id=b.id";
				pstmt=conn.prepareStatement(applicantDetailsQry);
				rs=pstmt.executeQuery();
				
				 
				while(rs.next())
				{
					
					
					
					
					UserRegistrationBean userRegistrationBean=new UserRegistrationBean();
					
					
					String first_name=rs.getString("first_name");
					
					String middle_name=rs.getString("middle_name");
					String last_name=rs.getString("last_name");
					
					
					String loan_amount=rs.getString("loan_amount");
					String loan_tenure=rs.getString("loan_tenure");
					
					String status=rs.getString("status");
					String mobile_no=rs.getString("mobile_no");
					
				
					String email=rs.getString("email");
					String approved_loan=null!= rs.getString("approved_loan") ? rs.getString("approved_loan") : "0";
					String approved_message=rs.getString("approved_message");
					
					
					userRegistrationBean.setFirstName(first_name);
					userRegistrationBean.setMiddleName(middle_name);
					userRegistrationBean.setLastName(last_name);
					userRegistrationBean.setLoanAmount(new BigDecimal(loan_amount));
					userRegistrationBean.setLoanTenure(loan_tenure);
					
					//new applicant
					if(status.equalsIgnoreCase("1")){
						userRegistrationBean.setStatus("In Process");
					}
					else if(status.equalsIgnoreCase("2"))
					{
						userRegistrationBean.setStatus("Approved");
					}
					else if(status.equalsIgnoreCase("3"))
					{
						userRegistrationBean.setStatus("Rejected");
					}
					userRegistrationBean.setMobileNo(mobile_no);
					userRegistrationBean.setEmail(email);
					userRegistrationBean.setApprovedLoan(new BigDecimal(approved_loan));
					userRegistrationBean.setLoanAmount(new BigDecimal(loan_amount));
					userRegistrationBean.setApprovedMessage(approved_message);
					loanRequestList.add(userRegistrationBean);
				}
			 
			 
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		setCustomerRequests(loanRequestList);
		return loanRequestList;
	}
	public LoanRequests()
	{
		getLoanRequestList();
	}
	
}
