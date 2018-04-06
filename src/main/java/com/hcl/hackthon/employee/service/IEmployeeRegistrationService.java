package com.hcl.hackthon.employee.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.RequestParam;

import com.hcl.hackthon.employee.model.Employee;
import com.hcl.hackthon.employee.model.EmployeeAddRequest;
import com.hcl.hackthon.employee.model.EmployeeAddResponse;

@Path("/employeeservice")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface IEmployeeRegistrationService {
	
	@POST
	@Path("/employee/{employeeAddRequest}")
	public EmployeeAddResponse registerEmployee(@RequestParam("employeeAddRequest") EmployeeAddRequest employeeAddRequest);
	
	@GET
	@Path("/employee/{employeeId}")
	public Employee getEmployeeById(@PathParam("employeeId") Integer employeeId);

}
