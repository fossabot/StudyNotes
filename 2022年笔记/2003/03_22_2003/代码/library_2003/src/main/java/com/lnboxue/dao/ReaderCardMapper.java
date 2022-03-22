package com.lnboxue.dao;

import com.lnboxue.pojo.ReaderInfo;
import org.apache.ibatis.annotations.Param;

/**
 * 数据库访问层
 */
public interface ReaderCardMapper {

    //添加借阅卡信息
    int addReaderCard(@Param("readerId") long readerId,@Param("username") String username,@Param("password") String password);
}
