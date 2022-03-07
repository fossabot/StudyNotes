package com.lnboxue.dao.goods.impl;

import com.lnboxue.dao.BaseDao;
import com.lnboxue.dao.goods.GoodsTypeDao;
import com.lnboxue.entity.GoodsType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 商品列表数据库访问层实现
 */
public class GoodsTypeDaoImpl implements GoodsTypeDao {

    @Override
    public List<GoodsType> goodsTypeAllSelect() {
        //执行sql
        String sql = "select * from goodstype";
        //数据库连接对象
        Connection connection = null;
        //数据库预处理对象
        PreparedStatement preparedStatement = null;
        //数据库结果集对象
        ResultSet resultSet = null;
        //传递的参数
        Object[] params = {};
        //定义商品类别列表
        List<GoodsType> goodsTypeList = new ArrayList<>();
        try {
            //获取数据库连接
            connection = BaseDao.getConnection();
            //获取查询的结果集
            resultSet = BaseDao.execute(sql,connection,preparedStatement,resultSet,params);
            //处理查询结果
            while (resultSet.next()){
                //进行数据封装
                GoodsType goodsType = new GoodsType();
                goodsType.setId(resultSet.getInt("id"));
                goodsType.setName(resultSet.getString("name"));
                //将类别信息放入集合中
                goodsTypeList.add(goodsType);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            BaseDao.closeResource(connection,preparedStatement,resultSet);
        }
        return goodsTypeList;
    }
}
