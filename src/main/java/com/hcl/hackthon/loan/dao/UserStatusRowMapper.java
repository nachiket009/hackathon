package com.hcl.hackthon.loan.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hcl.hackthon.loan.data.UserStatus;
import static com.hcl.hackthon.loan.dao.DaoConstants.AMOUNT;
import static com.hcl.hackthon.loan.dao.DaoConstants.LOAN_STATUS;
import static com.hcl.hackthon.loan.dao.DaoConstants.RATE_OF_INTEREST;
import static com.hcl.hackthon.loan.dao.DaoConstants.TENURE;
import static com.hcl.hackthon.loan.dao.DaoConstants.USER_ID;

public class UserStatusRowMapper implements RowMapper<UserStatus> {
	
	public UserStatus mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserStatus us = new UserStatus();
		us.setUserid(rs.getString(USER_ID));
		us.setLoanstatus(rs.getString(LOAN_STATUS));
		us.setAmount(rs.getFloat(AMOUNT));
		us.setTenure(rs.getInt(TENURE));
		us.setRoi(rs.getFloat(RATE_OF_INTEREST));
		return us;
	}

}
