package com.nuaa.back_ma.service.impl;

import com.nuaa.back_ma.dao.IProductDao;
import com.nuaa.back_ma.domain.Product;
import com.nuaa.back_ma.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * @author: raintor
 * @Date: 2019/5/27 16:36
 * @Description:
 */
@Service
@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
public class ProductService implements IProductService {

    @Autowired
    private IProductDao productDao;

    @Override
    public List<Product> findAll() throws Exception {
        return productDao.findAll();
    }

    @Override
    public void save(Product product) throws Exception {
        UUID uuid = UUID.randomUUID();
        product.setId(uuid.toString());
        productDao.save(product);
    }
}
