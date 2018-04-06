package com.hcl.hackthon.employee.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EmployeeAddRequest {

	private String employeeName;
	private String designation;
	private Double salary;
	
	
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "EmployeeAddRequest [employeeName=" + employeeName + ", designation=" + designation + ", salary="
				+ salary + "]";
	}
}
