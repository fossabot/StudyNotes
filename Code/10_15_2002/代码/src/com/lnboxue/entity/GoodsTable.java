package com.lnboxue.entity;

/**
 * 商品实体类
 */
public class GoodsTable {

    //商品编号
    private Integer id;
    //商品名称
    private String name;
    //类别id
    private Integer gtId;
    //商品价格
    private Double price;
    //商品库存
    private Integer stock;
    //商品备注
    private String remarks;

    public GoodsTable(){}

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
