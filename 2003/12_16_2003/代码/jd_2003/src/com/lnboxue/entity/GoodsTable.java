package com.lnboxue.entity;

/**
 * 商品表
 */
public class GoodsTable {

    //商品编号
    private Integer id;
    //商品名称
    private String name;
    //商品类别编号
    private Integer gtId;
    //商品价格
    private Double price;
    //商品库存
    private Integer stock;
    //商品备注
    private String remarks;

    //商品类别名称
    private String gtName;

    //无参构造方法
    public GoodsTable(){}

    public GoodsTable(Integer id, String name, Integer gtId, Double price, Integer stock, String remarks, String gtName) {
        this.id = id;
        this.name = name;
        this.gtId = gtId;
        this.price = price;
        this.stock = stock;
        this.remarks = remarks;
        this.gtName = gtName;
    }

    public String getGtName() {
        return gtName;
    }

    public void setGtName(String gtName) {
        this.gtName = gtName;
    }

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

    public Integer getGtId() {
        return gtId;
    }

    public void setGtId(Integer gtId) {
        this.gtId = gtId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
