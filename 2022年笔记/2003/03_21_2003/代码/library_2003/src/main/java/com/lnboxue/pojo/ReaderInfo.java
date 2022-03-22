package com.lnboxue.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 读者信息类
 */
public class ReaderInfo implements Serializable {

    //读者编号
    private Long readerId;
    //读者姓名
    private String name;
    //读者性别
    private String sex;
    //读者出生日期
    private Date birth;
    //读者家庭住址
    private String address;
    //读者电话号
    private String phone;

    public ReaderInfo(){}

    public Long getReaderId() {
        return readerId;
    }

    public void setReaderId(Long readerId) {
        this.readerId = readerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
