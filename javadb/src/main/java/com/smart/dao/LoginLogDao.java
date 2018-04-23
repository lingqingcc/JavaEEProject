package com.smart.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.smart.domain.LoginLog;

@Repository
public class LoginLogDao {
	private JdbcTemplate jdbcTemplate;

	//保存登陆日志SQL
	private final static String INSERT_LOGIN_LOG_SQL= "INSERT INTO t_login_log(user_id,user_num,user_name,ip,login_datetime) VALUES(?,?,?,?,?)";
	
	public void insertLoginLog(LoginLog loginLog) {
		Object[] args = { loginLog.getUserId(),loginLog.getUserNum(),loginLog.getUserName(),loginLog.getIp(),
				          loginLog.getLoginDate() };
		jdbcTemplate.update(INSERT_LOGIN_LOG_SQL, args);
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}