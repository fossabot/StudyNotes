package com.lnboxue.service.goods.impl;

import com.lnboxue.dao.goods.GoodsTableDao;
import com.lnboxue.dao.goods.impl.GoodsTableDaoImpl;
import com.lnboxue.entity.GoodsTable;
import com.lnboxue.service.goods.GoodsTableService;

import java.util.List;

/**
 * 商品模块业务层实现
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
}
