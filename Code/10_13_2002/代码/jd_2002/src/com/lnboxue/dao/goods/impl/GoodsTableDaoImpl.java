package com.lnboxue.dao.goods.impl;

import com.lnboxue.dao.BaseDao;
import com.lnboxue.dao.goods.GoodsTableDao;
import com.lnboxue.entity.GoodsTable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 商品模块数据库访问层实现
 */
public class GoodsTableDaoImpl implements GoodsTableDao {

    @Override
    public List<GoodsTable> goodsAllSelect() {
        //执行的sql
        String sql = "select * from goodstable";
        //数据库连接对象
        Connection connection = null;
        //数据库预处理对象
        PreparedStatement preparedStatement = null;
        //结果集对象
        ResultSet resultSet = null;
        //传递的参数
        Object[] params = null;
        //商品列表
        List<GoodsTable> goodsList = new ArrayList<>();
        try {
            //获取数据库连接
            connection = BaseDao.getConnection();
            //获取查询的结果集
            resultSet = BaseDao.execute(sql,connection,preparedStatement,resultSet,params);
            //循环查询结果集
            while (resultSet.next()){
                //实例化商品对象
                GoodsTable goodsTable = new GoodsTable();
                //封装数据
                goodsTable.setId(resultSet.getInt("id"));
                goodsTable.setName(resultSet.getString("name"));
                goodsTable.setGtId(resultSet.getInt("gtid"));
                goodsTable.setPrice(resultSet.getDouble("price"));
                goodsTable.setStock(resultSet.getInt("stock"));
                goodsTable.setRemarks(resultSet.getString("remarks"));
                goodsList.add(goodsTable);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection,preparedStatement,resultSet);
        }
        return goodsList;
    }
}
