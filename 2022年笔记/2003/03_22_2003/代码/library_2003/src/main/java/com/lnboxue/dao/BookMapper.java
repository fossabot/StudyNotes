package com.lnboxue.dao;

import com.lnboxue.pojo.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 数据库访问层
 */
public interface BookMapper {

    //查询所以图书
    List<Book> getAllBooks();
    //查看是否有符合查询条件的图书
    int matchBook(@Param("condition") String condition);
    //按条件查询图书
    List<Book> getBooksByCondition(@Param("condition") String condition);
    //图书添加
    int addBook(Book book);
    //获取图书详情
    Book getBookById(@Param("bookId") long bookId);
    //图书修改
    int updateBook(Book book);
    //图书删除
    int deleteBook(@Param("bookId") long bookId);
}
