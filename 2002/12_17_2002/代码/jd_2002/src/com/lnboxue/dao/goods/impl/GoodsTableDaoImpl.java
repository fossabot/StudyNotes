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
        Object[] params = {};
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

    @Override
    public int goodsInsert(GoodsTable goodsTable) {
        //执行的sql
        String sql = "insert into goodstable (name,gtid,price,stock,remarks) values(?,?,?,?,?)";
        //数据库连接
        Connection connection = null;
        //数据库预处理对象
        PreparedStatement preparedStatement = null;
        //传递的参数
        Object[] params = {goodsTable.getName(),goodsTable.getGtId(),goodsTable.getPrice(),goodsTable.getStock(),goodsTable.getRemarks()};
        //影响的行数
        int updateRows = 0;
        try {
            //获取数据库连接
            connection = BaseDao.getConnection();
            //返回影响的行数
            updateRows = BaseDao.execute(sql,connection,preparedStatement,params);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection,preparedStatement,null);
        }
        return updateRows;
    }

    @Override
    public GoodsTable goodsByIdSelect(int id) {
        String sql = "select g.id,g.name,g.gtid,gt.name as gtname,price,stock,remarks from goodstable g inner join goodstype gt on g.gtid=gt.id where g.id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Object[] params = {id};
        GoodsTable goodsTableNew = new GoodsTable();
        try {
            connection = BaseDao.getConnection();
            resultSet = BaseDao.execute(sql,connection,preparedStatement,resultSet,params);
            if (resultSet.next()){
                goodsTableNew.setId(resultSet.getInt("id"));
                goodsTableNew.setName(resultSet.getString("name"));
                goodsTableNew.setGtId(resultSet.getInt("gtid"));
                goodsTableNew.setGtName(resultSet.getString("gtname"));
                goodsTableNew.setPrice(resultSet.getDouble("price"));
                goodsTableNew.setStock(resultSet.getInt("stock"));
                goodsTableNew.setRemarks(resultSet.getString("remarks"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection,preparedStatement,resultSet);
        }
        return goodsTableNew;
    }

    @Override
    public int goodsUpdate(GoodsTable goodsTable) {
        String sql = "update goodstable set name=?,gtid=?,price=?,stock=?,remarks=? where id=?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Object[] params = {goodsTable.getName(),goodsTable.getGtId(),goodsTable.getPrice(),goodsTable.getStock(),goodsTable.getRemarks(),goodsTable.getId()};
        //影响的行数
        int updateRows = 0;
        try {
            connection = BaseDao.getConnection();
            updateRows = BaseDao.execute(sql,connection,preparedStatement,params);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection,preparedStatement,null);
        }
        return updateRows;
    }

    @Override
    public int goodsDelete(int id) {
        String sql = "delete from goodstable where id=?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Object[] params = {id};
        //影响的行数
        int updateRows = 0;
        try {
            connection = BaseDao.getConnection();
            updateRows = BaseDao.execute(sql,connection,preparedStatement,params);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection,preparedStatement,null);
        }
        return updateRows;
    }

    @Override
    public int getTotalCount() {
        String sql = "select count(id) from goodstable";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Object[] params = {};
        //总记录数
        int allRecordNO = 0;
        try {
            connection = BaseDao.getConnection();
            resultSet = BaseDao.execute(sql,connection,preparedStatement,resultSet,params);
            //处理结果集对象
            if (resultSet.next()){
                allRecordNO = resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection,preparedStatement,resultSet);
        }
        return allRecordNO;
    }

    @Override
    public List<GoodsTable> goodsByPageAllSelect(int start, int pageSize) {
        String sql = "select * from goodstable limit ?,?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        //传递的参数
        Object[] params = {start,pageSize};
        //定义商品列表
        List<GoodsTable> goodsList = new ArrayList<>();
        try {
            connection = BaseDao.getConnection();
            resultSet = BaseDao.execute(sql,connection,preparedStatement,resultSet,params);
            //循环处理结果集对象
            while (resultSet.next()){
                GoodsTable goodsTable = new GoodsTable();
                goodsTable.setId(resultSet.getInt("id"));
                goodsTable.setName(resultSet.getString("name"));
                goodsTable.setGtId(resultSet.getInt("gtid"));
                goodsTable.setPrice(resultSet.getDouble("price"));
                goodsTable.setStock(resultSet.getInt("stock"));
                goodsTable.setRemarks(resultSet.getString("remarks"));
                //将商品数据放入到集合中
                goodsList.add(goodsTable);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection,preparedStatement,resultSet);
        }
        return goodsList;
    }

    @Override
    public int nameCheck(String name) {
        String sql = "SELECT COUNT(id) FROM goodstable WHERE NAME=?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Object[] params = {name};
        //存在的条数
        int count = 0;
        try {
            connection = BaseDao.getConnection();
            resultSet = BaseDao.execute(sql,connection,preparedStatement,resultSet,params);
            //处理结果集对象
            if (resultSet.next()){
                count = resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection,preparedStatement,resultSet);
        }
        return count;
    }
}
