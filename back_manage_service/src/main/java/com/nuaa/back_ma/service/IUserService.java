package com.nuaa.back_ma.service;

import com.nuaa.back_ma.domain.Role;
import com.nuaa.back_ma.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

/**
 * @author: raintor
 * @Date: 2019/5/29 19:22
 * @Description:
 */
public interface IUserService extends UserDetailsService {

    List<UserInfo> findAll();

    void save(UserInfo userInfo);

    UserInfo findById(String id);

    List<Role> findRoleByUserId(String id);

    void addRoleToUser(String userId, String[] roleIds);
}
