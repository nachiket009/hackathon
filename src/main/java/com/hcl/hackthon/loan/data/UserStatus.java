package com.hcl.hackthon.loan.data;

public class UserStatus {
	
	private String userid;
	private String loanstatus;
	private float amount;
	private int tenure;
	private float roi;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getLoanstatus() {
		return loanstatus;
	}
	public void setLoanstatus(String loanstatus) {
		this.loanstatus = loanstatus;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public int getTenure() {
		return tenure;
	}
	public void setTenure(int tenure) {
		this.tenure = tenure;
	}
	public float getRoi() {
		return roi;
	}
	public void setRoi(float roi) {
		this.roi = roi;
	}

}
