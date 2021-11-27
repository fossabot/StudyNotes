package com.lnboxue.dao.goods;

import com.lnboxue.entity.GoodsTable;

import java.util.List;

/**
 * 商品模块数据库访问层
 */
public interface GoodsTableDao {

    //商品全查询
    public List<GoodsTable> goodsAllSelect();
    //商品添加
    public int goodsInsert(GoodsTable goodsTable);
    //商品详情查询
    public GoodsTable goodsByIdSelect(int id);
    //商品修改
    public int goodsUpdate(GoodsTable goodsTable);
    //商品删除
    public int goodsDelete(int id);
    //获取数据表的总记录数
    public int getTotalCount();
    //分页查询商品列表
    public List<GoodsTable> goodsByPageAllSelect(int start,int pageSize);
}
