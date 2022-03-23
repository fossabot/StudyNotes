package com.lnboxue.service;

import com.lnboxue.pojo.Book;

import java.util.List;

/**
 * 业务层
 */
public interface BookService {

    List<Book> getAllBooks();
    boolean matchBook(String condition);
    List<Book> getBookCondition(String condition);
    boolean addBook(Book book);
    Book getBookById(long bookId);
    boolean updateBook(Book book);
    boolean deleteBook(long bookId);
}
