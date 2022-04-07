package com.ahuixst.dao;

import cn.hutool.core.util.StrUtil;
import com.ahuixst.entity.Book;
import com.ahuixst.utils.JDBCUtil;
import lombok.SneakyThrows;

import javax.jws.WebService;
import javax.servlet.annotation.WebServlet;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: ahui
 * @Description: BooDao
 * @DateTime: 2022/3/28 - 12:59
 **/
public class BookDao {

    private static JDBCUtil jdbcUtil = new JDBCUtil();
    private ResultSet resultSet;

    /**
     * 返回查询集合
     * @return List<Book>
     * @throws Exception
     */
    @SneakyThrows
    public List<Book> selectBookList() {
        List<Book> result = new LinkedList<>();
        try {
            resultSet = jdbcUtil.selectMyData("select * from book");
            while (resultSet.next()){
                Book book = new Book();
                book.setBookId(resultSet.getInt("book_id"));
                book.setBookName(resultSet.getString("book_name"));
                book.setAuthor(resultSet.getString("author"));
                book.setPrice(resultSet.getBigDecimal("price"));
                book.setRemarks(resultSet.getString("remarks"));
                result.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultSet.close();
        }
        return result;
    }

    /**
     * 查询单条记录
     * @param bookId 图书ID
     * @return Book
     * @throws Exception
     */
    @SneakyThrows
    public Book selectBookInfo(Integer bookId) {
        Book book = new Book();
        try {
            resultSet = jdbcUtil.selectMyData("select * from book where book_id=" + bookId);
            while (resultSet.next()){
                book.setBookId(resultSet.getInt("book_id"));
                book.setBookName(resultSet.getString("book_name"));
                book.setAuthor(resultSet.getString("author"));
                book.setPrice(resultSet.getBigDecimal("price"));
                book.setRemarks(resultSet.getString("remarks"));
            }
        }catch (Exception e){
            e.printStackTrace();
            resultSet.close();
        }
        return book;
    }

    /**
     * 插入图书信息
     * @param book book对象
     */
    public void insertBookInfo(Book book) {
        String sql = StrUtil.format("insert into book(book_name,author,price,remarks) values('{}','{}',{},'{}')",book.getBookName(),book.getAuthor(),book.getPrice(),book.getRemarks());
        jdbcUtil.operatingMyDataBase(sql);
    }

    /**
     * 修改图书信息
     * @param book book对象
     * @return int
     */
    public int updateBookInfo(Book book) {
        String sql = StrUtil.format("update book set book_name='{}',author='{}',price={},remarks='{}' where book_id={}", book.getBookName(), book.getAuthor(), book.getPrice(), book.getRemarks(), book.getBookId());
        return jdbcUtil.updateMyData(sql);
    }

    /**
     * 删除图书信息
     * @param bookId 图书ID
     */
    public void deleteBookInfo(Integer bookId) {
        String sql = StrUtil.format("delete from book where book_id={}", bookId);
        jdbcUtil.operatingMyDataBase(sql);
    }

}
