package com.nuaa.back_ma.service;

/**
 * @author: raintor
 * @Date: 2019/5/27 16:35
 * @Description:
 */

import com.nuaa.back_ma.domain.Product;

import java.util.List;

/**
 * service层的product接口
 */
public interface IProductService {
    /**
     * 查询所有
     * @return
     * @throws Exception
     */
    List<Product> findAll() throws Exception;

    void save(Product product) throws Exception;
}
