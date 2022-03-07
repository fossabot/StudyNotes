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
 * 商品添加操作控制层
 */
public class GoodsAddServlet extends HttpServlet {

    private GoodsTableService goodsTableService;

    @Override
    public void init() throws ServletException {
        goodsTableService = new GoodsTableServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置请求乱码（post请求乱码）
        //request.setCharacterEncoding("utf-8");
        //获取请求数据
        String name = request.getParameter("name");
        String gtId = request.getParameter("gtId");
        String price = request.getParameter("price");
        String stock = request.getParameter("stock");
        String remarks = request.getParameter("remarks");
        //将数据转换成我们想要的类型
        int gtIdNew = Integer.parseInt(gtId);
        double priceNew = Double.parseDouble(price);
        int stockNew = Integer.parseInt(stock);
        //封装数据
        GoodsTable goodsTable = new GoodsTable();
        goodsTable.setName(name);
        goodsTable.setGtId(gtIdNew);
        goodsTable.setPrice(priceNew);
        goodsTable.setStock(stockNew);
        goodsTable.setRemarks(remarks);
        //判断是否添加成功
        if (goodsTableService.goodsInsert(goodsTable)){
            //重定向到商品全查询的Servlet
            response.sendRedirect(request.getContextPath() + "/ShowGoodsServlet");
        }else {
            //重定向到错误页
            response.sendRedirect(request.getContextPath() + "/jsp/error.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
