<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>

<body>
<center>
<h1>登录</h1>
<form action="/ShareSpace/LoginServlet" method="post">
账号: <input type="text" name="username">
<br/>
密码: <input type="password" name="password">
<br/>

<input type="submit" value="提交">
<input type="reset" value="重置">

<p>没有账号，<a href="/ShareSpace/register.jsp">注册一个新账号</a></p>




<%
if("-1".equals(session.getAttribute("login_flag"))){
%>
<p>用户名或密码错误！</p>
<%
}
%>
</form>
</center>
</body>
</html>