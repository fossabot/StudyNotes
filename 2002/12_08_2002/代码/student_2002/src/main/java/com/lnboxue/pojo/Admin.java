package com.lnboxue.pojo;

import java.io.Serializable;

/**
 * 管理员类
 */
public class Admin implements Serializable {

    //管理员编号
    private Integer id;
    //管理员用户名
    private String username;
    //管理员密码
    private String password;
    //管理员姓名
    private String name;

    //无参构造方法
    public Admin(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
