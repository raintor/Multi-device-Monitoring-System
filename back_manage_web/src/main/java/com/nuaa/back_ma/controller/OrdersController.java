package com.nuaa.back_ma.controller;

import com.github.pagehelper.PageInfo;
import com.nuaa.back_ma.domain.Orders;
import com.nuaa.back_ma.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.List;

/**
 * @author: raintor
 * @Date: 2019/5/28 15:55
 * @Description:
 */
@Controller()
@RequestMapping("/orders")
public class OrdersController {


    @Autowired
    private IOrdersService ordersService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Orders> all = ordersService.findAll();
        mv.addObject("ordersList",all);
        mv.setViewName("orders-list");
        return mv;
    }

    @RequestMapping("/findAllF.do")
    public ModelAndView findAllF(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page, @RequestParam(name = "size",required = true,defaultValue = "4")Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Orders> allF = ordersService.findAllF(page, size);
        PageInfo pageInfo = new PageInfo(allF);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-list");
        return mv;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(String id) throws Exception {
        ModelAndView mv = new ModelAndView();
        Orders orders = ordersService.findById(id);
        mv.addObject("orders",orders);
        mv.setViewName("orders-show");
        return mv;
    }
}
