package com.smart.web;

import com.smart.domain.User;
import com.smart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class RegisterController {
    private UserService userService;
    /*
	跳转至登陆界面
	 */
    @RequestMapping(value = "/login.html")
    public String Login(){
        return "login";
    }
    /*
    跳转至注册页面
     */
    @RequestMapping(value = "/register.html")
    public String Register(){
        return "register";
    }
    /*
    进行注册操作，并跳转至注册成功页面
     */
    @RequestMapping(value = "/create.html",method = RequestMethod.POST)
    public ModelAndView CreateUser(User user){
        userService.createUser(user);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("createSuccess");
        mav.addObject("user", user);
        return mav;
    }
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
