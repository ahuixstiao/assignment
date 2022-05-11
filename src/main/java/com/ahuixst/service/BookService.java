package com.ahuixst.service;

import cn.hutool.core.util.StrUtil;
import com.ahuixst.entity.Book;
import com.ahuixst.utils.JDBCUtil;
import lombok.SneakyThrows;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: ahui
 * @Description: BooDao
 * @DateTime: 2022/3/28 - 12:59
 **/
public class BookService {

    private static final JDBCUtil JDBCUTIL = new JDBCUtil();
    private ResultSet resultSet;

    /**
     * 返回记录数
     * @return int
     */
    @SneakyThrows
    public int queryCount(){
        String sql = StrUtil.format("select count(*) count from book");
        resultSet = JDBCUTIL.selectMyData(sql);
        int result = 0;
        while (resultSet.next()){
             result = resultSet.getInt("count");
        }
        return result;
    }

    /**
     * 返回查询集合
     * @return List<Book>
     * @throws Exception
     */
    @SneakyThrows
    public List<Book> selectBookList() {
        List<Book> bookList = new LinkedList<>();
        try {
            resultSet = JDBCUTIL.selectMyData("select * from book");
            while (resultSet.next()){
                Book book = new Book();
                book.setBookId(resultSet.getInt("book_id"));
                book.setBookName(resultSet.getString("book_name"));
                book.setAuthor(resultSet.getString("author"));
                book.setPrice(resultSet.getBigDecimal("price"));
                book.setRemarks(resultSet.getString("remarks"));
                bookList.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultSet.close();
        }
        return bookList;
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
            resultSet = JDBCUTIL.selectMyData("select * from book where book_id=" + bookId);
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
        JDBCUTIL.operatingMyDataBase(sql);
    }

    /**
     * 修改图书信息
     * @param book book对象
     * @return int
     */
    public int updateBookInfo(Book book) {
        String sql = StrUtil.format("update book set book_name='{}',author='{}',price={},remarks='{}' where book_id={}", book.getBookName(), book.getAuthor(), book.getPrice(), book.getRemarks(), book.getBookId());
        return JDBCUTIL.updateMyData(sql);
    }

    /**
     * 删除图书信息
     * @param bookId 图书ID
     */
    public void deleteBookInfo(Integer bookId) {
        String sql = StrUtil.format("delete from book where book_id={}", bookId);
        JDBCUTIL.operatingMyDataBase(sql);
    }

}
