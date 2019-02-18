package com.gov.bgc.bean;

public class BGCResponse {

	private Integer bgcIndex;
	private String message="";
	private Applicant applicant;

	public Applicant getApplicant() {
		if(null==applicant){
			applicant = new Applicant();
		}
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}
	
	public Integer getBgcIndex() {
		return bgcIndex;
	}
	public void setBgcIndex(Integer bgcIndex) {
		this.bgcIndex = bgcIndex;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
}
