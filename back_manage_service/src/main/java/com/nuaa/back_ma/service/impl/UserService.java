package com.nuaa.back_ma.service.impl;

import com.github.pagehelper.PageHelper;
import com.nuaa.back_ma.dao.IUserDao;
import com.nuaa.back_ma.domain.Role;
import com.nuaa.back_ma.domain.UserInfo;
import com.nuaa.back_ma.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * @author: raintor
 * @Date: 2019/5/29 19:24
 * @Description:
 */
@Service("userService")
@Transactional
public class UserService implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo byName = userDao.findByName(username);
        User user = new User(byName.getUsername(), byName.getPassword(), byName.getStatus() == 1 ? true : false, true, true, true, getAuthority(byName.getRoles()));
        return user;
    }

    private List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        roles.stream().forEach((i) -> list.add(new SimpleGrantedAuthority("ROLE_" + i.getRoleName())));
        return list;
    }

    @Override
    public List<UserInfo> findAll() {
        return userDao.findAll();
    }

    @Override
    public void save(UserInfo userInfo) {
        userInfo.setId(UUID.randomUUID().toString().replace("-", ""));
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userDao.save(userInfo);
    }

    @Override
    public UserInfo findById(String id) {
        return userDao.findById(id);
    }

    @Override
    public List<Role> findRoleByUserId(String id) {
        return userDao.findRolesByUserId(id);
    }

    @Override
    public void addRoleToUser(String userId, String[] roleIds) {
        Arrays.stream(roleIds).forEach(role->userDao.addRoleToUser(userId,role));
    }
}
