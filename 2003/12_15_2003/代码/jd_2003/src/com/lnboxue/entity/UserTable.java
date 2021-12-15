package com.lnboxue.entity;

/**
 * 用户类
 */
public class UserTable {

    //用户编号
    private Integer id;
    //用户名
    private String name;
    //密码
    private String password;

    //无参构造方法
    public UserTable(){}

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
