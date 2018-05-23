package com.smart.service;

import com.smart.dao.UserDao;
import com.smart.domain.User;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;



import java.util.ArrayList;
import java.util.List;

@ContextConfiguration("classpath*:/smart-context.xml")
public class ManageUserTest extends AbstractTransactionalTestNGSpringContextTests {
    @Autowired
    private ManageService manageService;
    private UserDao userDao;

    @Test
    public void gainUserTest(){
        List<User> list=new ArrayList();
        list=manageService.gainUser();
        for(User sr : list) {
            System.out.println(sr.getUserId()+" "+sr.getUserName()+" "+sr.getUserNum()
                    +" "+sr.getUserAge()+" "+sr.getUserSex()+" "+sr.getPassword()
                    +" "+sr.getCredits());
        }
    }
    @Test
    public void QueryUserTest(){
        User user=userDao.findUserByUserNum("201608020222");
        System.out.println(user.getUserId());
        System.out.println(user.getUserNum());
        System.out.println(user.getUserName());
    }
    @Autowired
    public ManageUserTest(UserDao userDao) {
        this.userDao = userDao;
    }

}
