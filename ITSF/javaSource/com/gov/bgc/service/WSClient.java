package com.gov.bgc.service;

import java.rmi.RemoteException;

import com.gov.bgc.bean.xsd.Address;
import com.gov.bgc.bean.xsd.Applicant;
import com.gov.bgc.bean.xsd.ApplicantAditionalDtls;
import com.gov.bgc.bean.xsd.BankAccountDtls;
import com.gov.bgc.bean.xsd.LoanRequest;
import com.gov.bgc.bean.xsd.RegistrationRequest;
import com.gov.bgc.bean.xsd.RegistrationResponse;
import com.sun.faces.application.ApplicationAssociate;
import com.tcs.dvt.bean.UserRegistrationBean;

public class WSClient {

	/**
	 * @param args
	 * @throws RemoteException 
	 */
	public static void main(String[] args) throws RemoteException {
		// TODO Auto-generated method stub

		CustomerServicePortTypeProxy proxy = new CustomerServicePortTypeProxy();
	
		
		
		
		RegistrationRequest req = new RegistrationRequest();
		req.setApplicant(new Applicant());
		req.setLoanRequest(new LoanRequest());
		req.getApplicant().setAddress(new Address());
		req.getApplicant().setApplicantAditionalDtls(new ApplicantAditionalDtls());
		req.getLoanRequest().setLoanAmount(1000000);
		req.getLoanRequest().setLoanTenure(10);
		req.getLoanRequest().setRemarks("Loan against property");
		
		req.getApplicant().getAddress().setCity("Lucknow");
		req.getApplicant().getAddress().setContactNo("09198726241");
		req.getApplicant().getAddress().setCountry("India");
		req.getApplicant().getAddress().setLine1("1/1 Vibhutikhand");
		req.getApplicant().getAddress().setLine2("Gomtinagar");
		req.getApplicant().getAddress().setPincode("226010");
		req.getApplicant().getAddress().setState("UP");
		
		
		req.getApplicant().getApplicantAditionalDtls().setDlNo("AGYPT5614R");
		req.getApplicant().getApplicantAditionalDtls().setPassportCountry("India");
		req.getApplicant().getApplicantAditionalDtls().setPassportNo("G9877684");
		req.getApplicant().getApplicantAditionalDtls().setPassportValidity("15-12-2035");
		req.getApplicant().getApplicantAditionalDtls().setSsn("234-840-5341");
		
		
		req.getApplicant().setAge(31);
		req.getApplicant().setAnnualExpense(300000);
		req.getApplicant().setAnnualIncome(1000000);
		req.getApplicant().setEmail("aktripathi.1908@gmail.com");
		req.getApplicant().setFirstName("Arjun");
		req.getApplicant().setGender("1".trim());
		req.getApplicant().setJobType("1".trim());
		req.getApplicant().setLastName("Pandit");
		req.getApplicant().setMidleName("");
		
		
		
		RegistrationResponse rsp = proxy.registration(req );
		System.out.println("Status >>>>>>>"+rsp.getStatus());
		System.out.println("Id     >>>>>>>"+rsp.getId());
	}

	public RegistrationResponse registerCustomer(UserRegistrationBean user) throws RemoteException{
		CustomerServicePortTypeProxy proxy = new CustomerServicePortTypeProxy();
		//proxy.setEndpoint("http://localhost:8088/BGCProject/services/CustomerService?wsdl");
		RegistrationRequest req = new RegistrationRequest();
		req.setApplicant(new Applicant());
		req.setLoanRequest(new LoanRequest());
		req.getApplicant().setAddress(new Address());
		req.getApplicant().setApplicantAditionalDtls(new ApplicantAditionalDtls());
		req.getApplicant().setBankAccountDetails(new BankAccountDtls());
		
		req.getLoanRequest().setLoanAmount(user.getLoanAmount().intValue());
		req.getLoanRequest().setLoanTenure(Integer.parseInt(null==user.getLoanTenure() ? "0": user.getLoanTenure().trim()));
		req.getLoanRequest().setRemarks(user.getRemarks());
		
		req.getApplicant().getAddress().setCity(user.getCity());
		req.getApplicant().getAddress().setContactNo(user.getMobileNo());
		req.getApplicant().getAddress().setCountry(user.getCountry());
		req.getApplicant().getAddress().setLine1(user.getLine1());
		req.getApplicant().getAddress().setLine2(user.getLine2());
		req.getApplicant().getAddress().setPincode(user.getPinCode());
		req.getApplicant().getAddress().setState(user.getState());
		
		
		req.getApplicant().getApplicantAditionalDtls().setDlNo(user.getDlNo());
		req.getApplicant().getApplicantAditionalDtls().setPassportCountry(user.getPassportCountry());
		req.getApplicant().getApplicantAditionalDtls().setPassportNo(user.getPassportNo());
		req.getApplicant().getApplicantAditionalDtls().setPassportValidity("15-12-2035");//HardCoded
		req.getApplicant().getApplicantAditionalDtls().setSsn(user.getSsn());
		
		
		req.getApplicant().setAge(Integer.parseInt(null==user.getAge() ? "0":user.getAge().trim()));
		req.getApplicant().setAnnualExpense(user.getAnnualExpence().intValue());
		req.getApplicant().setAnnualIncome(user.getAnnualIncome().intValue());
		req.getApplicant().setEmail(user.getEmail());
		req.getApplicant().setFirstName(user.getFirstName());
		req.getApplicant().setGender(user.getGender().trim());
		req.getApplicant().setJobType(user.getJobType().trim());
		req.getApplicant().setLastName(user.getLastName());
		req.getApplicant().setMidleName(user.getMiddleName());
		
		req.getApplicant().getBankAccountDetails().setAccountNumber(user.getAccountNo());
		req.getApplicant().getBankAccountDetails().setBankName(user.getBankName());
		req.getApplicant().getBankAccountDetails().setBranch(user.getBranch());
		
		RegistrationResponse rsp = proxy.registration(req );
		System.out.println("Status >>>>>>>"+rsp.getStatus());
		System.out.println("Id     >>>>>>>"+rsp.getId());
		return rsp;
	}
}
