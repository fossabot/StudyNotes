package com.lnboxue.dao;

import com.lnboxue.pojo.ReaderInfo;

import java.util.List;

public interface ReaderInfoMapper {

    //查询读者信息
    List<ReaderInfo> getAllReaderInfo();
}
