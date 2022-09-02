package com.ahuixst.dao;

import com.ahuixst.entity.Book;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: ahui
 * @Description: TODO
 * @DateTime: 2022/8/29 - 13:41
 **/
@Mapper //将接口交由Mybatis为其生成代理实现类 这也是为什么明明没有去实现接口也能直接调用方法执行
public interface BookMapper extends io.mybatis.mapper.Mapper<Book, Long> {

    /**
     * 书籍列表
     * @return List<Book>
     */
    //@Select("select * from book")
    //List<Book> findList();

    /**
     * 查询单条数据信息
     * @param bookId
     * @return book
     */
    //@Select("select * from book where book_id = #{bookId}")
    //Book queryBookInfo(Integer bookId);

    /**
     * 总条数
     * @return int
     */
    //@Select("select count(book_id) from book")
    //int queryCount();

    /**
     * 插入
     * @param book
     */
    //@Insert("insert into book(book_name,image,author,price,remarks) values (#{bookName}, #{image}, #{author}, #{price}, #{remarks})")
    //void insertBookInfo(Book book);

    /**
     * 删除
     * @param bookId
     */
    //@Delete("delete from book where book_id = #{bookId}")
    //void deleteBookInfo(Integer bookId);

    /**
     * 修改
     * @param book
     */
    //@Update("update book set book_name = #{bookName}, image = #{image}, author = #{author}, price = #{price}, remarks = #{remarks} where book_id = #{bookId} ")
    //void updateBookInfo(Book book);


}
