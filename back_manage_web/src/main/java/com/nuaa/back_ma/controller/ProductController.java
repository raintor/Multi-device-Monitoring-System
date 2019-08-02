package com.nuaa.back_ma.controller;

import com.nuaa.back_ma.domain.Product;
import com.nuaa.back_ma.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resources;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author: raintor
 * @Date: 2019/5/27 17:09
 * @Description:
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    //查询所有商品
    @RequestMapping("/findAll.do")
    public ModelAndView findAll()  {
        ModelAndView mv = new ModelAndView();
        List<Product> all = null;
        try {
            all = productService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        mv.addObject("productList",all);
        mv.setViewName("product_list");
        System.out.println(all);
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(Product product) throws Exception {
       // productService.save(product);
        return "redirect:findAll.do";
    }
}
