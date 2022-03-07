package com.lnboxue.dao.goods;

import com.lnboxue.entity.GoodsTable;

import java.util.List;

/**
 * 商品模块数据库访问层
 */
public interface GoodsTableDao {

    //商品全查询
    List<GoodsTable> goodsAllSelect();
    //商品添加
    int goodsInsert(GoodsTable goodsTable);
    //商品详情查询
    GoodsTable goodsByIdSelect(int id);
}
