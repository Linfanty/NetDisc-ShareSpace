<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="demo.sharespace.bean.FileBean" %>
<%@ page import="demo.sharespace.dao.MyGroupDao" %>  
<%@ page import="demo.sharespace.dao.Group" %>  
<%@ page import="demo.sharespace.util.RequestUtils" %>    
<%@ page import="java.util.List" %>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>您加入的群组</title>
</head>

<body>
<center>
<%
MyGroupDao space = new MyGroupDao();
List<FileBean> fileList = space.getMyFileList(RequestUtils.getUserId(request));
%>

<form action="/ShareSpace/MyGroupList" method="post"></form>
<h2> 您加入的群组 </h2>
<table border="1">
<tr><th>群组名</th><th>用户ID</th><th>用户名</th><th colspan = "3" >操作</th></tr>
<%
for(FileBean file : fileList){
%>
<tr>
<td><%=file.getGroupName() %></td>
<td><%=file.getUserId() %></td>
<td><%=file.getUserName() %></td>
<% out.println("<td><a href = \"/ShareSpace/ExitGroup?GroupId=" + file.getGroupId() + "\"> 退出群组  </a></td>");%>
<% out.println("<td><a href = \"GroupUser.jsp?GroupId=" + file.getGroupId() + "\"> 查看群成员  </a></td>"); %>
<% out.println("<td><a href = \"/ShareSpace/ExitGroup?GroupId=" + file.getFileId() + "\"> 查看群文件 </a></td>"); %>
</tr>
<%
}
%>
</table>
<br>
  <a href="/ShareSpace/space/GroupSpace.jsp">返回群组页</a>
</center>
</body>
</html>