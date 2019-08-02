package com.nuaa.back_ma.service;

import com.nuaa.back_ma.domain.Orders;

import java.util.List;

/**
 * @author: raintor
 * @Date: 2019/5/28 15:58
 * @Description:
 */
public interface IOrdersService {
    public List<Orders> findAll() throws Exception;

    public List<Orders> findAllF(int page,int size) throws Exception;

    public Orders findById(String id) throws Exception;
}
