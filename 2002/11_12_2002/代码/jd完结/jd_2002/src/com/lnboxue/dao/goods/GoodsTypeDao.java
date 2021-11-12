package com.lnboxue.dao.goods;

import com.lnboxue.entity.GoodsType;

import java.util.List;

/**
 * 商品类别数据库访问层
 */
public interface GoodsTypeDao {

    //查询商品类别
    List<GoodsType> goodsTypeAllSelect();
}
