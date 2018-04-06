package com.hcl.hackthon.employee.service;

import com.hcl.hackthon.employee.model.Employee;
import com.hcl.hackthon.employee.model.EmployeeAddRequest;
import com.hcl.hackthon.employee.model.EmployeeAddResponse;

public class EmployeeRegistrationService implements IEmployeeRegistrationService {

	public EmployeeAddResponse registerEmployee(EmployeeAddRequest employeeAddRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	public Employee getEmployeeById(Integer employeeId) {
		Employee emp = new Employee();
		emp.setEmployeeId(employeeId);
		emp.setName("James");
		emp.setDesignation("PM");
		emp.setSalary(100000.00);
		return emp;
	}

}
