package com.nuaa.back_ma.controller;

import com.nuaa.back_ma.domain.Permission;
import com.nuaa.back_ma.domain.Role;
import com.nuaa.back_ma.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author: raintor
 * @Date: 2019/5/31 14:31
 * @Description:
 */

@Controller
@RequestMapping("role")
public class RoleControler {

    @Autowired
    private IRoleService roleService;

    @RequestMapping("findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<Role> all = roleService.findAll();
        mv.addObject("roleList",all);
        mv.setViewName("role-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(Role role) throws ServletException, IOException {
        roleService.save(role);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndPermission(String id){
        ModelAndView mv = new ModelAndView();
        Role role = roleService.findById(id);

        List<Permission> permissionsList = roleService.findPermissionByRoleId(id);

        mv.addObject("role",role);
        mv.addObject("permissionList",permissionsList);
        mv.setViewName("role-permission-add");
        return mv;
    }

    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(String roleId,String[] ids) throws ServletException, IOException {
        roleService.addPermissionToRole(roleId,ids);
        return "redirect:findAll.do";
    }

}
