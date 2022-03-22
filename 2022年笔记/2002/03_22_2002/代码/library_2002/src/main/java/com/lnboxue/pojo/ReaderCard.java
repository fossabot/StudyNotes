package com.lnboxue.pojo;

import java.io.Serializable;

/**
 * 借阅卡类
 */
public class ReaderCard implements Serializable {

    //读者编号
    private Long readerId;
    //读者用户名
    private String username;
    //读者密码
    private String password;

    //无参数构造方法
    public ReaderCard(){}

    public Long getReaderId() {
        return readerId;
    }

    public void setReaderId(Long readerId) {
        this.readerId = readerId;
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
}
