package com.hcl.hackthon.loan.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
//
//import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;

import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;

//@CrossOriginResourceSharing(
//        allowOrigins = {
//           "http://10.117.189.46:8080"
//        }, 
//        allowCredentials = true, 
//        maxAge = 1, 
//        allowHeaders = {
//           "X-custom-1", "X-custom-2"
//        }, 
//        exposeHeaders = {
//           "X-custom-3", "X-custom-4"
//        }
//)
@Path("/emiservice")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface IEMIService {
	
	@GET
	@Path("/emi/{amount}/{tenure}")
	public double getEmi(@PathParam("amount") float amount, @PathParam("tenure") float tenure);

}
