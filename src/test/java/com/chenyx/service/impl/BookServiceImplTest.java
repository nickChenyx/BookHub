package com.chenyx.service.impl;

import com.chenyx.BaseTest;
import com.chenyx.dto.AppointExecution;
import com.chenyx.service.BookService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2017/4/5.
 */
public class BookServiceImplTest extends BaseTest {
    @Autowired
    private BookService bookService;

    @Test
    public void testAppoint() throws Exception{
        long bookId = 1001;
        long studentId = 123456789L;
        AppointExecution execution = bookService.appoint(bookId,studentId);
        System.out.println(execution);
    }
}
