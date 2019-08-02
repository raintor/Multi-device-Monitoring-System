package com.nuaa.back_ma.controller;

import com.nuaa.back_ma.domain.Role;
import com.nuaa.back_ma.domain.UserInfo;
import com.nuaa.back_ma.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author: raintor
 * @Date: 2019/5/30 15:02
 * @Description:
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<UserInfo> userList = userService.findAll();
        mv.addObject("userList",userList);
        mv.setViewName("user-list");
        return mv;
    }


    @RequestMapping("/save.do")
    public String save(UserInfo userInfo) throws ServletException, IOException {
        userService.save(userInfo);
        return "redirect:findAll.do";

    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(String id){
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = userService.findById(id);
        mv.addObject("user",userInfo);
        mv.setViewName("user-show");
        return mv;
    }

    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findAllandRole(String id){
        ModelAndView mv = new ModelAndView();
        UserInfo byId = userService.findById(id);
        List<Role> roles = userService.findRoleByUserId(id);
        mv.addObject("user",byId);
        mv.addObject("roleList",roles);
        mv.setViewName("user-role-add");
        return mv;
    }

    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(String userId,@RequestParam(name = "ids",required = true) String[] roleIds) throws ServletException, IOException {
        userService.addRoleToUser(userId,roleIds);
        return "redirect:findAll.do";
    }
}
