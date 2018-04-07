package com.hcl.hackthon.employee.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LoanDetail {

	private String userid;
	private String username;
	private String status;
	private float amount;
	private int tenure;
	private float roi;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	
	@Override
	public String toString() {
		return "LoanDetail [userid=" + userid + ", username=" + username + ", status=" + status + ", amount=" + amount
				+ ", tenure=" + tenure + ", roi=" + roi + "]";
	}
}
