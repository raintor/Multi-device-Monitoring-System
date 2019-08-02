package com.nuaa.back_ma.dao;

/**
 * @author: raintor
 * @Date: 2019/5/27 16:33
 * @Description:
 */

import com.nuaa.back_ma.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 *操作商品的dao
 */
@Repository
public interface IProductDao {
    /**
     * 查寻所有
     * @return
     * @throws Exception
     */
    @Select("select * from product")
    List<Product> findAll() throws Exception;

    /**
     * save
     * @param product
     * @throws Exception
     */
    @Insert("insert into product values(#{id},#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product) throws Exception;

    @Select("select * from product where id=#{id}")
    Product findById(String id);

}
