package com.lnboxue.dao.goods.impl;

import com.lnboxue.dao.BaseDao;
import com.lnboxue.entity.GoodsTable;
import com.lnboxue.entity.GoodsType;
import com.lnboxue.service.goods.GoodsTableService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 商品类别模块实现
 */
public class GoodsTypeDaoImpl implements GoodsTableService {

    @Override
    public List<GoodsTable> goodsAllSelect() {
        //执行的sql
        String sql = "select * from goodstype";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Object[] params = {};
        List<GoodsType> goodsTypeList = new ArrayList<>();
        try {
            connection = BaseDao.getConnection();
            resultSet = BaseDao.execute(sql,connection,preparedStatement,resultSet,params);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
