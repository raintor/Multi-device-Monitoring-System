package com.nuaa.back_ma.service.impl;

import com.nuaa.back_ma.dao.IPermissionDao;
import com.nuaa.back_ma.domain.Permission;
import com.nuaa.back_ma.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * @author: raintor
 * @Date: 2019/5/31 15:20
 * @Description:
 */
@Service
@Transactional
public class PermissionService implements IPermissionService {

    @Autowired
    private IPermissionDao permissionDao;

    @Override
    public List<Permission> findAll() {
        return permissionDao.findAll();
    }

    @Override
    public void save(Permission p) {
        p.setId(UUID.randomUUID().toString().replace("-",""));
        permissionDao.save(p);
    }
}
