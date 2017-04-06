package com.chenyx.service;

import com.chenyx.dto.AppointExecution;
import com.chenyx.entity.Book;

import java.util.List;

/**
 * Created by Administrator on 2017/4/5.
 */
public interface BookService {

    /**
     * 根据书号查书
     * @param bookId
     * @return
     */
    Book getById(long bookId);

    /**
     * 查询所有图书
     * @return
     */
    List<Book> getList();

    /**
     * 预约图书
     * @param bookId
     * @param studentId
     * @return
     */
    AppointExecution appoint(long bookId, long studentId);
}
