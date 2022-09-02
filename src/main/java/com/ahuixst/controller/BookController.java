package com.ahuixst.controller;

import com.ahuixst.dao.BookMapper;
import com.ahuixst.entity.Book;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Optional;


@WebServlet(name = "BookController", urlPatterns = "*.do") //Servlet3.0后支持注解配置Servlet程序
public class BookController extends HttpServlet {

    @Autowired
    private BookMapper bookMapper;

    //继承 HttpServlet后可用


    //重写doGet
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String url = req.getRequestURI();
        //获取.do请求的类型
        String methodName = url.substring(url.lastIndexOf("/")+1, url.lastIndexOf("."));
        Method method;
        try {
            //设置字符编码为UTF-8
            req.setCharacterEncoding("UTF-8");
            //根据方法名称来调用
            method = getClass().getDeclaredMethod(methodName , HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, req, resp);
        } catch (Exception e) {
            throw new RuntimeException("方法不存在!");
        }
    }

    //重写doPost
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String url = req.getRequestURI();
        //获取.do请求的类型
        String methodName = url.substring(url.lastIndexOf("/")+1, url.lastIndexOf("."));
        Method method;
        try {
            //设置字符编码为UTF-8
            req.setCharacterEncoding("UTF-8");
            //根据方法名称来调用
            method = getClass().getDeclaredMethod(methodName , HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, req, resp);
        } catch (Exception e) {
            throw new RuntimeException("方法不存在!");
        }
    }

    //书籍列表
    public void getBookList(HttpServletRequest req, HttpServletResponse resp) {
        try {
            //获取总条数
            long i = bookMapper.selectCount(null);
            if(i < 0){
                throw new RuntimeException("暂无数据!");
            }else {
                //将结果设置到request域
                //书籍数量
                req.setAttribute("count", i);
                //书籍列表
                req.setAttribute("bookList", PageHelper.startPage(1,10).doSelectPage(()->{
                    bookMapper.selectList(null);
                }));
            }
            //转发到book.jsp
            req.getRequestDispatcher("/book.jsp").forward(req, resp);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //书籍详情
    public void getBookInfo(HttpServletRequest req, HttpServletResponse resp) {
        try {
            //调用dao层的方法
            //将结果设置到request域中
            Book book = new Book();
            book.setBookId(Integer.valueOf(req.getParameter("bookId")));
            req.setAttribute("bookInfo", bookMapper.selectOne(book).get());
            //转发到bookInfo.jsp
            req.getRequestDispatcher("/WEB-INF/book/bookInfo.jsp").forward(req, resp);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //添加书籍
    public void addBook(HttpServletRequest req, HttpServletResponse resp) {
        try {
            Book book = new Book();
            book.setBookName(req.getParameter("bookName"));
            book.setImage(req.getParameter("image"));
            book.setAuthor(req.getParameter("author"));
            book.setPrice(new BigDecimal(req.getParameter("price")));
            book.setRemarks(req.getParameter("remarks"));
            //调用dao层的方法
            bookMapper.insert(book);
            //转发到bookInfo.jsp
            getBookList(req,resp);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //删除书籍
    public void deleteBook(HttpServletRequest req, HttpServletResponse resp) {
        try {
            //调用dao层的方法
            Book book = new Book();
            book.setBookId(Integer.valueOf(req.getParameter("bookId")));
            bookMapper.delete(book);
            //转发到book.jsp
            getBookList(req,resp);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //修改书籍
    public void updateBook(HttpServletRequest req, HttpServletResponse resp) {
        try {
            Book book = new Book();
            book.setBookId(Integer.valueOf(req.getParameter("bookId")));
            book.setBookName(req.getParameter("bookName"));
            book.setAuthor(req.getParameter("author"));
            book.setPrice(new BigDecimal(req.getParameter("price")));
            book.setRemarks(req.getParameter("remarks"));
            //调用dao层的方法
            bookMapper.updateByPrimaryKey(book);
            //转发到book.jsp
            getBookList(req,resp);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //跳转页面
    public void getFillInPage(HttpServletRequest req, HttpServletResponse resp){
        try {
            //判断是什么请求 做出相应跳转
            String url = req.getParameter("requestMethod");
            if(url.equals("add")){
                req.setAttribute("requestMethod", "addBook");
                req.getRequestDispatcher("/WEB-INF/book/fillInPage.jsp").forward(req, resp);
            }else if(url.equals("update")){

                Optional<Book> book = bookMapper.selectByPrimaryKey(Long.valueOf(req.getParameter("bookId")));
                req.setAttribute("requestMethod", "updateBook");
                req.setAttribute("bookInfo", book.get());
                req.getRequestDispatcher("/WEB-INF/book/fillInPage.jsp").forward(req, resp);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
