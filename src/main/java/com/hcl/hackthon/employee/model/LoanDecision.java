package com.hcl.hackthon.employee.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LoanDecision {

	private String username;
	private String action;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}

	@Override
	public String toString() {
		return "LoanDecision [userid=" + username + ", action=" + action + "]";
	}
}
