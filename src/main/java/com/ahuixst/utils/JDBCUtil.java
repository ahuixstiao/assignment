package com.ahuixst.utils;

import com.mysql.cj.protocol.Resultset;
import lombok.SneakyThrows;

import java.math.BigDecimal;
import java.sql.*;

/**
 * @Author: ahui
 * @Description: JDBC 封装类
 * @DateTime: 2022/3/22 - 10:54
 **/
public class JDBCUtil {
    //数据库驱动
    private static final String JDBC_DRIVER = ResourceUtil.getConfigByName("jdbc.driver");
    //数据库连接地址以及数据库名称
    private static final String URL = ResourceUtil.getConfigByName("jdbc.url");
    //数据库账号
    private static final String USER = ResourceUtil.getConfigByName("jdbc.username");
    //数据库密码
    private static final String PASSWORD = ResourceUtil.getConfigByName("jdbc.password");

    //类实例化时获取Statement
    private Statement statement;

    @SneakyThrows
    public JDBCUtil () {
        statement = getConnection();
    }

    //test
    @SneakyThrows
    public static void main(String[] args) {
        /*JDBCUtil jdbc = new JDBCUtil();
        jdbc.operatingMyDataBase("insert into book(book_name,author,price,remarks) values('三只小猪', '安徒生', 10.00, '童话书')");
        ResultSet resultSet = jdbc.selectMyData("select * from book");
        while (resultSet.next()){
            int bookId = resultSet.getInt("book_id");
            String bookName = resultSet.getString("book_name");
            String author = resultSet.getString("author");
            BigDecimal price = resultSet.getBigDecimal("price");
            String remarks = resultSet.getString("remarks");
            System.out.println(bookId+"     "+bookName+"      "+author+"    "+price+"   "+remarks);
        }
        resultSet.close();*/
    }

    /**
     * 返回创建好的Statement对象
     * @return Statement
     * @throws Exception
     */
    @SneakyThrows
    public Statement getConnection() {
        Connection connection = null;
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);  //构建连接
            // 如果要发送不带参数的SQL则使用createStatement
            // 若是语句不变参数不同的话则换成preparedStatement进行动态编译性能会更优
            statement = connection.createStatement();
        }catch (SQLException | ClassNotFoundException sqlException){
            //打印堆栈异常
            sqlException.printStackTrace();
            // 关闭资源
            connection.close();
            statement.close();
        }
        return statement;
    }

    /**
     * 查询
     * @param sql 要执行的SQL语句
     * @return ResultSet对象 返回结果集
     */
    @SneakyThrows
    public ResultSet selectMyData(String sql) {
        //向数据库发送SQL
        return statement.executeQuery(sql);
    }

    /**
     * 修改
     * @param sql 要执行的SQL语句
     * @return int 受影响条数
     */
    @SneakyThrows
    public int updateMyData(String sql) {
        //更新 返回受影响行数
        return statement.executeUpdate(sql);
    }

    /**
     * 执行插入或删除
     * @param sql 要执行的SQL语句
     * @throws SQLException
     */
    @SneakyThrows
    public void operatingMyDataBase(String sql) {
         statement.execute(sql);
    }

}
