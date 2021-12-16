package com.lnboxue.service.goods.impl;

import com.lnboxue.dao.goods.GoodsTableDao;
import com.lnboxue.dao.goods.impl.GoodsTableDaoImpl;
import com.lnboxue.entity.GoodsTable;
import com.lnboxue.service.goods.GoodsTableService;
import com.lnboxue.utils.Page;

import java.util.List;

/**
 * 商品业务层实现
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
        //假设添加失败
        boolean isDone = false;
        //判断是否插入成功
        if (goodsTableDao.goodsInsert(goodsTable)>0){
            //添加成功，重置布尔值
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
        //判断是否修改成功
        if(goodsTableDao.goodsUpdate(goodsTable)>0){
            isDone = true;
        }
        return isDone;
    }

    @Override
    public boolean goodsDelete(int id) {
        boolean isDone = false;
        if (goodsTableDao.goodsDelete(id)>0){
            isDone = true;
        }
        return isDone;
    }

    @Override
    public Page<GoodsTable> goodsByPageAllSelect(int currPageNO) {
        //实例化分页工具类
        Page<GoodsTable> page = new Page<>();
        //总记录数
        int allRecordNO = goodsTableDao.getTotalCount();
        //封装当前页
        page.setCurrPageNO(currPageNO);
        //封装总记录数
        page.setAllRecordNO(allRecordNO);
        //总页数
        int allPageNO = 0;
        //判断并计算总页数
        if (page.getAllRecordNO() % page.getPerPageSize()==0){
            allPageNO = page.getAllRecordNO() / page.getPerPageSize();
        } else {
            allPageNO = page.getAllRecordNO() / page.getPerPageSize() + 1;
        }
        //封装总页数
        page.setAllPageNO(allPageNO);
        //计算起始行
        int start = (page.getCurrPageNO() - 1) * page.getPerPageSize();
        //调用数据库访问层的分页方法
        List<GoodsTable> goodsList = goodsTableDao.goodsByPageAllSelect(start, page.getPerPageSize());
        //封装分页后的列表信息
        page.setList(goodsList);
        return page;
    }

    @Override
    public boolean nameCheck(String name) {
        boolean isExist = false;
        if (goodsTableDao.nameCheck(name)>0){
            //重置布尔值
            isExist = true;
        }
        return isExist;
    }
}
