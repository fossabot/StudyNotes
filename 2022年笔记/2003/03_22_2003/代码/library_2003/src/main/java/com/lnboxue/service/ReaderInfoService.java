package com.lnboxue.service;

import com.lnboxue.pojo.ReaderInfo;

import java.util.List;

/**
 * 业务层
 */
public interface ReaderInfoService {

    List<ReaderInfo> getAllReaderInfo();
    long addReaderInfo(ReaderInfo readerInfo);
}
