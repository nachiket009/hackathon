package com.hcl.hackthon.loan.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import static com.hcl.hackthon.loan.dao.DaoConstants.AMOUNT;
import static com.hcl.hackthon.loan.dao.DaoConstants.LOAN_STATUS;
import static com.hcl.hackthon.loan.dao.DaoConstants.RATE_OF_INTEREST;
import static com.hcl.hackthon.loan.dao.DaoConstants.TENURE;
import static com.hcl.hackthon.loan.dao.DaoConstants.USER_ID;
import static com.hcl.hackthon.loan.dao.DaoConstants.USER_NAME;

import com.hcl.hackthon.employee.model.LoanDetail;

public class LoanDetailMapper implements RowMapper<LoanDetail> {
	
	public LoanDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
		LoanDetail ld = new LoanDetail();
		ld.setUserid(rs.getString(USER_ID));
		ld.setUsername(rs.getString(USER_NAME));
		ld.setAmount(rs.getFloat(AMOUNT));
		ld.setStatus(rs.getString(LOAN_STATUS));		
		ld.setTenure(rs.getInt(TENURE));
		ld.setRoi(rs.getFloat(RATE_OF_INTEREST));
		return ld;
	}

}
