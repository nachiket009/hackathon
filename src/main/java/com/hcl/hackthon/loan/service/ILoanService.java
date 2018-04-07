package com.hcl.hackthon.loan.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hcl.hackthon.employee.model.LoanDecision;
import com.hcl.hackthon.employee.model.LoanDetail;
import com.hcl.hackthon.employee.model.LoanRequest;
import com.hcl.hackthon.employee.model.UserLoginRequest;
import com.hcl.hackthon.employee.model.UserLoginResult;

@Path("/loanservice")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface ILoanService {
	
	@GET
	@Path("/emi/{amount}/{tenure}")
	public double getEmi(@PathParam("amount") float amount, @PathParam("tenure") float tenure);
	
	@POST
	@Path("/login")
	public UserLoginResult getRole(UserLoginRequest userLoginRequest);
	
	@POST
	@Path("/applyloan")
	public void applyLoan(LoanRequest loanRequest);
	
	@POST
	@Path("/loandecision")
	public void loanDecision(LoanDecision loanDecision);
	
	@GET
	@Path("/getloans")
	public List<LoanDetail> getAllLoans();
	
	@GET
	@Path("/getloansbyuser/{username}")
	public LoanDetail getLoanByUserName(@PathParam("username") String username);
	
	@GET
	@Path("/getloansbystatus/{status}")
	public void getAllLoansByStatus(@PathParam("status") String status);

}
