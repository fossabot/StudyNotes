package com.lnboxue.action;

import com.lnboxue.entity.GoodsTable;
import com.lnboxue.service.goods.GoodsTableService;
import com.lnboxue.service.goods.impl.GoodsTableServiceImpl;
import com.lnboxue.utils.Page;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 商品查询控制层
 */
public class ShowGoodsServlet extends HttpServlet {

    private GoodsTableService goodsTableService;

    @Override
    public void init() throws ServletException {
        goodsTableService = new GoodsTableServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取当前页
        String strPage = request.getParameter("pageNo");
        //对当前页进行非空判断吧
        if (null==strPage || strPage.trim().length()==0){
            strPage = "1";
        }
        //进行格式类型转换
        int currPageNO = Integer.parseInt(strPage);
        //获取分页工具类（之前封装了所有分页信息）
        Page<GoodsTable> page = goodsTableService.goodsByPageAllSelect(currPageNO);
        //将需要的数据放入request对象中
        request.setAttribute("maxPageNo",page.getAllPageNO());
        request.setAttribute("goodsList",page.getList());
        //请求转发到商品列表页
        request.getRequestDispatcher("/jsp/goodsList.jsp").forward(request,response);

        //查询商品信息
        //List<GoodsTable> goodsList = goodsTableService.goodsAllSelect();
        //将商品信息保存request中
        //request.setAttribute("goodsList",goodsList);
        //请求转发商品展示页
        //request.getRequestDispatcher("/jsp/goodsList.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
