package com.hcl.hackthon.loan.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hcl.hackthon.loan.data.UserDetail;

public class UserRowMapper implements RowMapper<UserDetail> {
	
	public UserDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserDetail ud = new UserDetail();
		ud.setId(rs.getString("UserID"));
		ud.setRole(rs.getString("UserRole"));
		ud.setUserName(rs.getString("UserName"));
		ud.setPassword(rs.getString("passwd"));
		return ud;
	}

}
