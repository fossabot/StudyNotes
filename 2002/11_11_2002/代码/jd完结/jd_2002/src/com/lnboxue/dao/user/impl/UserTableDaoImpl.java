package com.lnboxue.dao.user.impl;

import com.lnboxue.dao.BaseDao;
import com.lnboxue.dao.user.UserTableDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 用户模块数据库访问层实现
 */
public class UserTableDaoImpl implements UserTableDao {

    @Override
    public boolean userSelect(String name, String password) {
        //执行的sql语句
        String sql = "select * from usertable where name = ? and password = ?";
        //数据库连接对象
        Connection connection = null;
        //数据库预处理对象
        PreparedStatement preparedStatement = null;
        //结果集对象
        ResultSet resultSet = null;
        //登录标识
        boolean isExits = false;
        //传递的参数
        Object[] params = {name,password};
        try {
            //获取数据库连接
            connection = BaseDao.getConnection();
            //获取结果集对象
            resultSet = BaseDao.execute(sql,connection,preparedStatement,resultSet,params);
            //判断是否有该用户
            if(resultSet.next()){
                //重置布尔值
                isExits = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection,preparedStatement,resultSet);
        }
        return isExits;
    }
}
