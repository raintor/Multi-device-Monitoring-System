package com.nuaa.back_ma.dao;

import com.nuaa.back_ma.domain.Traveller;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: raintor
 * @Date: 2019/5/29 14:48
 * @Description:
 */
@Repository
public interface ITravellerDao {

    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId=#{id})")
    List<Traveller> findById(String id);
}
