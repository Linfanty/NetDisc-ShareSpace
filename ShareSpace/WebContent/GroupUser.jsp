<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="demo.sharespace.bean.FileBean" %>
<%@ page import="demo.sharespace.dao.MyGroupUserDao" %>  
<%@ page import="demo.sharespace.dao.MyGroupDao" %>  
<%@ page import="demo.sharespace.dao.Group" %>  
<%@ page import="demo.sharespace.util.RequestUtils" %>    
<%@ page import="java.util.List" %>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 您群组的成员 </title>
</head>

<body>
<center>
<% String GroupId = (String)request.getParameter("GroupId"); // 得到? =后的信息   %>
<% System.out.println( GroupId ); %>

<%
MyGroupUserDao space = new MyGroupUserDao();
/// System.out.println(RequestUtils.getGroupId(request) );  /// == null ???
List<FileBean> UserList = space.getMyFileList((String)session.getAttribute("groupid"));
%>

<form action="/ShareSpace/MyGroupUserList" method="post"></form>
<h2> 您群组的成员 </h2>
<table border="1">
<tr><th>用户ID</th><th>用户名</th><th colspan = "1" >操作</th></tr>
<%
for(FileBean file : UserList){
%>
<tr>
<td><%=file.getUserId() %></td>
<td><%=file.getUserName() %></td>
<% out.println("<td><a href = \"/ShareSpace/DeleteUser?userid=" + file.getUserId() + "\"> 删除该成员  </a></td>");%>
</tr>
<%
}
%>
</table>
<br>
<% out.println("<a href = \"/ShareSpace/AddUser.jsp?" + "\"> 添加新成员  </a>");%>
 	<br>
 	<br>
  <a href="/ShareSpace/Group.jsp">返回您加入的群组页</a>
</center>
</body>
</html>