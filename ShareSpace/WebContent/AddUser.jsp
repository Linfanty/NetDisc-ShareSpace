<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="demo.sharespace.bean.FileBean" %>
<%@ page import="demo.sharespace.dao.SearchGroupUser" %>  
<%@ page import="demo.sharespace.dao.Search_Space" %>  
<%@ page import="demo.sharespace.util.RequestUtils" %>    
<%@ page import="java.util.List" %>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> search-user </title>
</head>
<body>
<center>

<%
SearchGroupUser space = new SearchGroupUser();
System.out.println("AddUSer中的username2为：" + session.getAttribute("username2"));
List<FileBean> fileList = space.getMyFileList((String)session.getAttribute("username2")); ///
%>
<h1> 输入用户ID </h1>
<form action = "/ShareSpace/Search_User2" method="post">
<input type="text" name="username2">
<input type="submit" value="search">
<input type="hidden" value="<%=session.getAttribute("groupid")%>" name = "GroupId" >


<br>	<br>
<table border="1">
<tr><th>用户名</th><th>操作</th><tr>
<%
for(FileBean file : fileList){
%>
<tr>
<td><%=file.getUserName() %></td>
<% out.println("<td><a href = \"/ShareSpace/AddUser2?GroupId=" + session.getAttribute("groupid") + "\"> 添加  </a></td>");%>
</tr>

<%
}
%>

  
</table>
</form>
 	<br>
  <a href="/ShareSpace/Group.jsp">返回您加入的群组页</a>
</center>
</body>
</html>