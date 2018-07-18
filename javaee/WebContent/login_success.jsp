<%@ page language="java" import="java.util.*" contentType="text/html;charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>登录成功</title>
    <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 
  </head>
  
  <body>
   <center>登录成功.</center> <br>
  <%
   // System.out.println("userid" + session.getAttribute("userid"));
   if(session.getAttribute("userid") != null) // 已经设置过的属性，所有不为空
   {
  %>
    <h3>欢迎 <%= session.getAttribute("userid") %> 光临本站，您的 SessionID 为：<%= session.getId() %> <a href="logout.jsp">注销</a>！</h3>
      <h3> 3秒后跳转至mySpace界面 </h3>
    <% response.setHeader("refresh","3; url = mySpace.jsp"); %>
  <%
   }
   else  // 非法用户，没有登陆通过，则 session 范围内没有属性存在
   {
  %>
    <h3>请您先<a href="login.jsp">登录</a>！</h3>
  <%
   }
  %>
 
  </body>
</html>