package com.lnboxue.service.impl;

import com.lnboxue.dao.AdminMapper;
import com.lnboxue.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 业务层实现类
 */
@Service
public class LoginServiceImpl implements LoginService {

    //注入Mapper
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public boolean hasMatchAdmin(long adminId, String password) {
        return adminMapper.getMatchCount(adminId,password)==1;
    }

    @Override
    public String getAdminUsername(long adminId) {
        return adminMapper.getUsername(adminId);
    }
}
