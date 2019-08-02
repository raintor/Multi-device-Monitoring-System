package com.nuaa.back_ma.service;

import com.nuaa.back_ma.domain.Permission;

import java.util.List;

/**
 * @author: raintor
 * @Date: 2019/5/31 15:20
 * @Description:
 */
public interface IPermissionService {

    List<Permission> findAll();

    void save(Permission p);
}
