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
    public User QueryUser(String userNum){
        return manageDao.QueryUser(userNum);
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
