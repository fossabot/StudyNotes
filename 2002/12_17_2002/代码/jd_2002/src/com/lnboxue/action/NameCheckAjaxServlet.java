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
 * 商品名称判重控制层（AJAX版本）
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
        //判断商品名称是否存在
        boolean isExist = goodsTableService.nameCheck(name);
        //实例化Map集合对象
        Map<String,Object> map = new LinkedHashMap<>();
        //封装Map集合
        map.put("result",isExist);
        //将响应数据转化为json格式
        String json = JSONArray.toJSONString(map);
        //设置响应的字符集
        response.setContentType("text/html;charset=utf-8");
        //将响应数据发送给客户端
        response.getWriter().write(json);
        response.getWriter().flush();
        response.getWriter().close();
    }
}
