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
 * @description 控制层
 * @address 辽宁冶金职业技术学院
 * @created 2022/3/22 13:42
 */
@Controller
public class ReaderController {

    @Autowired
    private ReaderInfoService readerInfoService;
    @Autowired
    private ReaderCardService readerCardService;

    //调转到添加读者页面
    @RequestMapping("/reader_add.html")
    public ModelAndView readerInfoAdd(){
        return new ModelAndView("admin_reader_add");
    }

    //封装读者信息对象
    private ReaderInfo getReaderInfo(String name,String sex,String birth,String address,String phone){
        //实例化读者信息对象
        ReaderInfo readerInfo = new ReaderInfo();
        //实例化时间对象
        Date date = new Date();
        try {
            //实例时间格式化对象
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            //将字符串格式转化成日期格式
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
        //调用业务层中的读者全查询方法
        List<ReaderInfo> readers = readerInfoService.getAllReaderInfo();
        //封装将要跳转的页面信息
        ModelAndView modelAndView = new ModelAndView("admin_readers");
        //封装读者信息
        modelAndView.addObject("readers",readers);
        return modelAndView;
    }

    @RequestMapping("/readerAdd.html")
    public String readerInfoAdd(String name, String sex, String birth, String address, String phone,
                                String password, RedirectAttributes redirectAttributes){
        //封装读者信息
        ReaderInfo readerInfo = getReaderInfo(name, sex, birth, address, phone);
        //返回读者编号
        long readerId = readerInfoService.addReaderInfo(readerInfo);
        //继续封装数据
        readerInfo.setReaderId(readerId);
        //判断读者信息和借阅卡信息是否插入成功
        if (readerId>0&&readerCardService.addReaderCard(readerInfo,password)){
            //封装成功数据
            redirectAttributes.addFlashAttribute("success","添加读者信息成功！");
        } else {
            //封装失败数据
            redirectAttributes.addFlashAttribute("error","添加读者信息失败！");
        }
        return "redirect:/allReaders.html";
    }
}
