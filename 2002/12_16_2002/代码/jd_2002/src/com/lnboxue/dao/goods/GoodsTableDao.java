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
    //商品修改
    int goodsUpdate(GoodsTable goodsTable);
    //商品删除
    int goodsDelete(int id);
    //获取商品表的总记录数
    int getTotalCount();
    //商品分页查询
    List<GoodsTable> goodsByPageAllSelect(int start,int pageSize);

    //判断商品名称是否存在
    int nameCheck(String name);
}
