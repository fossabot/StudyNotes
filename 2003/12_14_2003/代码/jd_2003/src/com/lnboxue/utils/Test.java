package com.lnboxue.utils;

import com.alibaba.fastjson.JSONArray;
import com.lnboxue.entity.GoodsTable;

import java.util.ArrayList;
import java.util.List;

/**
 * fastjson将List集合转换成json格式的字符串
 */
public class Test {

    public static void main(String[] args) {
        List<GoodsTable> goodsList = new ArrayList<>();
        goodsList.add(new GoodsTable(1,"红牛",1,76.5,50,"挺好喝","药品"));
        goodsList.add(new GoodsTable(2,"红霉素",1,76.5,50,"见效快","药品"));
        goodsList.add(new GoodsTable(3,"瓷砖",1,76.5,50,"质量好","商品"));
        //将List转json
        String json = JSONArray.toJSONString(goodsList);
        System.out.println(json);
    }
}
