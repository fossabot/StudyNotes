package com.lnboxue.action;

import com.lnboxue.entity.GoodsTable;
import com.lnboxue.service.goods.GoodsTableService;
import com.lnboxue.service.goods.impl.GoodsTableServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 商品详情查询控制层
 */
public class GoodsDetailServlet extends HttpServlet {

    private GoodsTableService goodsTableService;

    @Override
    public void init() throws ServletException {
        goodsTableService = new GoodsTableServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取商品编号
        String id = request.getParameter("id");
        //将商品编号进行类型转换
        int idNew = Integer.parseInt(id);
        //调用业务层方法
        GoodsTable goodsTable = goodsTableService.goodsByIdSelect(idNew);
        //将商品信息保存到request对象中
        request.setAttribute("goodsTable",goodsTable);
        //请求转发到商品详情页
        request.getRequestDispatcher("/jsp/goodsDetail.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
