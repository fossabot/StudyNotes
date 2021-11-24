package com.lnboxue.service.goods.impl;

import com.lnboxue.dao.goods.GoodsTypeDao;
import com.lnboxue.dao.goods.impl.GoodsTypeDaoImpl;
import com.lnboxue.entity.GoodsType;
import com.lnboxue.service.goods.GoodsTypeService;

import java.util.List;

/**
 * 商品类别模块业务实现
 */
public class GoodsTypeServiceImpl implements GoodsTypeService {

    private GoodsTypeDao goodsTypeDao;

    public GoodsTypeServiceImpl(){
        goodsTypeDao = new GoodsTypeDaoImpl();
    }

    @Override
    public List<GoodsType> goodsTypeAllSelect() {
        return goodsTypeDao.goodsTypeAllSelect();
    }
}
