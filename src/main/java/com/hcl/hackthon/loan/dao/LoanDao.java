package com.hcl.hackthon.loan.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import com.hcl.hackthon.employee.model.LoanDetail;
import com.hcl.hackthon.loan.data.UserDetail;
import com.hcl.hackthon.loan.data.UserStatus;
import static com.hcl.hackthon.loan.dao.DaoConstants.AMOUNT;
import static com.hcl.hackthon.loan.dao.DaoConstants.LOAN_STATUS;
import static com.hcl.hackthon.loan.dao.DaoConstants.RATE_OF_INTEREST;
import static com.hcl.hackthon.loan.dao.DaoConstants.TENURE;
import static com.hcl.hackthon.loan.dao.DaoConstants.USER_ID;
import static com.hcl.hackthon.loan.dao.DaoConstants.USER_STATUS;
import static com.hcl.hackthon.loan.dao.DaoConstants.USER_DETAILS;
import static com.hcl.hackthon.loan.dao.DaoConstants.USER_STATUS_US;
import static com.hcl.hackthon.loan.dao.DaoConstants.USER_DETAILS_UD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;;

public class LoanDao {

	private JdbcTemplate jdbcTemplate;

	public UserDetail getDetailFromUserName(String userName, String password){		
		try{
			String sql = "select * from user_details where UserName = ? and passwd = ?";
			UserDetail ud = (UserDetail) jdbcTemplate.queryForObject(
					sql, new Object[] { userName,  password}, new UserRowMapper());			
			return ud;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}		
	}
	
	public UserDetail getDetailFromUserName(String userName){		
		try{
			String sql = "select * from user_details where UserName = ?";
			UserDetail ud = (UserDetail) jdbcTemplate.queryForObject(
					sql, new Object[] { userName }, new UserRowMapper());			
			return ud;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}		
	}
	
	public int saveLoanRequest(final UserStatus userStatus){
		int status = 0;
		final String sql = "INSERT INTO User_Status ("+USER_ID +" , "+LOAN_STATUS +", "+AMOUNT +" , "+TENURE +", "+RATE_OF_INTEREST +") "
				+ "VALUES (?, ?, ?, ? ,?)";
		try{			
			jdbcTemplate.update(new PreparedStatementCreator() {
				
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement stmt = con.prepareStatement(sql);
					stmt.setString(1, userStatus.getUserid());
					stmt.setString(2, userStatus.getLoanstatus());
					stmt.setFloat(3, userStatus.getAmount());
					stmt.setInt(4, userStatus.getTenure());
					stmt.setFloat(5, userStatus.getRoi());
					return stmt;
				}
			});
			
		}catch(Exception e){
			e.printStackTrace();
			status = 1;
		}	
		return status;
	}

	public LoanDetail getLoanDetailFromUserName(String username) {
		try{
			String sql = "select us.UserID, ud.UserName, us.Amount, us.LoanStatus, us.Tenure, us.Rate_Intr from hackathon1.user_details ud, hackathon1.User_Status us where ud.UserName = ? "
 +" and us.UserID = ud.UserID";
			LoanDetail userStatus = (LoanDetail) jdbcTemplate.queryForObject(
					sql, new Object[] { username }, new LoanDetailMapper());
			return userStatus;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}		
	}

	public int updateLoan(String userid, String action) {
		int status = 0;
		final String sql = "UPDATE " + USER_STATUS + " set " + LOAN_STATUS + "= ? where "+ USER_ID +  "= ?";
		Object[] args = {action, userid};
		try{
			jdbcTemplate.update(sql,args);
		}catch(Exception e){
			e.printStackTrace();
			status=1;
		}
		
		return status;
	}

	public List<LoanDetail> getAllLoans() {
		try{
			String sql = "select us.UserID, ud.UserName, us.Amount, us.LoanStatus, us.Tenure, us.Rate_Intr from hackathon1.user_details ud, hackathon1.User_Status us where "
 +" us.UserID = ud.UserID";
			List<LoanDetail> loanDetailList = (List<LoanDetail>) jdbcTemplate.query(
					sql, new LoanDetailMapper());
			return loanDetailList;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}		
	}
	


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

    
}
