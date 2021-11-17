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
 * 商品模块控制层-商品全查询
 */
public class ShowGoodsServlet extends HttpServlet {

    private GoodsTableService goodsTableService;

    @Override
    public void init() throws ServletException {
        goodsTableService = new GoodsTableServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从客户端获取当前页
        String strPage = request.getParameter("pageNo");
        //进行非空判断
        if (strPage == null || strPage.trim().length()==0){
            strPage = "1";
        }
        //将当前页数据进行类型转换
        int currPageNO = Integer.parseInt(strPage);
        //获取分页信息
        Page<GoodsTable> page = goodsTableService.goodsByPageAllSelect(currPageNO);
        //将总页数保存到request对象中
        request.setAttribute("maxPageNo",page.getAllPageNO());
        //将商品列表信息保存到request对象中
        request.setAttribute("goodsList",page.getList());
        //请求转发到商品列表页
        request.getRequestDispatcher("/jsp/goodsList.jsp").forward(request,response);

        //调用Service方法
        //List<GoodsTable> goodsList = goodsTableService.goodsAllSelect();
        //将商品信息保存到request对象中
        //request.setAttribute("goodsList",goodsList);
        //请求转发
        //request.getRequestDispatcher("/jsp/goodsList.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
