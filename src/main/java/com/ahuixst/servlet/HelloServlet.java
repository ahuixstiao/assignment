package com.ahuixst.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @Author: ahui
 * @Description: servlet程序 指的是实现了servlet功能的继承类或实现类
 * @DateTime: 2022/3/4 - 22:40
 **/
public class HelloServlet extends HttpServlet {

    /**
     * servlet被实例化后会先调用构造器-》init方法-》service方法-》web工程停止时调用destroy方法
     * 由于HttpServlet类在内部重载的service方法已经帮我们做了请求类型的处理，所以只需要重写请求类型对应的方法即可
     */


    /**
     * get请求
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getMethod());
        // 获取批量传递过来的参数 并以Map集合的方式存储
        Map<String, String[]> parameterMap = req.getParameterMap();
        // 遍历键取出值
        for (String key : parameterMap.keySet()) {
            String[] values = parameterMap.get(key);
            for (String value : values) {
                System.out.println(key+": "+value);
            }
        }
    }

    /**
     * post请求
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
