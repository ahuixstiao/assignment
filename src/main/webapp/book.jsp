<%@ page import="java.util.List" %>
<%@ page import="com.ahuixst.entity.Book" %>
<%--
  Created by IntelliJ IDEA.
  User: ahui
  Date: 2022/4/6
  Time: 18:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书列表</title>
</head>
<body>
    <%
        List<Book> bookList = (List<Book>) request.getAttribute("bookList");
    %>
    <h1 style="padding-left: 45%">图书列表</h1>
    <a href="${pageContext.request.contextPath}/getFillInPage.do?requestMethod=add">添加</a>
    <a href="${pageContext.request.contextPath}/getBookList.do">刷新</a>
    <form id="form" action="${pageContext.request.contextPath}/getBookList.do"></form>
    <table border="1" align="center" style="width: 100%;border-collapse: collapse;">
        <tr>
            <th>图书编号</th>
            <th>图书名称</th>
            <th>图书作者</th>
            <th>图书价格</th>
            <th>图书描述</th>
            <th>操作</th>
        </tr>
        <%
            if(bookList != null && bookList.size() >0){
                for (Book book : bookList) {
        %>
        <tr>
            <td><%= book.getBookId() %></td>
            <td><%= book.getBookName() %></td>
            <td><%= book.getAuthor() %></td>
            <td><%= book.getPrice() %></td>
            <td><%= book.getRemarks() %></td>
            <td>
                <a href="<%= request.getContextPath() %>/getBookInfo.do?bookId=<%= book.getBookId() %>">查看</a>
                <a href="<%= request.getContextPath() %>/getFillInPage.do?requestMethod=update&bookId=<%= book.getBookId() %>">修改</a>
                <a href="<%= request.getContextPath() %>/deleteBook.do?bookId=<%= book.getBookId() %>">删除</a>
            </td>
        </tr>
        <% }} %>
    </table>
</body>
</html>
