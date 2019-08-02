package com.nuaa.back_ma.controller;

import com.github.pagehelper.PageInfo;
import com.nuaa.back_ma.domain.SysLog;
import com.nuaa.back_ma.service.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author: raintor
 * @Date: 2019/6/2 18:54
 * @Description:
 */
@Controller
@RequestMapping("/sysLog")
public class SysLogController {

    @Autowired
    private ILogService logService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")Integer page, @RequestParam(name = "size",required = true,defaultValue = "9")Integer size){
        ModelAndView mv = new ModelAndView();
        List<SysLog> logs = logService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(logs);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("syslog-list");
        return mv;
    }
}
