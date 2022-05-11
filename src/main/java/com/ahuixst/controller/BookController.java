package com.ahuixst.controller;

import com.ahuixst.service.BookService;
import com.ahuixst.entity.Book;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.math.BigDecimal;

/**
 * @Author: ahui
 * @Description: Book控制类
 * @DateTime: 2022/4/6 - 18:10
 **/
@WebServlet(name = "BookController", urlPatterns = "*.do") //Servlet3.0后支持注解配置Servlet程序
public class BookController extends HttpServlet {

    private BookService bookService = new BookService();

    //重写doGet方法
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String url = req.getRequestURI();
        //获取.do请求的类型
        String methodName = url.substring(url.lastIndexOf("/")+1, url.lastIndexOf("."));
        Method method;
        try {
            //根据方法名称来调用
            method = getClass().getDeclaredMethod(methodName , HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, req, resp);
        } catch (Exception e) {
            throw new RuntimeException("方法不存在!");
        }
    }

    //重写doPost方法
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String url = req.getRequestURI();
        //获取.do请求的类型
        String methodName = url.substring(url.lastIndexOf("/")+1, url.lastIndexOf("."));
        Method method;
        try {
            //根据方法名称来调用
            method = getClass().getDeclaredMethod(methodName , HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, req, resp);
        } catch (Exception e) {
            throw new RuntimeException("方法不存在!");
        }
    }

    //获取书籍列表
    public void getBookList(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setCharacterEncoding("UTF-8");
            //获取总条数
            int i = bookService.queryCount();
            //当前页
            req.getParameter("currentPage");
            //显示条数
            req.getParameter("pageSize");
            if(i < 0){
                throw new RuntimeException("暂无数据!");
            }else {
                //将结果设置到request域中
                req.setAttribute("bookList", bookService.selectBookList());
            }
            //转发到book.jsp
            req.getRequestDispatcher("/book.jsp").forward(req, resp);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //获取书籍信息
    public void getBookInfo(HttpServletRequest req, HttpServletResponse resp) {
        try {
            //调用dao层的方法
            //将结果设置到request域中
            req.setAttribute("bookInfo", bookService.selectBookInfo(Integer.valueOf(req.getParameter("bookId"))));
            //转发到bookInfo.jsp
            req.getRequestDispatcher("/WEB-INF/book/bookInfo.jsp").forward(req, resp);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //添加书籍信息
    public void addBook(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setCharacterEncoding("UTF-8");
            Book book = new Book();
            book.setBookName(req.getParameter("bookName"));
            book.setAuthor(req.getParameter("author"));
            book.setPrice(new BigDecimal(req.getParameter("price")));
            book.setRemarks(req.getParameter("remarks"));
            //调用dao层的方法
            bookService.insertBookInfo(book);
            //转发到bookInfo.jsp
            getBookList(req,resp);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //删除书籍信息
    public void deleteBook(HttpServletRequest req, HttpServletResponse resp) {
        try {
            //调用dao层的方法
            bookService.deleteBookInfo(Integer.valueOf(req.getParameter("bookId")));
            //转发到book.jsp
            getBookList(req,resp);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //修改书籍信息
    public void updateBook(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setCharacterEncoding("UTF-8");
            Book book = new Book();
            book.setBookId(Integer.valueOf(req.getParameter("bookId")));
            book.setBookName(req.getParameter("bookName"));
            book.setAuthor(req.getParameter("author"));
            book.setPrice(new BigDecimal(req.getParameter("price")));
            book.setRemarks(req.getParameter("remarks"));
            //调用dao层的方法
            bookService.updateBookInfo(book);
            //转发到book.jsp
            getBookList(req,resp);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //跳转页面
    public void getFillInPage(HttpServletRequest req, HttpServletResponse resp){
        try {
            //判断是什么请求
            String url = req.getParameter("requestMethod");
            if(url.equals("add")){
                req.setAttribute("requestMethod", "addBook");
                req.getRequestDispatcher("/WEB-INF/book/fillInPage.jsp").forward(req, resp);
            }else if(url.equals("update")){
                Book book = bookService.selectBookInfo(Integer.valueOf(req.getParameter("bookId")));
                req.setAttribute("requestMethod", "updateBook");
                req.setAttribute("bookInfo", book);
                req.getRequestDispatcher("/WEB-INF/book/fillInPage.jsp").forward(req, resp);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
