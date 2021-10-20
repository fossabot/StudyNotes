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
 * 商品添加功能控制层
 */
public class GoodsAddServlet extends HttpServlet {

    private GoodsTableService goodsTableService;

    @Override
    public void init() throws ServletException {
        goodsTableService = new GoodsTableServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理post请求的乱码
        request.setCharacterEncoding("utf-8");
        //获取数据
        String name = request.getParameter("name");
        String gtId = request.getParameter("gtId");
        //进行类型转换
        int gtIdNew = Integer.parseInt(gtId);
        String price = request.getParameter("price");
        //进行类型转换
        double priceNew = Double.parseDouble(price);
        String stock = request.getParameter("stock");
        //进行类型转换
        int stockNew = Integer.parseInt(stock);
        String remarks = request.getParameter("remarks");
        //封装数据
        GoodsTable goodsTable = new GoodsTable();
        goodsTable.setName(name);
        goodsTable.setGtId(gtIdNew);
        goodsTable.setPrice(priceNew);
        goodsTable.setStock(stockNew);
        goodsTable.setRemarks(remarks);
        //判断插入是否成功
        if (goodsTableService.goodsInsert(goodsTable)){
            //重定向到商品全查询的servlet
            response.sendRedirect(request.getContextPath() + "/ShowGoodsServlet");
        } else {
            response.sendRedirect(request.getContextPath() + "/jsp/error.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
