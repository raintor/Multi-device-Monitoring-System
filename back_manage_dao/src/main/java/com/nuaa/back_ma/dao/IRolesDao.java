package com.nuaa.back_ma.dao;

import com.nuaa.back_ma.domain.Permission;
import com.nuaa.back_ma.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author: raintor
 * @Date: 2019/5/29 19:47
 * @Description:
 */
public interface IRolesDao {

    @Select("select * from role where id in (select roleId from users_role where userId=#{id})")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = List.class,many = @Many(select = "com.nuaa.back_ma.dao.IPermissionDao.findById")),
    })
    public List<Role> findById(String id);


    @Select("select * from role")
    List<Role> findAll();

    @Insert("insert into role values(#{id},#{roleName},#{roleDesc})")
    void save(Role role);

    @Select("select * from role where id=#{id}")
    Role findById2(String id);

    @Select("select * from permission where id not in (select permissionId from role_permission where roleId=#{id})")
    List<Permission> findPermissionByRoleId(String id);

    @Insert("insert into role_permission values(#{perid},#{roleId})")
    void addPermissionToRole(@Param("roleId") String roleId, @Param("perid") String perid);
}
