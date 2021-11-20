package com.lnboxue.dao.user;

/**
 * 用户模块数据库访问层
 */
public interface UserTableDao {

    //用户登录
    boolean userSelect(String name,String password);
}
