package com.chenyx.dao;

import com.chenyx.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/4/5.
 */
public interface BookDao {
    /**
     * 通过书本号查询
     * @param id
     * @return
     */
    Book queryById(long id);

    /**
     * 查询所有的图书
     * @param offset 起始位置
     * @param limit 查询条数
     * @return
     */
    List<Book> queryAll(@Param("offset")int offset,@Param("limit")int limit);

    /**
     * 减少书号的馆藏数
     * @param bookId
     * @return 如果影响行数大于 1，表示更新的记录行数
     */
    int reduceNumber(long bookId);
}
