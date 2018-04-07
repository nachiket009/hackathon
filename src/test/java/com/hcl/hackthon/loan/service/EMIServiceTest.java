package com.hcl.hackthon.loan.service;

import org.junit.Assert;
import org.junit.Test;


public class EMIServiceTest  {
	
	@Test
	public void emiTestPositive(){
		LoanService emiService = new LoanService();
		
		double actResult = emiService.getEmi(1000000, 10);
		
		Assert.assertEquals(12667.52, actResult, 0.0);
		
		
	}

}
