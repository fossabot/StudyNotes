package com.lnboxue.service;

import com.lnboxue.pojo.ReaderInfo;

/**
 * 业务层
 */
public interface ReaderCardService {

    //添加借阅卡信息
    boolean addReaderCard(ReaderInfo readerInfo,String password);
}
