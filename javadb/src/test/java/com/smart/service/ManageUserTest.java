package com.smart.service;

import com.smart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

@ContextConfiguration("classpath*:/smart-context.xml")
public class ManageUserTest extends AbstractTransactionalTestNGSpringContextTests {
    @Autowired
    private UserService userService;
    @Test
    public void gainUserTest(){
        List<User> list=new ArrayList();
        list=userService.gainUser();
        for(User sr : list) {
            System.out.println(sr.getUserId()+" "+sr.getUserName()+" "+sr.getUserNum()
                    +" "+sr.getUserAge()+" "+sr.getUserSex()+" "+sr.getPassword()
                    +" "+sr.getCredits());
        }
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
