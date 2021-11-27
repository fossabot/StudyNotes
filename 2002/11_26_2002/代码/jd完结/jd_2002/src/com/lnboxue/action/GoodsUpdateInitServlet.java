package com.lnboxue.action;

import com.lnboxue.entity.GoodsTable;
import com.lnboxue.service.goods.GoodsTableService;
import com.lnboxue.service.goods.impl.GoodsTableServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class GoodsUpdateInitServlet extends HttpServlet {

    private GoodsTableService goodsTableService;

    @Override
    public void init() throws ServletException {
        goodsTableService = new GoodsTableServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取商品id
        String id = request.getParameter("id");
        //数据类型转换
        int idNew = Integer.parseInt(id);
        //调用业务层方法
        GoodsTable goodsTable = goodsTableService.goodsByIdSelect(idNew);
        //保存商品信息到request对象中
        request.setAttribute("goodsTable",goodsTable);
        //请求转发到修改页面
        request.getRequestDispatcher("/jsp/goodsUpdate.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
