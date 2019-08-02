package com.nuaa.back_ma.service;

import com.nuaa.back_ma.domain.SysLog;

import java.util.List;

/**
 * @author: raintor
 * @Date: 2019/6/2 16:59
 * @Description:
 */
public interface ILogService {
    void save(SysLog log);

    List<SysLog> findAll(int page,int size);
}
