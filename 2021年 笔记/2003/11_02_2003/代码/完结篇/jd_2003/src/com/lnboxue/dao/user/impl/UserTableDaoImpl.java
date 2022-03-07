package com.lnboxue.dao.user.impl;

import com.lnboxue.dao.BaseDao;
import com.lnboxue.dao.user.UserTableDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 用户模块数据库访问实现
 */
public class UserTableDaoImpl implements UserTableDao {

    @Override
    public boolean userSelect(String name, String password) {
        //执行的SQL
        String sql = "select * from usertable where name = ? and password = ?";
        //数据库连接
        Connection connection = null;
        //预处理对象
        PreparedStatement preparedStatement = null;
        //结果集对象
        ResultSet resultSet = null;
        //设置登陆标识
        boolean isExist = false;
        //传入的参数
        Object[] params = {name,password};
        try {
            //获取数据连接
            connection = BaseDao.getConnection();
            //获取查询的结果集
            resultSet = BaseDao.execute(sql,connection,preparedStatement,resultSet,params);
            //判断是否查询出结果
            if(resultSet.next()){
                //重置标识
                isExist = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            BaseDao.closeResource(connection,preparedStatement,resultSet);
        }
        return isExist;
    }
}
