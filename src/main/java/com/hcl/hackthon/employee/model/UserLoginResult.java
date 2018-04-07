package com.hcl.hackthon.employee.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserLoginResult {

	private boolean isValid;
	private String role;
	
	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
