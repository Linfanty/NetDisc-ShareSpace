<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="demo.sharespace.bean.FileBean" %>
<%@ page import="demo.sharespace.dao.MySpaceDao" %>  
<%@ page import="demo.sharespace.util.RequestUtils" %>    
<%@ page import="java.util.List" %>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 修改描述</title>
</head>
<body>
<% String fileId = (String)request.getParameter("fileId"); // 得到request中存储的 fileId 用户对象信息 %>
<% request.setCharacterEncoding("UTF-8"); %>
<form action = "/ShareSpace/ChangeGroupFileDescServlet"  method="post"> 
<center>
  	<h1>请输入您的修改描述: </h1> <br>
  	<input type="text" name="filedesc">
  	<input type="hidden" name="fileId" value=<%=fileId%> >
	<input type="submit" value="提交" >
	<% System.out.println(fileId); %>
<!--<% out.println(" <a href = \"/ShareSpace/ChangeDescServlet?fileId=" + fileId + "\"> 确认修改 </a> "); %> -->
</center>
</form>
</body>
</html>