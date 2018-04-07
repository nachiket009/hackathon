package com.hcl.hackthon.loan.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.hcl.hackthon.loan.data.UserDetail;

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

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

    
}
