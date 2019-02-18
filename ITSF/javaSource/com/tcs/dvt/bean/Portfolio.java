package com.tcs.dvt.bean;

import java.math.BigDecimal;

import com.comdata.posa.util.CommonUtil;
import com.tcs.dvt.constant.DvtConstants;

public class Portfolio {

	private String firstName;
	private String middleName;
	private String lastName;
	private String gender = "1";
	private String jobType = "1";
	private String age;
	private String email;

	private BigDecimal fixedIncomeAmount;
	private BigDecimal anualIntrestRate;
	private BigDecimal goldInGrams;
	private BigDecimal silverInGrams;
	private BigDecimal gbp;
	private BigDecimal usd;
	private BigDecimal inr;

	private BigDecimal lcf;
	private BigDecimal mcf;
	private BigDecimal scf;

	private String ac = "HIGH RISK";
	private String currency = "USD";
	private BigDecimal cav = new BigDecimal("3146600");
	private BigDecimal commodity = new BigDecimal("5");
	private BigDecimal equity = new BigDecimal("2");
	private BigDecimal fip = new BigDecimal("4");
	private BigDecimal forex = new BigDecimal("89");

	
	private BigDecimal annualIncome;
	private BigDecimal annualExpence;
	
	
	public BigDecimal getAnnualExpence() {
		return annualExpence;
	}

	public void setAnnualExpence(BigDecimal annualExpence) {
		this.annualExpence = annualExpence;
	}

	public BigDecimal getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(BigDecimal annualIncome) {
		this.annualIncome = annualIncome;
	}

	public String getAc() {
		return ac;
	}

	public void setAc(String ac) {
		this.ac = ac;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public BigDecimal getCav() {
		return cav;
	}

	public void setCav(BigDecimal cav) {
		this.cav = cav;
	}

	public BigDecimal getCommodity() {
		return commodity;
	}

	public void setCommodity(BigDecimal commodity) {
		this.commodity = commodity;
	}

	public BigDecimal getEquity() {
		return equity;
	}

	public void setEquity(BigDecimal equity) {
		this.equity = equity;
	}

	public BigDecimal getFip() {
		return fip;
	}

	public void setFip(BigDecimal fip) {
		this.fip = fip;
	}

	public BigDecimal getForex() {
		return forex;
	}

	public void setForex(BigDecimal forex) {
		this.forex = forex;
	}

	public String submitDetails() {

		
		if(age.equalsIgnoreCase("27")){
			System.out.println("Unable to submit request");
			String screenNav=DvtConstants.PORTFOLIO_NAV;
			DvtConstants.showMessages(DvtConstants.USER_REGISTRATION,CommonUtil.getProperty(DvtConstants.ERROR_PORTFOLIO_SUBMIT));
			return screenNav;
		}
		
		String screenNav = DvtConstants.PORTFOLIO_RES_NAV;

		return screenNav;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigDecimal getFixedIncomeAmount() {
		return fixedIncomeAmount;
	}

	public void setFixedIncomeAmount(BigDecimal fixedIncomeAmount) {
		this.fixedIncomeAmount = fixedIncomeAmount;
	}

	public BigDecimal getAnualIntrestRate() {
		return anualIntrestRate;
	}

	public void setAnualIntrestRate(BigDecimal anualIntrestRate) {
		this.anualIntrestRate = anualIntrestRate;
	}

	public BigDecimal getGoldInGrams() {
		return goldInGrams;
	}

	public void setGoldInGrams(BigDecimal goldInGrams) {
		this.goldInGrams = goldInGrams;
	}

	public BigDecimal getSilverInGrams() {
		return silverInGrams;
	}

	public void setSilverInGrams(BigDecimal silverInGrams) {
		this.silverInGrams = silverInGrams;
	}

	public BigDecimal getGbp() {
		return gbp;
	}

	public void setGbp(BigDecimal gbp) {
		this.gbp = gbp;
	}

	public BigDecimal getUsd() {
		return usd;
	}

	public void setUsd(BigDecimal usd) {
		this.usd = usd;
	}

	public BigDecimal getInr() {
		return inr;
	}

	public void setInr(BigDecimal inr) {
		this.inr = inr;
	}

	public BigDecimal getLcf() {
		return lcf;
	}

	public void setLcf(BigDecimal lcf) {
		this.lcf = lcf;
	}

	public BigDecimal getMcf() {
		return mcf;
	}

	public void setMcf(BigDecimal mcf) {
		this.mcf = mcf;
	}

	public BigDecimal getScf() {
		return scf;
	}

	public void setScf(BigDecimal scf) {
		this.scf = scf;
	}

}
