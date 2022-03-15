package com.lnboxue.controller;

import com.lnboxue.pojo.Book;
import com.lnboxue.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 控制层
 */
@Controller
public class BookController {

    //注入Service
    @Autowired
    private BookService bookService;

    @InitBinder
    public void initBinder(WebDataBinder binder) throws Exception{
        binder.registerCustomEditor(
                Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true)
        );
    }

    @RequestMapping("/book_add.html")
    public String  addBook(){
        return "admin_book_add";
    }

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

    @RequestMapping("/bookCondition.html")
    public ModelAndView getBooksByCondition(String searchWord){
        //调用业务层中判断是否有满足条件图书的方法
        if (bookService.matchBook(searchWord)){
            //查询满足条件的图书
            List<Book> books = bookService.getBooksByCondition(searchWord);
            //封装页面信息
            ModelAndView modelAndView = new ModelAndView("admin_books");
            //封装数据信息
            modelAndView.addObject("books",books);
            return modelAndView;
        } else {
            //封装错误信息并调转页面
            return new ModelAndView("admin_books","error","没有匹配的图书");
        }
    }

    @RequestMapping("/bookAdd.html")
    public String addBook(Book book, RedirectAttributes redirectAttributes){
        //判断图书添加是否操作成功
        if (bookService.addBook(book)){
            //封装成功信息
            redirectAttributes.addFlashAttribute("success","图书添加成功！");
        } else {
            //封装失败信息
            redirectAttributes.addFlashAttribute("error","图书添加失败！");
        }
        return "redirect:/admin_books.html";
    }

    @RequestMapping("/bookDetail")
    public ModelAndView getBookDetail(HttpServletRequest request){
        //获取图书编号并进行类型转换
        long bookId = Long.parseLong(request.getParameter("bookId"));
        //调用业务层根据编号查询图书的方法
        Book book = bookService.getBookById(bookId);
        //封装页面信息
        ModelAndView modelAndView = new ModelAndView("admin_book_detail");
        //封装图书数据
        modelAndView.addObject("book",book);
        return modelAndView;
    }
}
