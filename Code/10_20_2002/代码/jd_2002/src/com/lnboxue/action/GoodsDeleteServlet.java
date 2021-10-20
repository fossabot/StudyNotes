package com.lnboxue.action;

import com.lnboxue.service.goods.GoodsTableService;
import com.lnboxue.service.goods.impl.GoodsTableServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 商品功能控制层
 */
public class GoodsDeleteServlet extends HttpServlet {

    private GoodsTableService goodsTableService;

    @Override
    public void init() throws ServletException {
        goodsTableService = new GoodsTableServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取要删除的商品id
        String id = request.getParameter("id");
        //数据类型转换
        int idNew = Integer.parseInt(id);
        //调用业务层中的删除方法
        if (goodsTableService.goodsDelete(idNew)) {
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
