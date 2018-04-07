package com.hcl.hackthon.loan.common;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LoanAppUtil {

	
	public static double getPrecisionValue(double input){	
		BigDecimal bd = new BigDecimal(input).setScale(2, RoundingMode.HALF_EVEN);
		double result = bd.doubleValue();
		return result;
	}
}
