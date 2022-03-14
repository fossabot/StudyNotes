package com.lnboxue.dao;

import com.lnboxue.pojo.Book;

import java.util.List;

/**
 * 数据库访问层
 */
public interface BookMapper {

    //查询图书列表
    List<Book> getAllBooks();

}
