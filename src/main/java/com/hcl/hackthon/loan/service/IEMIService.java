package com.hcl.hackthon.loan.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
//
//import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;

import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;

import com.hcl.hackthon.employee.model.UserLoginRequest;
import com.hcl.hackthon.employee.model.UserLoginResult;

@Path("/emiservice")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface IEMIService {
	
	@GET
	@Path("/emi/{amount}/{tenure}")
	public double getEmi(@PathParam("amount") float amount, @PathParam("tenure") float tenure);
	
	@POST
	@Path("/login")
	public UserLoginResult getRole(UserLoginRequest userLoginRequest);

}
