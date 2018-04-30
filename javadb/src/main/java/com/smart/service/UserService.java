package com.smart.service;

import com.smart.dao.LoginLogDao;
import com.smart.dao.UserDao;
import com.smart.domain.LoginLog;
import com.smart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private UserDao userDao;

    private LoginLogDao loginLogDao;

    public boolean hasMatchUser(String userNum, String password){
        int matchCount =userDao.getMatchCount(userNum, password);
        return matchCount > 0;
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
}
