<%--
  Created by IntelliJ IDEA.
  User: ahui
  Date: 2022/3/28
  Time: 08:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<div style="padding-left: 36%; padding-top: 10%;">
    <form action="http://localhost:8080/shopping/hello" method="post">
        用户名：<input id="name" name="name" type="text"> <span>必填</span>
        <br/><br/>
        密码: <input id="password" name="password" type="password" style="margin-left: 2.5%"> <span>必填</span>
        <br/><br/>
        确认密码: <input id="confirmPassword" name="confirmPassword" type="password">
        <br/><br/>
        性别： <input id="man" type="radio" checked="checked" name="sex" value="1">男 <input id="woman" type="radio" name="sex" value="0">女
        <br/><br/>
        爱好： 计算机<input id="computer" name="hobby" checked="checked" type="checkbox" value="computer"> 音乐<input id="music" name="hobby" type="checkbox" value="music"> 体育<input id="sports" name="hobby" type="checkbox" value="sports"> 文学<input id="literature" name="hobby" type="checkbox" value="literature">
        <br/><br/>
        星座：
        <select name="constellation">
            <option value="白羊座">白羊座</option>
            <option value="金牛座">金牛座</option>
            <option value="双子座">双子座</option>
            <option value="巨蟹座">巨蟹座</option>
            <option value="狮子座">狮子座</option>
            <option value="处女座">处女座</option>
            <option value="天秤座">天秤座</option>
            <option value="天蝎座">天蝎座</option>
            <option value="射手座">射手座</option>
            <option value="摩羯座">摩羯座</option>
            <option value="水瓶座">水瓶座</option>
            <option value="双鱼座">双鱼座</option>
        </select>
        <br/><br/>
        个人简介:
        <textarea id="personalProfile" name="personalProfile" rows="5" cols="20" placeholder="请输入个人简介"></textarea>
        <br/><br/>
        <input id="confirmButton" type="submit" value="确认" style="margin-left: 10%;"> <input id="cancelButton" type="reset" value="取消" style="margin-left: 15%;">
    </form>
</div>
</body>
</html>
