package com.lnboxue.action;

import com.alibaba.fastjson.JSONArray;
import com.lnboxue.service.goods.GoodsTableService;
import com.lnboxue.service.goods.impl.GoodsTableServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 判断商品名称是否重复功能控制层
 */
public class NameCheckAjaxServlet extends HttpServlet {

    private GoodsTableService goodsTableService;

    @Override
    public void init() throws ServletException {
        goodsTableService = new GoodsTableServiceImpl();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取商品名称
        String name = request.getParameter("name");
        //获取商品名称是否存在
        boolean isExist = goodsTableService.nameCheck(name);
        //实例化Map集合
        Map<String,Object> map = new LinkedHashMap<>();
        //向Map集合中添加元素
        map.put("result",isExist);
        //将该集合转换为json格式的字符串
        String json = JSONArray.toJSONString(map);
        response.setContentType("html/text;charset=utf-8");
        //将服务器端的响应数据返回给客户端
        response.getWriter().write(json);
        response.getWriter().flush();
        response.getWriter().close();
    }
}
