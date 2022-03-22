package com.ahuixst.utils;

import java.sql.*;

/**
 * @Author: ahui
 * @Description: JDBC 封装类
 * @DateTime: 2022/3/22 - 10:54
 **/
public class JDBCUtil {
    //数据库驱动
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    //数据库连接地址以及数据库名称
    private static final String URL = "jdbc:mysql://localhost:3306/demo";
    //数据库账号
    private static final String USER = "root";
    //数据库密码
    private static final String PASSWORD = "ahui0503";
    //类实例化时获取Statement
    private Statement statement = getConnection();

    public JDBCUtil () throws SQLException {

    }

    //test
    public static void main(String[] args) throws Exception {
        JDBCUtil jdbc = new JDBCUtil();
        ResultSet resultSet = jdbc.selectMyData("select * from myarea");
        while (resultSet.next()){
            int aid = resultSet.getInt("aid");
            String aname = resultSet.getString("aname");
            System.out.println(aid+"   "+aname);
        }
    }

    /**
     * 返回创建好的Statement对象
     * @return Statement
     * @throws Exception
     */
    public Statement getConnection() throws SQLException {
        Connection connection = null;
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("连接数据库...");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("实例statement对象...");
            statement = connection.createStatement();
        }catch (ClassNotFoundException | SQLException exception){
            //打印堆栈异常
            exception.printStackTrace();
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
     * @throws Exception
     */
    public ResultSet selectMyData(String sql) throws Exception{
        //向数据库发送SQL
        return statement.executeQuery(sql);
    }

    /**
     * 修改
     * @param sql 要执行的SQL语句
     * @return int 受影响条数
     * @throws SQLException
     */
    public int updateMyData(String sql) throws SQLException{
        //更新 返回受影响行数
        return statement.executeUpdate(sql);
    }

    /**
     * 执行创建或删除
     * @param sql 要执行的SQL语句
     * @param sqlType 类型
     * @return boolean类型 是否成功
     * @throws SQLException
     */
    public boolean operatingMyDataBase(String sql, String sqlType) throws SQLException {
        boolean executeResult = false;
        switch (sqlType){
            case "create" :
                executeResult = statement.execute(sql);
                break;
            case "delete" :
                executeResult = statement.execute(sql);
                break;
        }
        return executeResult;
    }

}
