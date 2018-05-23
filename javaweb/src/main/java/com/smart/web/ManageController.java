package com.smart.web;

import com.smart.domain.User;
import com.smart.service.ManageService;
import com.smart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

    @RestController
    public class ManageController {
        private ManageService manageService;
        private UserService userService;
    @Autowired
    public ManageController(ManageService manageService, UserService userService) {
        this.manageService = manageService;
        this.userService = userService;
    }
    /*
    按账号查询
     */
    @RequestMapping(value = "/queryNum.html")
    public ModelAndView QueryNum(HttpServletRequest request){
        String userNum=request.getParameter("queryNum");
        User user=manageService.QueryNum(userNum);
        List list=new ArrayList();
        list.add(user);
        request.getSession().setAttribute("userList",list);
        return new ModelAndView("manage");
    }
    /*
    按用户名查询
     */
    @RequestMapping(value = "/queryName.html")
    public ModelAndView QueryName(HttpServletRequest request){
        String userName=request.getParameter("queryName");
        User user=manageService.QueryName(userName);
        List list=new ArrayList();
        list.add(user);
        request.getSession().setAttribute("userList",list);
        return new ModelAndView("manage");
    }
    /*
    处理添加信息
     */
    @RequestMapping(value = "/adduser.html",method = RequestMethod.POST)
    public String CreateUser(HttpServletRequest request,User user){
        userService.createUser(user);
        ManageUser(request);
        return "manage";
    }
    /*
    处理删除用户信息请求
     */
    @RequestMapping(value = "/deleteuser.html")
    public ModelAndView Deleteuser(HttpServletRequest request) {
        String userId = request.getParameter("delId");
        manageService.deleteUser(userId);
        ManageUser(request);
        return new ModelAndView("manage");
         }
    /*
    处理修改请求，并跳转到修改信息页面
     */
    @RequestMapping(value = "/reviseuser.html")
    public ModelAndView Reviseuser(HttpServletRequest request){
        String userNum= request.getParameter("userNum");
        User user=manageService.QueryNum(userNum);
        request.getSession().setAttribute("user",user);
        return new ModelAndView("revise");
    }
    /*
    处理修改用户数据请求
     */
    @RequestMapping(value ="revise.html",method = RequestMethod.POST)
    public String Revise(HttpServletRequest request,User user){
        manageService.ReviseUser(user);
        ManageUser(request);
        return "manage";
    }
    /*
    处理获取全部用户信息请求
     */
    @RequestMapping(value = "/gain.html")
    public ModelAndView ManageUser(HttpServletRequest request){
        List list= manageService.gainUser();
        request.getSession().setAttribute("userList",list);
        return new ModelAndView("manage");
    }
}
