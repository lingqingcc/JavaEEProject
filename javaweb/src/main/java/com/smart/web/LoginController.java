package com.smart.web;

import com.smart.domain.User;
import com.smart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
public class LoginController{
	private UserService userService;

	/*
	跳转至登陆界面
	 */
	@RequestMapping(value = "/login.html")
	public ModelAndView Login(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		return mav;
	}
	/*
	跳转至注册页面
	 */
	@RequestMapping(value = "/register.html")
	public ModelAndView Register(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("register");
		return mav;
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
	/*
	登陆检测
	 */
	@RequestMapping(value = "/loginCheck.html")
	public ModelAndView LoginCheck(HttpServletRequest request,LoginCommand loginCommand){
		boolean isValidUser =  userService.hasMatchUser(loginCommand.getUserName(),
				loginCommand.getPassword());
		if (!isValidUser) {
			return new ModelAndView("login", "error", "用户名或密码错误。");
		} else {
			User user = userService.findUserByUserName(loginCommand
					.getUserName());
			user.setLastIp(request.getLocalAddr());
			user.setLastVisit(new Date());
			userService.loginSuccess(user);
			request.getSession().setAttribute("user", user);
			return new ModelAndView("main");
		}
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
