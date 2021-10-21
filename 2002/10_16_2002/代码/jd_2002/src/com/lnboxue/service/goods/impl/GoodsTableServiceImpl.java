package com.lnboxue.service.goods.impl;

import com.lnboxue.dao.goods.GoodsTableDao;
import com.lnboxue.dao.goods.impl.GoodsTableDaoImpl;
import com.lnboxue.entity.GoodsTable;
import com.lnboxue.service.goods.GoodsTableService;

import java.util.List;

/**
 * 商品业务层实现
 */
public class GoodsTableServiceImpl implements GoodsTableService {

    private GoodsTableDao goodsTableDao;

    public GoodsTableServiceImpl(){
        goodsTableDao = new GoodsTableDaoImpl();
    }

    @Override
    public List<GoodsTable> goodsAllSelect() {
        return goodsTableDao.goodsAllSelect();
    }

    @Override
    public boolean goodsInsert(GoodsTable goodsTable) {
        //假设添加失败
        boolean isDone = false;
        //判断是否插入成功
        if (goodsTableDao.goodsInsert(goodsTable)>0){
            //添加成功，重置布尔值
            isDone = true;
        }
        return isDone;
    }

    @Override
    public GoodsTable goodsByIdSelect(int id) {
        return goodsTableDao.goodsByIdSelect(id);
    }
}
