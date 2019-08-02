package com.nuaa.back_ma.service.impl;

import com.github.pagehelper.PageHelper;
import com.nuaa.back_ma.dao.IOrdersDao;
import com.nuaa.back_ma.domain.Orders;
import com.nuaa.back_ma.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: raintor
 * @Date: 2019/5/28 15:58
 * @Description:
 */
@Service()
@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
public class OrdersService implements IOrdersService {

    @Autowired
    private IOrdersDao ordersDao;

    @Override
    public List<Orders> findAll() throws Exception {
        return ordersDao.findAll() ;
    }

    @Override
    public List<Orders> findAllF(int page,int size) throws Exception {
        PageHelper.startPage(page,size);
        return ordersDao.findAll();
    }

    @Override
    public Orders findById(String id) throws Exception {
        return ordersDao.findById(id);
    }
}
