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

    //跳转到图书添加页面
    @RequestMapping("/book_add.html")
    public String addBook(){
        return "admin_book_add";
    }

    @RequestMapping("/admin_books.html")
    public ModelAndView adminBooks(){
        //调用业务层中的全查询方法
        List<Book> books = bookService.getAllBooks();
        //封装将要跳转的页面信息
        ModelAndView modelAndView = new ModelAndView("admin_books");
        //保存图书数据
        //request.setAttribute();
        modelAndView.addObject("books",books);
        return modelAndView;
    }

    @RequestMapping("/bookCondition.html")
    public ModelAndView getBooksByCondition(String searchWord){
        //调用业务层中的验证方法
        if (bookService.matchBook(searchWord)){
            //查询符合条件的图书
            List<Book> books = bookService.getBookCondition(searchWord);
            //跳转到图书列表页面
            ModelAndView modelAndView = new ModelAndView("admin_books");
            modelAndView.addObject("books",books);
            return modelAndView;
        } else {
            return new ModelAndView("admin_books","error","没有匹配的图书");
        }
    }

    @RequestMapping("/bookAdd.html")
    public String addBook(Book book, RedirectAttributes redirectAttributes){
        //判断是否添加成功
        if (bookService.addBook(book)){
            //给出添加成功提示信息
            redirectAttributes.addFlashAttribute("success","图书添加成功！");
        } else {
            //给出添加失败提示信息
            redirectAttributes.addFlashAttribute("error","图书添加失败！");
        }
        return "redirect:/admin_books.html";
    }

    @RequestMapping("/bookDetail.html")
    public ModelAndView getBookDetail(HttpServletRequest request){
        //获取参数并进行类型转换
        long bookId = Long.parseLong(request.getParameter("bookId"));
        //调用service中图书详情查询方法
        Book book = bookService.getBookById(bookId);
        //封装页面跳转信息
        ModelAndView modelAndView = new ModelAndView("admin_book_detail");
        //封装图书信息
        modelAndView.addObject("book",book);
        return modelAndView;
    }

    @RequestMapping("/bookUpdateInit.html")
    public ModelAndView getBookById(HttpServletRequest request){
        //获取将要修改的图书编号
        long bookId = Long.parseLong(request.getParameter("bookId"));
        //调用service方法获取图书信息
        Book book = bookService.getBookById(bookId);
        //封装视图信息
        ModelAndView modelAndView = new ModelAndView("admin_book_edit");
        //封装图书信息
        modelAndView.addObject("book",book);
        return modelAndView;
    }

    @RequestMapping("/bookUpdate.html")
    public String bookUpdate(Book book,RedirectAttributes redirectAttributes){
        //调用业务层的图书修改方法
        if (bookService.updateBook(book)){
            //封装成功信息
            redirectAttributes.addFlashAttribute("success","图书修改成功！");
        } else{
            //封装失败信息
            redirectAttributes.addFlashAttribute("error","图书修改失败！");
        }
        return "redirect:/admin_books.html";
    }

    @RequestMapping("/bookDelete.html")
    public String bookDelete(HttpServletRequest request,RedirectAttributes redirectAttributes){
        //获取将要删除的图书编号
        long bookId = Long.parseLong(request.getParameter("bookId"));
        //调用业务层的图书删除方法
        if (bookService.deleteBook(bookId)){
            //封装成功信息
            redirectAttributes.addFlashAttribute("success","图书删除成功！");
        } else {
            redirectAttributes.addFlashAttribute("error","图书删除失败！");
        }
        return "redirect:/admin_books.html";
    }
}
