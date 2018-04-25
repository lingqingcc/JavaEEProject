package com.smart.web;

import com.smart.domain.User;
import com.smart.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class ManageController {
    private ManageService manageService;
    @Autowired
    public ManageController(ManageService manageService) {
        this.manageService = manageService;
    }
    @RequestMapping(value = "/deleteuser.html")
    public ModelAndView Deleteuser(HttpServletRequest request) {
        String userId = request.getParameter("delId");
        manageService.deleteUser(userId);
        ManageUser(request);
        return new ModelAndView("manage");
  }
    @RequestMapping(value = "/reviseuser.html")
    public ModelAndView Reviseuser(HttpServletRequest request){
        String userNum= request.getParameter("userNum");
        User user=manageService.QueryUser(userNum);
        request.getSession().setAttribute("user",user);
        return new ModelAndView("revise");
    }
    @RequestMapping(value = "/gain.html")
    public ModelAndView ManageUser(HttpServletRequest request){
        List list= manageService.gainUser();
        request.getSession().setAttribute("userList",list);
        return new ModelAndView("manage");
    }
}
