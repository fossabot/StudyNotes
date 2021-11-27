package com.lnboxue.dao.goods;

import com.lnboxue.entity.GoodsType;

import java.util.List;

/**
 * 商品类别数据库访问层
 */
public interface GoodsTypeDao {

    //商品类别查询
    List<GoodsType> goodsTypeAllSelect();
}
