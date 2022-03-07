package com.lnboxue.service.goods;

import com.lnboxue.entity.GoodsTable;
import com.lnboxue.utils.Page;

import java.util.List;

/**
 * 商品模块业务层
 */
public interface GoodsTableService {

    public List<GoodsTable> goodsAllSelect();
    public boolean goodsInsert(GoodsTable goodsTable);
    public GoodsTable goodsByIdSelect(int id);
    public boolean goodsUpdate(GoodsTable goodsTable);
    public boolean goodsDelete(int id);
    public Page<GoodsTable> goodsByPageAllSelect(int currPageNO);
    boolean nameCheck(String name);
}
