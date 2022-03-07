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
 * 商品修改控制层
 */
public class GoodsUpdateServlet extends HttpServlet {

    private GoodsTableService goodsTableService;

    @Override
    public void init() throws ServletException {
        goodsTableService = new GoodsTableServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决post请求乱码
        //request.setCharacterEncoding("utf-8");
        //接收前台请求数据
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String gtId = request.getParameter("gtId");
        String price = request.getParameter("price");
        String stock = request.getParameter("stock");
        String remarks = request.getParameter("remarks");
        //将部分数据进行类型转换
        int idNew = Integer.parseInt(id);
        int gtIdNew = Integer.parseInt(gtId);
        double priceNew = Double.parseDouble(price);
        int stockNew = Integer.parseInt(stock);
        //封装数据
        GoodsTable goodsTable = new GoodsTable();
        goodsTable.setId(idNew);
        goodsTable.setName(name);
        goodsTable.setGtId(gtIdNew);
        goodsTable.setPrice(priceNew);
        goodsTable.setStock(stockNew);
        goodsTable.setRemarks(remarks);
        //判断修改是否成功
        if (goodsTableService.goodsUpdate(goodsTable)){
            response.sendRedirect(request.getContextPath() + "/ShowGoodsServlet");
        }else {
            response.sendRedirect(request.getContextPath() + "/jsp/error.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
