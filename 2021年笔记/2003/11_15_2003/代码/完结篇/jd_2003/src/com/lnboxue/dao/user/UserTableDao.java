package com.lnboxue.dao.user;

/**
 * 用户模块数据访问接口
 */
public interface UserTableDao {

    //登陆验证
    public boolean userSelect(String name,String password);
}
