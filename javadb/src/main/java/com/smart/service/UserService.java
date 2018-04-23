package com.smart.service;

import com.smart.dao.LoginLogDao;
import com.smart.dao.ManageDao;
import com.smart.dao.UserDao;
import com.smart.domain.LoginLog;
import com.smart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
	private UserDao userDao;
	private ManageDao manageDao;
	private LoginLogDao loginLogDao;


	public boolean hasMatchUser(String userNum, String password) {
		int matchCount =userDao.getMatchCount(userNum, password);
		return matchCount > 0;
	}
	public List gainUser() {
		List list=new ArrayList<User>();
		SqlRowSet sr=manageDao.ManageSelect();
		while (sr.next()){
			User user=new User();
			user.setUserId(sr.getInt(1));
			user.setUserNum(sr.getString(2));
			user.setUserName(sr.getString(3));
			user.setUserSex(sr.getString(4));
			user.setUserAge(sr.getInt(5));
			user.setPassword(sr.getString(6));
			user.setCredits(sr.getInt(7));
			list.add(user);
		}
		return list;
	}

	public User findUserByUserNum(String userNum) {

		return userDao.findUserByUserNum(userNum);
	}
	@Transactional
	public void createUser(User user){
		userDao.insertUser(user);
	}
	@Transactional
	public void loginSuccess(User user) {
		user.setCredits( 5 + user.getCredits());
		LoginLog loginLog = new LoginLog();
		loginLog.setUserId(user.getUserId());
		loginLog.setUserName(user.getUserName());
		loginLog.setUserNum(user.getUserNum());
		loginLog.setIp(user.getLastIp());
		loginLog.setLoginDate(user.getLastVisit());
		userDao.updateLoginInfo(user);
		loginLogDao.insertLoginLog(loginLog);
	}

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Autowired
	public void setLoginLogDao(LoginLogDao loginLogDao) {
		this.loginLogDao = loginLogDao;
	}
	@Autowired
	public void setManageDao(ManageDao manageDao) {
		this.manageDao = manageDao;
	}
}
