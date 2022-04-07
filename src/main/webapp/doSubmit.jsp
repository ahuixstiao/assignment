<%@ page import="com.ahuixst.entity.UserName" %>
<%@ page isELIgnored="false"%>
<%--
  Created by IntelliJ IDEA.
  User: ahui
  Date: 2022/3/28
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>展示数据</title>
</head>
<body>
    <% UserName userName = (UserName) request.getAttribute("userName");%>
    <div style="padding: 15% 40%">
        <p>您的姓名是：<%=userName.getName()%></p>
        <p>您的密码是：<%=userName.getPassword()%></p>
        <p>您的性别是：<%=userName.getSex()==1? "男": "女"%></p>
        <%
            String[] hobby = userName.getHobby();
            StringBuffer value = new StringBuffer();
            for (int i =0; i<hobby.length; i++) {
                value.append(" "+hobby[i]);
            }
        %>
        <p>您的爱好是：<%=value%></p>
        <p>您的星座是：<%=userName.getConstellation()%></p>
        <p>您的个人简介是：<%=userName.getPersonalProfile()%></p>
    </div>
</body>
</html>
