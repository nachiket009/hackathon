package com.hcl.hackthon.loan.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.hcl.hackthon.employee.model.LoanDecision;
import com.hcl.hackthon.employee.model.LoanDetail;
import com.hcl.hackthon.employee.model.LoanDisbursementDetails;
import com.hcl.hackthon.employee.model.LoanRequest;
import com.hcl.hackthon.employee.model.UserLoginRequest;
import com.hcl.hackthon.employee.model.UserLoginResult;
import com.hcl.hackthon.loan.common.LoanAppConstants;
import com.hcl.hackthon.loan.common.LoanAppUtil;
import com.hcl.hackthon.loan.dao.LoanDao;
import com.hcl.hackthon.loan.data.UserDetail;
import com.hcl.hackthon.loan.data.UserStatus;

public class LoanService implements ILoanService {
	
	private LoanDao loanDao;
	
	private static Logger logger = Logger.getLogger(LoanService.class);

	public double getEmi(float p, float t) {
		return calculateEmi(p, t, LoanAppConstants.RATE_OF_INTEREST);		
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
		
		logger.debug("status : " + status);
		
	}

	public void loanDecision(LoanDecision loanDecision) {
		String username = loanDecision.getUsername();
		String action = loanDecision.getAction();
		UserDetail ud = loanDao.getDetailFromUserName(username);		
		int status = loanDao.updateLoan(ud.getId(), action);
		logger.debug("status : " + status);
	}

	public LoanDetail getLoanByUserName(String username) {		
		return loanDao.getLoanDetailFromUserName(username);		
	}

	public List<LoanDetail> getAllLoans() {
		return loanDao.getAllLoans();
	}

	public LoanDisbursementDetails getLoanDisbursement(String username) {
		LoanDisbursementDetails lrd = new LoanDisbursementDetails();
		try{			
			LoanDetail loanDetail = loanDao.getLoanDetailFromUserName(username);
			String status = loanDetail.getStatus();
			if(status!=null && status.equalsIgnoreCase(LoanAppConstants.APPROVED)){
				lrd.setDisbursed(true);
				float amount = loanDetail.getAmount();
				int tenure = loanDetail.getTenure();
				double emi = calculateEmi(amount, tenure, LoanAppConstants.RATE_OF_INTEREST);
				lrd.setUsername(username);
				lrd.setTenure(loanDetail.getTenure());		
				lrd.setEmi(emi);
				lrd.setAmount(loanDetail.getAmount());
			}else{
				lrd.setDisbursed(false);
			}
		}catch(Exception e){
			lrd.setDisbursed(false);
		}
		
		return lrd;
	}
	
	private static double calculateEmi(float p, float t, float r) {
		double emi;
		
		r = r / (12 * 100); // one month interest
		t = t * 12; // one month period
		emi = (p * r * (float) Math.pow(1 + r, t)) / (float) (Math.pow(1 + r, t) - 1);
		emi = LoanAppUtil.getPrecisionValue(emi);
		return (emi);
	}

	public void setLoanDao(LoanDao loanDao) {
		this.loanDao = loanDao;
	}


}
