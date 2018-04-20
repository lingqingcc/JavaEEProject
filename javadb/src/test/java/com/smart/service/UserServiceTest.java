package com.smart.service;

import java.util.Date;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import com.smart.domain.User;
import static org.testng.Assert.*;

@ContextConfiguration("classpath*:/smart-context.xml")
public class UserServiceTest extends AbstractTransactionalTestNGSpringContextTests {

	@Autowired
    private UserService userService;

	@Test
	public void testHasMatchUser() {
		boolean b1 = userService.hasMatchUser("201608020200", "123456");
		boolean b2 = userService.hasMatchUser("201608020200", "1111");
		assertTrue(b1);
		assertTrue(!b2);
	}

	@Test
     public void testFindUserByUserNum()throws Exception{
        for(int i =0; i< 100;i++) {
            User user = userService.findUserByUserNum("201608020222");
            assertEquals(user.getUserNum(), "201608020222");
        }

    }


	@Test
	public void testAddLoginLog() {
		User user = userService.findUserByUserNum("201608020222");
		user.setUserId(1);
		user.setUserName("admin");
		user.setLastIp("192.168.12.7");
		user.setLastVisit(new Date());
		userService.loginSuccess(user);
	}
}
