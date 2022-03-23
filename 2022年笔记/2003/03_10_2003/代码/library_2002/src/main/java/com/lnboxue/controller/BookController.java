package com.lnboxue.controller;

import com.lnboxue.pojo.Book;
import com.lnboxue.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 控制层
 */
@Controller
public class BookController {

    //注入Service
    @Autowired
    private BookService bookService;

    @RequestMapping("/admin_books.html")
    public ModelAndView adminBooks(){
        //调用业务层中查询方法
        List<Book> books = bookService.getAllBooks();
        //跳转到图书展示页面
        ModelAndView modelAndView = new ModelAndView("admin_books");
        //保存图书数据
        modelAndView.addObject("books",books);
        return modelAndView;
    }
}
