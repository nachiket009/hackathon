package com.hcl.hackthon.loan.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.hcl.hackthon.employee.model.LoanDecision;
import com.hcl.hackthon.employee.model.LoanDetail;
import com.hcl.hackthon.employee.model.LoanRequest;
import com.hcl.hackthon.employee.model.UserLoginRequest;
import com.hcl.hackthon.employee.model.UserLoginResult;
import com.hcl.hackthon.loan.common.LoanAppConstants;
import com.hcl.hackthon.loan.dao.LoanDao;
import com.hcl.hackthon.loan.data.UserDetail;
import com.hcl.hackthon.loan.data.UserStatus;

public class LoanService implements ILoanService {
	
	private LoanDao loanDao;
	
	static Logger LOGGER = Logger.getLogger(LoanService.class);

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

	public void applyLoan(LoanRequest loanRequest) {
		String username = loanRequest.getUsername();
		UserDetail userDetail = loanDao.getDetailFromUserName(username);		
		UserStatus userStatus = new UserStatus();
		
		userStatus.setUserid(userDetail.getId());
		userStatus.setAmount(loanRequest.getAmount());
		userStatus.setRoi(LoanAppConstants.RATE_OF_INTEREST);
		userStatus.setTenure(loanRequest.getTenure());
		userStatus.setLoanstatus(LoanAppConstants.PENDING);
		
		int status = loanDao.saveLoanRequest(userStatus);
		
		LOGGER.debug("status : " + status);
		
	}

	public void loanDecision(LoanDecision loanDecision) {
		String username = loanDecision.getUsername();
		String action = loanDecision.getAction();
		UserDetail ud = loanDao.getDetailFromUserName(username);		
		int status = loanDao.updateLoan(ud.getId(), action);
		LOGGER.debug("status : " + status);
	}

	public LoanDetail getLoanByUserName(String username) {		
		LoanDetail loanDetail = loanDao.getLoanDetailFromUserName(username);
		return loanDetail;		
	}

	public List<LoanDetail> getAllLoans() {
		List<LoanDetail> loanDetailList = loanDao.getAllLoans();
		return loanDetailList;
	}

	public void getAllLoansByStatus(String status) {
		// TODO Auto-generated method stub
		
	}

	public void setLoanDao(LoanDao loanDao) {
		this.loanDao = loanDao;
	}

}
