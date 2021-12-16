package com.lnboxue.service.goods;

import com.lnboxue.entity.GoodsTable;
import com.lnboxue.utils.Page;

import java.util.List;

/**
 * 商品模块业务层
 */
public interface GoodsTableService {

    List<GoodsTable> goodsAllSelect();
    boolean goodsInsert(GoodsTable goodsTable);
    GoodsTable goodsByIdSelect(int id);
    boolean goodsUpdate(GoodsTable goodsTable);
    boolean goodsDelete(int id);
    Page<GoodsTable> goodsByPageAllSelect(int currPageNO);

    boolean nameCheck(String name);
}
