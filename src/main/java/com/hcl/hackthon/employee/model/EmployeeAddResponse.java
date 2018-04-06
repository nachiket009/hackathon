package com.hcl.hackthon.employee.model;

public class EmployeeAddResponse {

	private Integer employeeId;
	private String status;
	
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "EmployeeAddResponse [employeeId=" + employeeId + ", status=" + status + "]";
	}
}
