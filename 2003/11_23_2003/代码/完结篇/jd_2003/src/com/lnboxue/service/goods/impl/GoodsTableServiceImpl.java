package com.lnboxue.service.goods.impl;

import com.lnboxue.dao.goods.GoodsTableDao;
import com.lnboxue.dao.goods.impl.GoodsTableDaoImpl;
import com.lnboxue.entity.GoodsTable;
import com.lnboxue.service.goods.GoodsTableService;
import com.lnboxue.utils.Page;

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

    @Override
    public boolean goodsInsert(GoodsTable goodsTable) {
        //设置成功标识
        boolean isDone = false;
        if(goodsTableDao.goodsInsert(goodsTable)>0){
            //成功
            isDone = true;
        }
        return isDone;
    }

    @Override
    public GoodsTable goodsByIdSelect(int id) {
        return goodsTableDao.goodsByIdSelect(id);
    }

    @Override
    public boolean goodsUpdate(GoodsTable goodsTable) {
        boolean isDone = false;
        if(goodsTableDao.goodsUpdate(goodsTable)>0){
            isDone = true;
        }
        return isDone;
    }

    @Override
    public boolean goodsDelete(int id) {
        boolean isDone = false;
        if(goodsTableDao.goodsDelete(id)>0){
            isDone = true;
        }
        return isDone;
    }

    @Override
    public Page<GoodsTable> goodsByPageAllSelect(int currPageNO) {
        //实例化分页工具类
        Page<GoodsTable> page = new Page<>();
        //获取总记录数
        int allRecordNO = goodsTableDao.getTotalCount();
        //将分页相关数据封装进工具类
        page.setCurrPageNO(currPageNO);
        page.setAllRecordNO(allRecordNO);
        //总页数
        int allPageNO = 0;
        //判断相关情况
        if (page.getAllRecordNO() % page.getPerPageSize() == 0){
            allPageNO = page.getAllRecordNO() / page.getPerPageSize();
        } else {
            allPageNO = page.getAllRecordNO() / page.getPerPageSize() + 1;
        }
        page.setAllPageNO(allPageNO);
        //计算出起始行
        int start = (page.getCurrPageNO() - 1) * page.getPerPageSize();
        //获取商品列表
        List<GoodsTable> goodsList = goodsTableDao.goodsByPageAllSelect(start, page.getPerPageSize());
        page.setList(goodsList);
        return page;
    }
}
