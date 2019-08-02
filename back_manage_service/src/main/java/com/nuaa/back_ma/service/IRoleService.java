package com.nuaa.back_ma.service;

import com.nuaa.back_ma.domain.Permission;
import com.nuaa.back_ma.domain.Role;

import java.util.List;

/**
 * @author: raintor
 * @Date: 2019/5/31 14:39
 * @Description:
 */
public interface IRoleService {

    List<Role> findAll();

    void save(Role role);

    Role findById(String id);

    List<Permission> findPermissionByRoleId(String id);

    void addPermissionToRole(String roleId, String[] ids);
}
