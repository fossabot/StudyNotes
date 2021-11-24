package com.lnboxue.service.user.impl;

import com.lnboxue.dao.user.UserTableDao;
import com.lnboxue.dao.user.impl.UserTableDaoImpl;
import com.lnboxue.service.user.UserTableService;

/**
 * 用户模块业务层实现
 */
public class UserTableServiceImpl implements UserTableService {

    private UserTableDao userTableDao;

    public UserTableServiceImpl(){
        userTableDao = new UserTableDaoImpl();
    }

    @Override
    public boolean userSelect(String name, String password) {
        return userTableDao.userSelect(name,password);
    }
}
