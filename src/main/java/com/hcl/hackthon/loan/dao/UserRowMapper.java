package com.hcl.hackthon.loan.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import static com.hcl.hackthon.loan.dao.DaoConstants.USER_ID;
import static com.hcl.hackthon.loan.dao.DaoConstants.USER_ROLE;
import static com.hcl.hackthon.loan.dao.DaoConstants.USER_NAME;
import static com.hcl.hackthon.loan.dao.DaoConstants.PASSWORD;

import com.hcl.hackthon.loan.data.UserDetail;

public class UserRowMapper implements RowMapper<UserDetail> {
	
	public UserDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserDetail ud = new UserDetail();
		ud.setId(rs.getString(USER_ID));
		ud.setRole(rs.getString(USER_ROLE));
		ud.setUserName(rs.getString(USER_NAME));
		ud.setPassword(rs.getString(PASSWORD));
		return ud;
	}

}
