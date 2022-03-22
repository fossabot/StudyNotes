package com.lnboxue.dao;

import com.lnboxue.pojo.ReaderInfo;

import java.util.List;

public interface ReaderInfoMapper {

    //查询读者信息
    List<ReaderInfo> getAllReaderInfo();
    //添加读者信息
    int addReaderInfo(ReaderInfo readerInfo);
    //通过读者信息获取读者编号
    long getReaderId(ReaderInfo readerInfo);
}
