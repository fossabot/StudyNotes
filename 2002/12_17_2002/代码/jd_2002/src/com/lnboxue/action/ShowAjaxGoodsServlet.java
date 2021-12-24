package com.lnboxue.action;

import com.alibaba.fastjson.JSONArray;
import com.lnboxue.entity.GoodsTable;
import com.lnboxue.service.goods.GoodsTableService;
import com.lnboxue.service.goods.impl.GoodsTableServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * 商品全查询控制层（AJAX版本）
 */
public class ShowAjaxGoodsServlet extends HttpServlet {

    private GoodsTableService goodsTableService;

    @Override
    public void init() throws ServletException {
        goodsTableService = new GoodsTableServiceImpl();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用业务层
        List<GoodsTable> goodsList = goodsTableService.goodsAllSelect();
        //将List转化为json
        String json = JSONArray.toJSONString(goodsList);
        //设置响应的字符集编码
        response.setContentType("text/html;charset=utf-8");
        //以流的方式将结果响应到ajax异步对象
        PrintWriter pw = response.getWriter();
        pw.write(json);
        pw.flush();
        pw.close();
    }
}
