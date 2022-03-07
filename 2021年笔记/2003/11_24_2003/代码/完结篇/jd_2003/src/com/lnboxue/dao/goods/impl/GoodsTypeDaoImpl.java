package com.lnboxue.dao.goods.impl;

import com.lnboxue.dao.BaseDao;
import com.lnboxue.dao.goods.GoodsTypeDao;
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
public class GoodsTypeDaoImpl implements GoodsTypeDao {

    @Override
    public List<GoodsType> goodsTypeAllSelect() {
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
            while (resultSet.next()){
                //封装数据
                GoodsType goodsType = new GoodsType();
                goodsType.setId(resultSet.getInt("id"));
                goodsType.setName(resultSet.getString("name"));
                goodsTypeList.add(goodsType);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection,preparedStatement,resultSet);
        }
        return goodsTypeList;
    }
}
