package com.gov.bgc.bean;

public class Applicant {

	private Integer id;
	private String firstName;
	private String midleName;
	private String lastName;
	private String gender;
	private Integer age=0;
	private String jobType;
	private Integer annualIncome=0;
	private Integer annualExpense=0;

	
	private ApplicantAditionalDtls applicantAditionalDtls;
	private BankAccountDtls bankAccountDetails;
	private Address address;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMidleName() {
		return midleName;
	}
	public void setMidleName(String midleName) {
		this.midleName = midleName;
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public Integer getAnnualIncome() {
		return annualIncome;
	}
	public void setAnnualIncome(Integer annualIncome) {
		this.annualIncome = annualIncome;
	}
	public Integer getAnnualExpense() {
		return annualExpense;
	}
	public void setAnnualExpense(Integer annualExpense) {
		this.annualExpense = annualExpense;
	}
	public ApplicantAditionalDtls getApplicantAditionalDtls() {
		if(null==applicantAditionalDtls){
			applicantAditionalDtls = new ApplicantAditionalDtls();
		}
		return applicantAditionalDtls;
	}
	public void setApplicantAditionalDtls(
			ApplicantAditionalDtls applicantAditionalDtls) {
		this.applicantAditionalDtls = applicantAditionalDtls;
	}
	public BankAccountDtls getBankAccountDetails() {
		if(null==bankAccountDetails){
			bankAccountDetails = new BankAccountDtls();
		}
		return bankAccountDetails;
	}
	public void setBankAccountDetails(BankAccountDtls bankAccountDetails) {
		this.bankAccountDetails = bankAccountDetails;
	}
	public Address getAddress() {
		if(null==address){
			address = new Address();
		}
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	
	
}
