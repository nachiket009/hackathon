//package com.hcl.hackthon.loan.service;
//
//import com.hcl.hackthon.employee.model.UserLoginRequest;
//import com.hcl.hackthon.employee.model.UserLoginResult;
//import com.hcl.hackthon.loan.dao.LoanDao;
//import com.hcl.hackthon.loan.data.UserDetail;
//
//public class LoginService implements ILoginService {
//
//	private LoanDao loanDao;
//	
//	public UserLoginResult getRole(UserLoginRequest userLoginRequest) {
//		UserLoginResult res = new UserLoginResult();
//		String userName = userLoginRequest.getUsername();
//		UserDetail ud = loanDao.getDetailFromUserName(userName);
//		if(ud!=null){
//			res.setValid(true);
//			res.setRole(ud.getRole());
//		}else{
//			res.setValid(false);
//		}
//		
//		return res;
//	}
//
//}
