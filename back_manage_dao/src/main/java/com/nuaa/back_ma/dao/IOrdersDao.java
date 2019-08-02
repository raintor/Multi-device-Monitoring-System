package com.nuaa.back_ma.dao;

import com.nuaa.back_ma.domain.Member;
import com.nuaa.back_ma.domain.Orders;
import com.nuaa.back_ma.domain.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: raintor
 * @Date: 2019/5/28 15:57
 * @Description:
 */
@Repository
public interface IOrdersDao {

    @Select("select * from orders")
    @Results( id="findorderwithproduct" ,value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "product", column = "productID", javaType = Product.class, one = @One(select = "com.nuaa.back_ma.dao.IProductDao.findById"))
    }
    )
    public List<Orders> findAll() throws Exception;

    @Select("select * from orders where id=#{id}")
    @Results(id="findByid",value = {
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "product", column = "productId", javaType = Product.class, one = @One(select = "com.nuaa.back_ma.dao.IProductDao.findById")),
            @Result(property = "member",column = "memberId",javaType = Member.class,one = @One(select = "com.nuaa.back_ma.dao.IMemberDao.findById")),
            @Result(property = "travellers",column = "id",javaType = List.class,many = @Many(select = "com.nuaa.back_ma.dao.ITravellerDao.findById"))
    }
    )
    public Orders findById(String id) throws Exception;
}
