package com.nuaa.back_ma.dao;

import com.nuaa.back_ma.domain.Role;
import com.nuaa.back_ma.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author: raintor
 * @Date: 2019/5/29 19:26
 * @Description:
 */
public interface IUserDao {


    @Select("select * from users where username=#{username}")
    @Results(id = "byname",value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",javaType = List.class,many = @Many(select = "com.nuaa.back_ma.dao.IRolesDao.findById"))
    }
    )
    UserInfo findByName(String username);

    @Select("select * from users")
    List<UserInfo> findAll();

    @Insert("insert into users values(#{id},#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo);

    @Select("select * from users where id=#{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",javaType = List.class,many = @Many(select = "com.nuaa.back_ma.dao.IRolesDao.findById"))
    })
    UserInfo findById(String id);

    @Select("select * from role where id not in (select roleId from users_role where userId=#{id})")
    List<Role> findRolesByUserId(String id);

    @Insert("insert into users_role values(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") String userId, @Param("roleId") String roleId);
}
