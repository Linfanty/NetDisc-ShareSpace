<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="demo.sharespace.bean.FileBean" %>
<%@ page import="demo.sharespace.dao.Space" %>  
<%@ page import="demo.sharespace.util.RequestUtils" %>    
<%@ page import="java.util.List" %>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<<body background="file:///F:/2018JAVA_WEB/ShareSpace/backgroud.png"  width="100%" height="100%" text="white" >
<center>
<%
Space space = new Space();
List<FileBean> fileList = space.getMyFileList(RequestUtils.getFileName(request));
%>
<h1> 输入搜索的文件名 </h1>
<form action="/ShareSpace/Search" method="post">
<input id="fileid" type="text" name="filename">
<input type="submit" value="search">
<table>
<tr><th>文件名</th><th>文件ID</th><th>文件描述</th><th>上传日期</th></tr>

<%
for(FileBean file : fileList){
%>
<tr>
<td><%=file.getFileName() %></td>
<td><%=file.getFileId() %></td>
<td><%=file.getFileDesc() %></td>
<td><%=file.getFileDate() %></td></tr>

<%
}
%>
</table>
</form>

</center>
</body>
</html>