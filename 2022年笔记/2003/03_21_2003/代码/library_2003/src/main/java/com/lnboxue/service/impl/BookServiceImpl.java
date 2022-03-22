package com.lnboxue.service.impl;

import com.lnboxue.dao.BookMapper;
import com.lnboxue.pojo.Book;
import com.lnboxue.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务层实现类
 */
@Service
public class BookServiceImpl implements BookService {

    //注入Mapper
    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> getAllBooks() {
        return bookMapper.getAllBooks();
    }

    @Override
    public boolean matchBook(String condition) {
        return bookMapper.matchBook(condition)>0;
    }

    @Override
    public List<Book> getBookCondition(String condition) {
        return bookMapper.getBooksByCondition(condition);
    }

    @Override
    public boolean addBook(Book book) {
        return bookMapper.addBook(book)>0;
    }

    @Override
    public Book getBookById(long bookId) {
        return bookMapper.getBookById(bookId);
    }

    @Override
    public boolean updateBook(Book book) {
        return bookMapper.updateBook(book)>0;
    }

    @Override
    public boolean deleteBook(long bookId) {
        return bookMapper.deleteBook(bookId)>0;
    }
}
