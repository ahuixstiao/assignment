<%@ page import="com.ahuixst.entity.Book" %>
<%@ page import="java.math.BigDecimal" %><%--
  Created by IntelliJ IDEA.
  User: ahui
  Date: 2022/4/6
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<%
    String requestUrl = (String) request.getAttribute("requestMethod");
    Book bookInfo = (Book) request.getAttribute("bookInfo");
%>
<body>
    <form style="padding-left: 42%" action="${pageContext.request.contextPath}/<%=requestUrl%>.do" method="post">
        <table>
            <%
                if(requestUrl.equals("addBook")) {
                    bookInfo = new Book();
                    bookInfo.setBookName("");
                    bookInfo.setAuthor("");
                    bookInfo.setPrice(new BigDecimal(0));
                    bookInfo.setRemarks("");
                }else if(requestUrl.equals("updateBook")) {%>
                    <tr>
                        <td>图书编号</td>
                        <td><input type="text" name="bookId" value="<%=bookInfo.getBookId()%>"/></td>
                    </tr>
            <%}%>
            <tr>
                <td>图书名称</td>
                <td><input type="text" name="bookName" value="<%=bookInfo.getBookName()%>"/></td>
            </tr>
            <tr>
                <td>图书作者</td>
                <td><input type="text" name="author" value="<%=bookInfo.getAuthor()%>"/></td>
            </tr>
            <tr>
                <td>图书价格</td>
                <td><input type="text" name="price" value="<%=bookInfo.getPrice()%>"/></td>
            </tr>
            <tr>
                <td>图书描述</td>
                <td>
                    <textarea name="remarks" rows="5" cols="20" placeholder="请输入图书描述"><%=bookInfo.getRemarks()%></textarea>
                </td>
            </tr>
        </table>
        <input style="margin:3% 10%" type="submit" value="提交">
    </form>
</body>
</html>
