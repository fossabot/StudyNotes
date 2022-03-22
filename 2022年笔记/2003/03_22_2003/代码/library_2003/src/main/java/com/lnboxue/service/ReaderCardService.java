package com.lnboxue.service;

import com.lnboxue.pojo.ReaderInfo;

/**
 * 业务层
 */
public interface ReaderCardService {

    boolean addReaderCard(ReaderInfo readerInfo,String password);
}
