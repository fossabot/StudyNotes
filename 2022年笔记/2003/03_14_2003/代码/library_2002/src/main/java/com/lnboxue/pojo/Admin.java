package com.lnboxue.pojo;

import java.io.Serializable;

/**
 * 管理员类
 */
public class Admin implements Serializable {

    //管理员编号
    private Long adminId;
    //管理员密码
    private String password;
    //管理员用户名
    private String username;

    //无参构造方法
    public Admin(){}

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
