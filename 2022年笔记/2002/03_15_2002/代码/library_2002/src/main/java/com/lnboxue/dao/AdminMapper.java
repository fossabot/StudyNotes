package com.lnboxue.dao;

import org.apache.ibatis.annotations.Param;

/**
 * 数据库访问层
 */
public interface AdminMapper {

    //登录验证
    int getMatchCount(@Param("adminId") long adminId,@Param("password") String password);
    //查询用户名
    String getUsername(long adminId);
}
