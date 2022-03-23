package com.lnboxue.service.impl;

import com.lnboxue.dao.ReaderInfoMapper;
import com.lnboxue.pojo.ReaderInfo;
import com.lnboxue.service.ReaderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 李洋
 * @version 1.0.0
 * @description 业务层实现类
 * @address 辽宁冶金职业技术学院
 * @created 2022/3/22 8:29
 */
@Service
public class ReaderInfoServiceImpl implements ReaderInfoService {

    @Autowired
    private ReaderInfoMapper readerInfoMapper;

    @Override
    public List<ReaderInfo> getAllReaderInfo() {
        return readerInfoMapper.getAllReaderInfo();
    }

    @Override
    public long addReaderInfo(ReaderInfo readerInfo) {
        //调用Mapper中插入方法，判断是否插入成功
        if (readerInfoMapper.addReaderInfo(readerInfo)>0){
            //调用读者编号查询方法
            long readerId = readerInfoMapper.getReaderId(readerInfo);
            return readerId;
        } else {
            return -1;
        }
    }
}
