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
    <div style="padding-top: 130px; padding-left: 40%">
        <form action="${pageContext.request.contextPath}/<%=requestUrl%>.do" method="post" enctype="multipart/form-data">
            <table>
                <%
                    if(requestUrl.equals("addBook")) {
                        bookInfo = new Book();
                        bookInfo.setBookName("");
                        bookInfo.setImage("");
                        bookInfo.setAuthor("");
                        bookInfo.setPrice(new BigDecimal(0));
                        bookInfo.setRemarks("");
                    }
                %>
                <tr>
                    <td>图书名称</td>
                    <td><input type="text" name="bookName" value="<%=bookInfo.getBookName()%>"/></td>
                </tr>
                <tr>
                    <td>图书图片</td>
                    <td><input type="file" name="image" value="<%=bookInfo.getImage()%>"/></td>
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
                        <label>
                            <textarea name="remarks" rows="5" cols="20" placeholder="请输入图书描述"><%=bookInfo.getRemarks()%></textarea>
                        </label>
                    </td>
                </tr>
            </table>
            <input style="padding: 8px 16px; margin: 15px 75px; color: #fff; background-color: #ec7259; border-color: #ec7259" type="submit" value="提交">
        </form>
    </div>
</body>
</html>
