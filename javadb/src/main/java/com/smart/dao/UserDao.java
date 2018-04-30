package com.smart.dao;

import com.smart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;

@Repository
public class UserDao {
	private JdbcTemplate jdbcTemplate;

	private  final static String MATCH_COUNT_SQL = " SELECT count(*) FROM t_user  " +
			" WHERE user_num =? and password=? ";
	private  final static String UPDATE_LOGIN_INFO_SQL = " UPDATE t_user SET " +
			" last_visit=?,last_ip=?,credits=?  WHERE user_id =?";
	private final static String INSERT_USER_SQL= "INSERT INTO t_user(user_id,user_num,user_name,user_sex,user_age,password) VALUES(?,?,?,?,?,?)";

	public void insertUser(User user ) {
		Object[] args = { user.getUserId(),user.getUserNum(), user.getUserName(),user.getUserSex(),user.getUserAge(), user.getPassword() };
		jdbcTemplate.update(INSERT_USER_SQL, args);
	}
	public int getMatchCount(String userNum, String password) {

		return jdbcTemplate.queryForObject(MATCH_COUNT_SQL, new Object[]{userNum, password},Integer.class);
	}

	public User findUserByUserNum(final String userNum) {
		String sqlStr = " SELECT user_id,user_num,user_name,user_sex,user_age,credits "
				+ " FROM t_user WHERE user_num =? ";
		final User user = new User();
		jdbcTemplate.query(sqlStr, new Object[] { userNum },
				(ResultSet rs) -> {
					user.setUserId(rs.getInt("user_id"));
					user.setUserNum(userNum);
					user.setUserName(rs.getString("user_name"));
					user.setUserSex(rs.getString("user_sex"));
					user.setUserAge(rs.getInt("user_age"));
					user.setCredits(rs.getInt("credits"));
				});
		return user;
	}
	public void updateLoginInfo(User user) {
		jdbcTemplate.update(UPDATE_LOGIN_INFO_SQL, new Object[] {
				user.getLastVisit(), user.getLastIp(),user.getCredits(),user.getUserId()});
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
