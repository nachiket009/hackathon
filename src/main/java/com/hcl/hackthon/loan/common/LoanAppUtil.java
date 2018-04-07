package com.hcl.hackthon.loan.common;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LoanAppUtil {

	private LoanAppUtil(){
		
	}
	
	public static double getPrecisionValue(double input){	
		BigDecimal bd = BigDecimal.valueOf(input).setScale(2, RoundingMode.HALF_EVEN);
		return bd.doubleValue();
		
	}
}
