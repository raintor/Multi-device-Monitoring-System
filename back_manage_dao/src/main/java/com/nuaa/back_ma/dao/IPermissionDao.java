package com.nuaa.back_ma.dao;

import com.nuaa.back_ma.domain.Permission;
import com.nuaa.back_ma.domain.Role;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: raintor
 * @Date: 2019/5/30 18:51
 * @Description:
 */
public interface IPermissionDao {


    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{id})")
    List<Permission> findById(String id);

    @Select("select * from permission")
    List<Permission> findAll();

    @Insert("insert into permission values(#{id},#{permissionName},#{url})")
    void save(Permission p);
}
