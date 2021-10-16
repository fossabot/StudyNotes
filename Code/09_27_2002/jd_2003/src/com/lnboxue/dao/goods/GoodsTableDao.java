package com.lnboxue.dao.goods;

import com.lnboxue.entity.GoodsTable;

import java.util.List;

/**
 * 商品模块数据库访问层
 */
public interface GoodsTableDao {

    //商品全查询
    public List<GoodsTable> goodsAllSelect();
}
