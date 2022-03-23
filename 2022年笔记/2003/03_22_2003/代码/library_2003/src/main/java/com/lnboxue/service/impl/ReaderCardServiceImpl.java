package com.lnboxue.service.impl;

import com.lnboxue.dao.ReaderCardMapper;
import com.lnboxue.pojo.ReaderInfo;
import com.lnboxue.service.ReaderCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 李洋
 * @version 1.0.0
 * @description 实现类
 * @address 辽宁冶金职业技术学院
 * @created 2022/3/22 10:19
 */
@Service
public class ReaderCardServiceImpl implements ReaderCardService {

    @Autowired
    private ReaderCardMapper readerCardMapper;

    @Override
    public boolean addReaderCard(ReaderInfo readerInfo, String password) {
        return readerCardMapper.addReaderCard(readerInfo.getReaderId(),readerInfo.getName(),password)>0;
    }
}
