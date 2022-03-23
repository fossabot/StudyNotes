package com.lnboxue.dao;

import com.lnboxue.pojo.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 数据库访问层
 */
public interface BookMapper {

    //查询图书列表
    List<Book> getAllBooks();
    //查看是否有满足条件的图书
    int matchBook(@Param("condition") String condition);
    //查询满足条件的图书
    List<Book> getBooksByCondition(@Param("condition") String condition);
    //图书添加
    int addBook(Book book);
    //查询图书详情
    Book getBookById(@Param("bookId") long bookId);
}
