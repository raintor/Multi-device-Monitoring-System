package com.nuaa.back_ma.service.impl;

import com.nuaa.back_ma.dao.IRolesDao;
import com.nuaa.back_ma.domain.Permission;
import com.nuaa.back_ma.domain.Role;
import com.nuaa.back_ma.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.security.RolesAllowed;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * @author: raintor
 * @Date: 2019/5/31 14:39
 * @Description:
 */

@Service
@Transactional
public class RoleService implements IRoleService {

    @Autowired
    private IRolesDao rolesDao;

    @RolesAllowed("ADMIN")
    @Override
    public List<Role> findAll() {
        return rolesDao.findAll();
    }

    @Override
    public void save(Role role) {
        role.setId(UUID.randomUUID().toString().replace("-",""));
        rolesDao.save(role);
    }

    @Override
    public Role findById(String id) {
        return rolesDao.findById2(id);
    }

    @Override
    public List<Permission> findPermissionByRoleId(String id) {
        return rolesDao.findPermissionByRoleId(id);
    }

    @Override
    public void addPermissionToRole(String roleId, String[] ids) {
        Arrays.stream(ids).forEach(perid->rolesDao.addPermissionToRole(roleId,perid));
    }
}
