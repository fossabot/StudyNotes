package com.lnboxue.controller;

import com.lnboxue.pojo.ReaderInfo;
import com.lnboxue.service.ReaderCardService;
import com.lnboxue.service.ReaderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author 李洋
 * @version 1.0.0
 * @description
 * @address 辽宁冶金职业技术学院
 * @created 2022/3/22 8:33
 */
@Controller
public class ReaderController {

    @Autowired
    private ReaderInfoService readerInfoService;
    @Autowired
    private ReaderCardService readerCardService;

    //调转到读者添加页面
    @RequestMapping("/reader_add.html")
    public ModelAndView readerInfoAdd(){
        return new ModelAndView("admin_reader_add");
    }

    //封装读者信息数据
    private ReaderInfo getReaderInfo(String name,String sex,String birth,String address,String phone){
        //实例化读者信息对象
        ReaderInfo readerInfo = new ReaderInfo();
        //实例化时间对象
        Date date = new Date();
        try {
            //实例化日期格式化对象
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            //将字符串转化为日期格式对象
            date = sdf.parse(birth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //封装数据
        readerInfo.setAddress(address);
        readerInfo.setName(name);
        readerInfo.setPhone(phone);
        readerInfo.setSex(sex);
        readerInfo.setBirth(date);
        return readerInfo;
    }

    @RequestMapping("/allReaders.html")
    public ModelAndView allReaders(){
        //调用业务层中的查询方法
        List<ReaderInfo> readers = readerInfoService.getAllReaderInfo();
        //封装将要跳转的页面信息
        ModelAndView modelAndView = new ModelAndView("admin_readers");
        //封装读者数据
        modelAndView.addObject("readers",readers);
        return modelAndView;
    }

    @RequestMapping("/readerAdd.html")
    public String readInfoAdd(String name, String sex, String birth, String address, String phone,
                              String password, RedirectAttributes redirectAttributes){
        //封装读者信息数据
        ReaderInfo readerInfo = getReaderInfo(name,sex,birth,address,phone);
        //调用业务层的添加方法，并得到读者编号
        long readerId = readerInfoService.addReaderInfo(readerInfo);
        //封装读者信息对象
        readerInfo.setReaderId(readerId);
        //调用业务方法，向读者信息表和借阅卡表插入数据
        if (readerId>0&&readerCardService.addReaderCard(readerInfo,password)){
            //封装成功信息
            redirectAttributes.addFlashAttribute("success","添加读者信息成功！");
        } else {
            //封装失败信息
            redirectAttributes.addFlashAttribute("error","添加读者信息失败！");
        }
        return "redirect:/allReaders.html";
    }
}
