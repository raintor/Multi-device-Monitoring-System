package com.nuaa.back_ma.dao;

import com.nuaa.back_ma.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: raintor
 * @Date: 2019/6/2 17:00
 * @Description:
 */
public interface ILogDao {

    @Insert("insert into syslog values(#{id},#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    void save(SysLog sysLog);

    @Select("select * from syslog")
    List<SysLog> findAll();
}
