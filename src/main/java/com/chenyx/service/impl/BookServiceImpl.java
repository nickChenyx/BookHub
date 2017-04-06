package com.chenyx.service.impl;

import com.chenyx.dto.AppointExecution;
import com.chenyx.entity.Appointment;
import com.chenyx.entity.Book;
import com.chenyx.enums.AppointStateEnum;
import com.chenyx.exception.AppointException;
import com.chenyx.exception.NoNumberException;
import com.chenyx.exception.RepeatAppointException;
import com.chenyx.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chenyx.dao.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/4/5.
 */

@Service
public class BookServiceImpl implements BookService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookDao bookDao;

    @Autowired
    private AppointmentDao appointmentDao;

    public Book getById(long bookId) {
        return bookDao.queryById(bookId);
    }

    public List<Book> getList() {
        return bookDao.queryAll(0, 1000);
    }

    @Transactional
    public AppointExecution appoint(long bookId, long studentId) {
        try{
            int update = bookDao.reduceNumber(bookId);
            if (update<=0){//库存不足
                throw new NoNumberException("no number");
            }else {
                int insert = appointmentDao.insertAppointment(bookId,studentId);
                if(insert<=0){//重复预约
                    throw new RepeatAppointException("repeat appoint");
                }else {
                    Appointment appointment = appointmentDao.queryByKeyWithBook(bookId,studentId);
                    return new AppointExecution(bookId, AppointStateEnum.SUCCESS,appointment);
                }
            }
        }catch (NoNumberException e){
            throw e;
        }catch (RepeatAppointException e){
            throw e;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            throw new AppointException("appoint inner error:"+e.getMessage());
        }
    }
}