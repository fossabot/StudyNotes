package com.lnboxue.entity;

/**
 * 商品类别
 */
public class GoodsType {

    //类别编号
    private Integer id;
    //商品类别名称
    private String name;

    //无参构造方法
    public GoodsType(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
