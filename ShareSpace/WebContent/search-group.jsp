<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="demo.sharespace.bean.FileBean" %>
<%@ page import="demo.sharespace.dao.IntoGroup" %>  
<%@ page import="demo.sharespace.util.RequestUtils" %>    
<%@ page import="java.util.List" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>添加群组</title>
</head>
<body>
<center>
<form action="/ShareSpace/SearchGroup" method="post">
<h2> 请输入加入的群组名 </h2>
<input type = "text" name="groupname">
<input type = "submit" name = "搜索">
</form> 
</center>



<%IntoGroup space = new IntoGroup();
/// List<FileBean> fileList = space.getMyFileList( (String)session.getAttribute("groupname")); // 多此一举的复杂版本 name request到string session的转化
List<FileBean> fileList = space.getMyFileList( RequestUtils.getGroupName(request)); // RequesrUitls的简易版本 
%>

<center>
<h2> 搜索到的群组 </h2>
<!--  <form action="/ShareSpace/IntoGroup2" method="post"> !-->
<table border="1">
<tr><th>群组ID</th><th>群组名</th><th>群组描述</th><th>操作</th></tr>
<%
for(FileBean file : fileList){
%>
<tr>
<td><%=file.getGroupId() %></td>
<td><%=file.getGroupName() %></td>
<td><%=file.getGroupDesc() %></td>
<% out.println("<td><a href = \"/ShareSpace/IntoGroup2?GroupId=" + file.getGroupId() + "\"> 加入群组  </a></td>");%>

</tr>
<%
}
%>
</table>
  <a href="/ShareSpace/space/GroupSpace.jsp">返回群组页</a>

</center>
</body>
</html>