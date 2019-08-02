package com.nuaa.back_ma.service.impl;

import com.github.pagehelper.PageHelper;
import com.nuaa.back_ma.dao.ILogDao;
import com.nuaa.back_ma.domain.SysLog;
import com.nuaa.back_ma.service.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author: raintor
 * @Date: 2019/6/2 17:00
 * @Description:
 */
@Service
@Transactional
public class LogService implements ILogService {
    @Autowired
    private ILogDao logDao;

    @Override
    public void save(SysLog log) {
        logDao.save(log);
    }

    @Override
    public List<SysLog> findAll(int page ,int size) {
        PageHelper.startPage(page,size);
        return logDao.findAll();
    }
}
