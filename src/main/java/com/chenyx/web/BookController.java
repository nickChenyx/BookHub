package com.chenyx.web;

import com.chenyx.dto.AppointExecution;
import com.chenyx.dto.Result;
import com.chenyx.entity.Book;
import com.chenyx.enums.AppointStateEnum;
import com.chenyx.exception.NoNumberException;
import com.chenyx.exception.RepeatAppointException;
import com.chenyx.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2017/4/5.
 */

@Controller
@RequestMapping("/book")
public class BookController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookService bookService;


    @RequestMapping(value = "/list",method = RequestMethod.GET)
    private String list(Model model){
        List<Book> list = bookService.getList();
        model.addAttribute("list",list);
        return "book_list";
    }

    @RequestMapping(value = "/{bookId}/detail",method = RequestMethod.GET)
    private String detail(@PathVariable("bookId") Long bookId, Model model){
        if (bookId == null)
            return "redirect:/book/list";
        Book book  = bookService.getById(bookId);
        if (book == null )
            return "forward:/book/list";
        model.addAttribute("book",book);
        return "book_detail";
    }

    @RequestMapping(value = "/{bookId}/appoint",method = RequestMethod.GET,
                    produces = {"application/json;charset=utf-8"})
    @ResponseBody
    private Result<AppointExecution> appoint(@PathVariable("bookId") Long bookId,
                                             @RequestParam("studentId") Long studentId){
        if (studentId == null || studentId.equals("")) {
            return new Result<AppointExecution>(false, "学号不能为空");
        }
        //AppointExecution execution = bookService.appoint(bookId, studentId);//错误写法，不能统一返回，要处理异常（失败）情况
        AppointExecution execution = null;
        try {
            execution = bookService.appoint(bookId, studentId);
        } catch (NoNumberException e1) {
            execution = new AppointExecution(bookId, AppointStateEnum.NO_NUMBER);
        } catch (RepeatAppointException e2) {
            execution = new AppointExecution(bookId, AppointStateEnum.REPEAT_APPOINT);
        } catch (Exception e) {
            execution = new AppointExecution(bookId, AppointStateEnum.INNER_ERROR);
        }
        return new Result<AppointExecution>(true, execution);
    }
}
