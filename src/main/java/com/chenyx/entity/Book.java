package com.chenyx.entity;

/**
 * Created by Administrator on 2017/4/5.
 */
public class Book {
    // 书号
    private long bookId;
    // 书名
    private String name;
    // 存量
    private int number;

    @Override
    public String toString() {
        return "[ bookId: "+bookId+" , name: "+name+" , number: "+number+" ]";
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
