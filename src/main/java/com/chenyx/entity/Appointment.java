package com.chenyx.entity;

import java.util.Date;

/**
 * Created by Administrator on 2017/4/5.
 */
public class Appointment {
    // 书号
    private long bookId;
    // 学号
    private String studentId;
    // 预约时间
    private Date appointTime;
    // 图书实体
    // 多对一的复合属性
    private Book book;

    @Override
    public String toString() {
        return "{ bookid: "+bookId+" , studentId: "+studentId+" , appointTime: "+ appointTime +" , "+book+" }";
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Date getAppointTime() {
        return appointTime;
    }

    public void setAppointTime(Date appointTime) {
        this.appointTime = appointTime;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
