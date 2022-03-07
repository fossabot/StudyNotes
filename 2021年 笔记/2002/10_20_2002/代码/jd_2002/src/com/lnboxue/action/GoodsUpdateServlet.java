package com.lnboxue.action;

import com.lnboxue.dao.goods.GoodsTableDao;
import com.lnboxue.entity.GoodsTable;
import com.lnboxue.service.goods.GoodsTableService;
import com.lnboxue.service.goods.impl.GoodsTableServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 商品修改功能控制层
 */
public class GoodsUpdateServlet extends HttpServlet {

    private GoodsTableService goodsTableService;

    @Override
    public void init() throws ServletException {
        goodsTableService = new GoodsTableServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理POST请求
        request.setCharacterEncoding("utf-8");
        //获取修改页面中的表单信息
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String gtId = request.getParameter("gtId");
        String price = request.getParameter("price");
        String stock = request.getParameter("stock");
        String remarks = request.getParameter("remarks");
        //数据类型转换
        int idNew = Integer.parseInt(id);
        int gtIdNew = Integer.parseInt(gtId);
        double priceNew = Double.parseDouble(price);
        int stockNew = Integer.parseInt(stock);
        //将这些数据进行封装
        GoodsTable goodsTable = new GoodsTable();
        goodsTable.setId(idNew);
        goodsTable.setName(name);
        goodsTable.setGtId(gtIdNew);
        goodsTable.setPrice(priceNew);
        goodsTable.setStock(stockNew);
        goodsTable.setRemarks(remarks);
        //调用业务层中的修改方法
        if (goodsTableService.goodsUpdate(goodsTable)){
            //成功重定向到商品全查询的SERVLET
            response.sendRedirect(request.getContextPath() + "/ShowGoodsServlet");
        } else {
            //失败重定向到错误页
            response.sendRedirect(request.getContextPath() + "/jsp/error.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
