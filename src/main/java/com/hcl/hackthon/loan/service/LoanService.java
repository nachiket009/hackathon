package com.hcl.hackthon.loan.service;

import com.hcl.hackthon.employee.model.UserLoginRequest;
import com.hcl.hackthon.employee.model.UserLoginResult;
import com.hcl.hackthon.loan.dao.LoanDao;
import com.hcl.hackthon.loan.data.UserDetail;

public class LoanService implements ILoanService {
	
	private LoanDao loanDao;

	public double getEmi(float p, float t) {
		float emi;
		float r = 7.00f;
		r = r / (12 * 100); // one month interest
		t = t * 12; // one month period
		emi = (p * r * (float) Math.pow(1 + r, t)) / (float) (Math.pow(1 + r, t) - 1);

		return (emi);
	}
	
	public UserLoginResult getRole(UserLoginRequest userLoginRequest) {
		UserLoginResult res = new UserLoginResult();
		String userName = userLoginRequest.getUsername();
		String password = userLoginRequest.getPassword();
		UserDetail ud = loanDao.getDetailFromUserName(userName, password);
		if(ud!=null){
			res.setValid(true);
			res.setRole(ud.getRole());
		}else{
			res.setValid(false);
		}
		return res;
	}

	public void setLoanDao(LoanDao loanDao) {
		this.loanDao = loanDao;
	}

}
