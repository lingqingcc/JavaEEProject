package com.smart.web;

import com.smart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class ManageController {
    private UserService userService;

    @RequestMapping(value = "/deleteuser.html")
    public void Deleteuser(){

    }

    @RequestMapping(value = "/reviseuser.html")
    public ModelAndView Reviseuser(){

        return new ModelAndView();
    }
    @RequestMapping(value = "/gain.html")
    public ModelAndView ManageUser(HttpServletRequest request){
        List list= userService.gainUser();
        request.getSession().setAttribute("userList",list);
        return new ModelAndView("manage");
    }
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
