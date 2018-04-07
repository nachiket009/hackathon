package com.hcl.hackthon.employee.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LoanDisbursementDetails {

	private String username;
	private int tenure;
	private double emi;
	private float amount;
	private boolean disbursed;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getTenure() {
		return tenure;
	}
	public void setTenure(int tenure) {
		this.tenure = tenure;
	}
	public double getEmi() {
		return emi;
	}
	public void setEmi(double emi) {
		this.emi = emi;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public boolean isDisbursed() {
		return disbursed;
	}
	public void setDisbursed(boolean disbursed) {
		this.disbursed = disbursed;
	}
	@Override
	public String toString() {
		return "LoanDisbursementDetails [username=" + username + ", tenure=" + tenure + ", emi=" + emi + ", amount="
				+ amount + "]";
	}
}
