package com.lnboxue.utils;

import com.alibaba.fastjson.JSONArray;
import com.lnboxue.entity.GoodsTable;

import java.util.ArrayList;
import java.util.List;

/**
 * fastjson的使用
 */
public class Test {

    public static void main(String[] args) {
        List<GoodsTable> goodsList = new ArrayList<>();
        //向集合中添加元素
        goodsList.add(new GoodsTable(1,"红牛",1,5.5,20,"挺好喝","药品类"));
        goodsList.add(new GoodsTable(2,"阿奇霉素",1,5.5,20,"见效快","药品类"));
        goodsList.add(new GoodsTable(3,"感康",1,5.5,20,"副作用小","药品类"));
        //将集合转化为json格式的字符串
        String json = JSONArray.toJSONString(goodsList);
        System.out.println(json);
    }
}
