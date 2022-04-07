<%@ page import="com.ahuixst.entity.Book" %><%--
  Created by IntelliJ IDEA.
  User: ahui
  Date: 2022/4/6
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看图书信息</title>
</head>
<body>
<% Book bookInfo = (Book) request.getAttribute("bookInfo"); %>
<h1>查看图书信息</h1>
<table border="1" align="center" style="width: 100%;border-collapse: collapse;">
    <tr>
        <th>图书编号</th>
        <th>图书名称</th>
        <th>图书作者</th>
        <th>图书价格</th>
        <th>图书描述</th>
        <th>操作</th>
    </tr>
    <%if(bookInfo != null){%>
    <tr>
        <td><%= bookInfo.getBookId() %></td>
        <td><%= bookInfo.getBookName() %></td>
        <td><%= bookInfo.getAuthor() %></td>
        <td><%= bookInfo.getPrice() %></td>
        <td><%= bookInfo.getRemarks() %></td>
        <td>
            <a href="${pageContext.request.contextPath}/getBookList.do">返回</a>
        </td>
    </tr>
    <%}%>
</table>

</body>
</html>
