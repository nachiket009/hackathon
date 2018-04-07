package com.hcl.hackthon.loan.service;

import org.junit.Test;

public class EMIServiceTest  {

	
	
	@Test
	public void emiTestPositive(){
		LoanService emiService = new LoanService();
		
		double result = emiService.getEmi(1000000, 10);
		System.out.println(result);
		
	}

}
