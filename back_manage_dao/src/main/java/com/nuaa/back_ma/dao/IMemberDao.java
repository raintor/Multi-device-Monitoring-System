package com.nuaa.back_ma.dao;

/**
 * @author: raintor
 * @Date: 2019/5/29 14:36
 * @Description:
 */

import com.nuaa.back_ma.domain.Member;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * 会员查询
 */
@Repository
public interface IMemberDao {

    @Select("select * from member where id=#{id}")
     Member findById(String id) throws Exception;
}
