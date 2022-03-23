package com.lnboxue.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 借阅信息类
 */
public class Lend implements Serializable {

    //借阅序列号
    private Long serNum;
    //图书编号
    private Long bookId;
    //读者编号
    private Long readerId;
    //借阅日期
    private Date lendDate;
    //归还日期
    private Date backDate;

    //无参构造方法
    public Lend(){}

    public Long getSerNum() {
        return serNum;
    }

    public void setSerNum(Long serNum) {
        this.serNum = serNum;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getReaderId() {
        return readerId;
    }

    public void setReaderId(Long readerId) {
        this.readerId = readerId;
    }

    public Date getLendDate() {
        return lendDate;
    }

    public void setLendDate(Date lendDate) {
        this.lendDate = lendDate;
    }

    public Date getBackDate() {
        return backDate;
    }

    public void setBackDate(Date backDate) {
        this.backDate = backDate;
    }
}
