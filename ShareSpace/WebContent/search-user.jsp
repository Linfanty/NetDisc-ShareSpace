<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="demo.sharespace.bean.FileBean" %>
<%@ page import="demo.sharespace.dao.Space" %>  
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
Search_Space space = new Search_Space();
List<FileBean> fileList = space.getMyFileList(RequestUtils.getUserName(request)); ///
%>
<h1> 输入用户ID </h1>
<form action="/ShareSpace/Search_User" method="post">
<input id="username" type="text" name="username">
<input type="submit" value="search">
<table>
<tr><th>用户名</th><th>文件名</th><th>文件ID</th><th>文件路径</th></tr>

<%
for(FileBean file : fileList){
%>
<tr>
<td><%=file.getUserName() %></td>
<td><%=file.getFileName() %></td>
<td><%=file.getFileId() %></td>
<td><%=file.getFilePath() %></td></tr>

<%
}
%>
</table>
</form>

</center>
</body>
</html>