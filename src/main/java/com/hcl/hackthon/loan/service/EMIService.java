package com.hcl.hackthon.loan.service;

public class EMIService implements IEMIService {

	// [P x R x (1+R)^N]/[(1+R)^N-1]
//	public double getEmi(double amount, int tenure) {
//		double roiYearly = 7.00;
//		double roiMonthly = roiYearly / (12 * 100);
//		int n = tenure / 12;
//		double finalResult = 0.0;
//
//		double res1 = Math.pow((1 + roiMonthly), n);
//
//		double upperRes = amount * roiMonthly * res1;
//		double lowerRes = res1 - 1;
//		finalResult = upperRes / lowerRes;
//
//		return finalResult;
//	}

	public double getEmi(float p, float t) {
		float emi;
		float r = 7.00f;
		r = r / (12 * 100); // one month interest
		t = t * 12; // one month period
		emi = (p * r * (float) Math.pow(1 + r, t)) / (float) (Math.pow(1 + r, t) - 1);

		return (emi);
	}

}
