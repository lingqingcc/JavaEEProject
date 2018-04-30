package com.smart.service;

import com.smart.dao.ManageDao;
import com.smart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManageService {
    private ManageDao manageDao;
    /*
    获取全部用户信息
     */
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
    /*
    修改用户信息
     */
    public void ReviseUser(User user){
        manageDao.ReviseUser(user);
    }
    /*
    按帐号查找用户
     */
    public User QueryNum(String userNum){
        return manageDao.QueryNum(userNum);
    }

    /*
   按用户名查找用户
    */
    public User QueryName(String userName){
        return manageDao.QueryName(userName);
    }
    @Transactional
    public void deleteUser(final String userId){

        manageDao.DeleteUser(userId);
    }
    @Autowired
    public ManageService(ManageDao manageDao) {
        this.manageDao = manageDao;
    }
}
