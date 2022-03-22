package com.lnboxue.dao;

import com.lnboxue.pojo.ReaderInfo;

import java.util.List;

/**
 * 数据库访问层
 */
public interface ReaderInfoMapper {

    //读者全查询
    List<ReaderInfo> getAllReaderInfo();
    //添加读者
    int addReaderInfo(ReaderInfo readerInfo);
    //通过读者信息获取读者编号（成功标识），用于控制层ReaderInfo对象的封装
    long getReaderId(ReaderInfo readerInfo);
}
